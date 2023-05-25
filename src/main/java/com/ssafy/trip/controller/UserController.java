package com.ssafy.trip.controller;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.user.*;
import com.ssafy.trip.jwt.JwtTokenProvider;
import com.ssafy.trip.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

     private final UserService userService;
     private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    @PostMapping
    public ResponseEntity join(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("dto {}", userRegisterDTO);
        if(userService.findByLoginId(userRegisterDTO.getLoginId()).isPresent())
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userService.join(userRegisterDTO));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest userRequest) throws Exception {
        log.info("password {}", userRequest);
        return ResponseEntity
                .ok()
                .body(userService.doLogin(userRequest));
    }
    //Access Token을 재발급 위한 api
    @PostMapping("/issue")
    public ResponseEntity issueAccessToken(HttpServletRequest request) throws Exception {
        return ResponseEntity
                .ok()
                .body(userService.issueAccessToken(request));
    }

    // refresh 토큰 대신 인덱스를 반환하는 회원가입
//    @PostMapping("/joinindex")
//    public ResponseEntity join2(@RequestBody UserRequest userRequest) {
//        if(userService.findByLoginId(userRequest.getUserId()).isPresent())
//            return ResponseEntity.badRequest().build();
//        else
//            return ResponseEntity.ok(userService.registerIndex(userRequest));
//    }

    //Access Token을 재발급 위한 api (refresh 토큰 인덱스를 통한 재발급)
    @PostMapping("/issueindex")
    public ResponseEntity issueAccessToken2(HttpServletRequest request) throws Exception {
        return ResponseEntity
                .ok()
                .body(userService.issueAccessIndexToken(request));
    }

    // list 조회
//    @GetMapping
//    private ResponseEntity<List<UserDTO>> getList() {
//        List<User> findList = userService.findUsers();
//        List<UserDTO> results = new ArrayList<>();
//        findList.stream().forEach(findUser ->
//            results.add(new UserDTO(findUser.getId(), findUser.getLoginId(),
//                    findUser.getMail(), findUser.getName(), findUser.getPassword(), findUser.getPhoneNumber(),
//                    findUser.getNickName(), findUser.getCreatedDate())));
//        return new ResponseEntity<>(results, HttpStatus.OK);
//    }

    @PutMapping("/{userId}")
    private void update(@RequestBody UserUpdateFormDTO userUpdateFormDTO, @PathVariable Long userId) {
        userUpdateFormDTO.setId(userId);
        System.out.println(userUpdateFormDTO);
        userService.updateUser(userUpdateFormDTO);
    }

    // detail 조회
    @GetMapping("/detail")
    private ResponseEntity<UserDTO> getUser(HttpServletRequest request) {

        String userId = jwtTokenProvider.getLoginId(request);

        User findUser = userService.findByLoginId(userId).get();

        UserDTO result = new UserDTO(findUser.getId(), findUser.getLoginId(),
                findUser.getMail(), findUser.getName(), findUser.getPassword(), findUser.getPhoneNumber(),
                findUser.getNickName(), findUser.getCreatedDate());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    private void remove(@PathVariable Long userId) {
        System.out.println(userId);
        userService.remove(userId);
    }

    @PostMapping("/user/test")
    public Map userResponseTest() {
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }
}
