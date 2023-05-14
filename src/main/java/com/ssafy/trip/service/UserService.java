package com.ssafy.trip.service;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.UserUpdateFormDTO;
import com.ssafy.trip.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	@Transactional //readonly false
	public Long join(User user) {
		validateDuplicateUser(user);
		userRepository.save(user);
		return user.getId();
	}

	// Duplicate check
	private void validateDuplicateUser(User user)  {
		List<User> findUsers = userRepository.customGetUserByName(user.getLoginId());
		if(findUsers.size() != 0) {
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
		userRepository.deleteById(id);
	}
}
