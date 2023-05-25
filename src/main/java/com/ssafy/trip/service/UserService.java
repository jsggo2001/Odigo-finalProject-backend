package com.ssafy.trip.service;

import com.ssafy.trip.domain.user.Auth;
import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.user.*;
import com.ssafy.trip.jwt.JwtTokenProvider;
import com.ssafy.trip.repository.user.AuthRepository;
import com.ssafy.trip.repository.user.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional //readonly false
    public TokenResponse join(UserRegisterDTO dto) {
        User user = new User();
        user.setLoginId(dto.getLoginId());
        user.setMail(dto.getMail());
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setNickName(dto.getNickName());
        validateDuplicateUser(user);
        userRepository.save(user);

        String accessToken = jwtTokenProvider.createAccessToken(user.getLoginId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getLoginId());

        Auth auth = Auth.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();

        authRepository.save(auth);

        return TokenResponse.builder()
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN(refreshToken)
                .build();
    }

    @Transactional
    public TokenResponse doLogin(UserRequest userRequest) throws Exception {

        User user = userRepository.findByLoginId(userRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Auth auth = authRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Token 이 존재하지 않습니다."));
        if (!passwordEncoder.matches(userRequest.getUserPw(), user.getPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = "";
        String refreshToken = auth.getRefreshToken();   //DB에서 가져온 Refresh 토큰

        //refresh 토큰은 유효 할 경우
        //사실 이것도 로그인을 하는것이라면 refresh 토큰이 유효한지 파악안하고 그냥 둘다 재발급 하는게 나을듯?
        if (jwtTokenProvider.isValidRefreshToken(refreshToken)) {
            accessToken = jwtTokenProvider.createAccessToken(user.getLoginId()); //Access Token 새로 만들어서 줌
            return TokenResponse.builder()
                    .ACCESS_TOKEN(accessToken)
                    .REFRESH_TOKEN(refreshToken)
                    .nickName(user.getNickName())
                    .build();
        } else {
            //둘 다 새로 발급
            accessToken = jwtTokenProvider.createAccessToken(user.getLoginId());
            refreshToken = jwtTokenProvider.createRefreshToken(user.getLoginId());
            auth.refreshUpdate(refreshToken);   //DB Refresh 토큰 갱신
        }

        return TokenResponse.builder()
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN(refreshToken)
                .build();
    }

    // Duplicate check
    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.customGetUserByName(user.getLoginId());
        if (findUsers.size() != 0) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    // 회원 전체 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOne(Long userId) {
        return userRepository.customFindOne(userId);
    }

    public User findUserByName(String loginId) {
        return userRepository.customGetUser(loginId);
    }

    // 회원 수정
    @Transactional
    public void updateUser(UserUpdateFormDTO userFormDto) {
        User findUser = userRepository.customGetUser(userFormDto.getLoginId());
        findUser.setMail(userFormDto.getMail());
        findUser.setName(userFormDto.getName());
        findUser.setNickName(userFormDto.getNickName());
        findUser.setPassword(userFormDto.getPassword());
        findUser.setPhoneNumber(userFormDto.getPhoneNumber());
    }

    @Transactional
    public void remove(Long id) {
        authRepository.deleteByUserId(id);

        User user = findOne(id);
        user.getUserPlans().forEach(userPlan -> {userPlan.setUser(null);});
        user.getBoards().forEach(board -> {board.setUser(null);});
        user.getHotPlaces().forEach(hotPlace -> {hotPlace.setUser(null);});
        userRepository.deleteById(id);
    }


    public TokenResponse issueAccessToken(HttpServletRequest request) throws Exception {
        String accessToken = jwtTokenProvider.resolveAccessToken(request);
        String refreshToken = jwtTokenProvider.resolveRefreshToken(request);
        System.out.println("accessToken = " + accessToken);
        System.out.println("refreshToken = " + refreshToken);
        //accessToken이 만료됐고 refreshToken이 맞으면 accessToken을 새로 발급(refreshToken의 내용을 통해서)
        if (!jwtTokenProvider.isValidAccessToken(accessToken)) {  //클라이언트에서 토큰 재발급 api로의 요청을 확정해주면 이 조건문은 필요없다.
            System.out.println("Access 토큰 만료됨");
            if (jwtTokenProvider.isValidRefreshToken(refreshToken)) {     //들어온 Refresh 토큰이 유효한지
                System.out.println("Refresh 토큰은 유효함");
                Claims claimsToken = jwtTokenProvider.getClaimsToken(refreshToken);
                String userId = (String) claimsToken.get("userId");
                Optional<User> user = userRepository.findByLoginId(userId);
                String tokenFromDB = authRepository.findByUserId(user.get().getId()).get().getRefreshToken();
                System.out.println("tokenFromDB = " + tokenFromDB);
                if (refreshToken.equals(tokenFromDB)) {   //DB의 refresh토큰과 지금들어온 토큰이 같은지 확인
                    System.out.println("Access 토큰 재발급 완료");
                    accessToken = jwtTokenProvider.createAccessToken(userId);
                } else {
                    //DB의 Refresh토큰과 들어온 Refresh토큰이 다르면 중간에 변조된 것임
                    System.out.println("Refresh Token Tampered");
                    //예외발생
                    throw new Exception("변조된 토큰입니다.");
                }
            } else if (refreshToken.equals("noneToken")) {
                throw new Exception("리프레시 토큰이 안날라옴");
            } else {
                //입력으로 들어온 Refresh 토큰이 유효하지 않음
                System.out.println("토큰 만료");
                throw new IllegalStateException("토큰이 유효하지 않습니다");
            }
        }
        return TokenResponse.builder()
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN(refreshToken)
                .build();
    }

    //회원 가입하면 refresh 토큰의 데이터베이스 인덱스를 반환
    public TokenIndexResponse registerIndex(UserRequest userRequest) {
        User user = User.builder()
                .loginId(userRequest.getUserId())
                .password(passwordEncoder.encode(userRequest.getUserPw()))
                .build();
        userRepository.save(user);

        String accessToken = jwtTokenProvider.createAccessToken(user.getLoginId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getLoginId());
        Auth auth = Auth.builder()
                .user(user)
                .accessToken(accessToken)       //인덱스와 그것에 대당하는 access토큰이 동시에 만족돼야 재발급하도록
                .refreshToken(refreshToken)
                .build();
        Auth saveAuth = authRepository.save(auth);
        return TokenIndexResponse.builder()
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN_INDEX(saveAuth.getId())
                .build();
    }

    //refresh 토큰의 인덱스를 통한 검증
    public TokenIndexResponse issueAccessIndexToken(HttpServletRequest request) {
        String accessToken = jwtTokenProvider.resolveAccessToken(request);
        Long refreshTokenIndex = jwtTokenProvider.resolveRefreshIndexToken(request);
        if (jwtTokenProvider.isOnlyExpiredToken(accessToken)) {  //만료만 된 토큰이라면
            //잘못된 토큰이 아니라 만료만 된 토큰이므로 올바른 사용자는 맞다 하지만 access토큰이 만료된것 뿐
            Optional<Auth> findAuth = authRepository.findById(refreshTokenIndex);
            String refreshTokenFromDB = findAuth.get().getRefreshToken();
            Claims claimsToken = jwtTokenProvider.getClaimsToken(refreshTokenFromDB);
            String userId = (String) claimsToken.get("userId");
            if (jwtTokenProvider.isValidRefreshToken(refreshTokenFromDB)) {
                System.out.println("Access 토큰 재발급 완료 by 인덱스");
                accessToken = jwtTokenProvider.createAccessToken(userId);
            } else {
                //예외발생
                System.out.println("Refresh Token Tampered");
            }
        }
        return TokenIndexResponse.builder()
                .ACCESS_TOKEN(accessToken)
                .REFRESH_TOKEN_INDEX(refreshTokenIndex)
                .build();
    }

    public Optional<User> findByLoginId(String loginID) {
        return userRepository.findByLoginId(loginID);
    }


}
