package com.ssafy.trip.controller;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.user.TokenResponse;
import com.ssafy.trip.dto.user.UserDTO;
import com.ssafy.trip.dto.user.UserRegisterDTO;
import com.ssafy.trip.dto.user.UserUpdateFormDTO;
import com.ssafy.trip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // login
    @PostMapping("/login")
    private boolean login(@RequestParam String loginId, @RequestParam String password) {

        User user = userService.findUserByName(loginId);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    // list 조회
    @GetMapping
    private ResponseEntity<List<UserDTO>> getList() {
        List<User> findList = userService.findUsers();
        List<UserDTO> results = new ArrayList<>();
        findList.stream().forEach(findUser ->
            results.add(new UserDTO(findUser.getId(), findUser.getLoginId(),
                    findUser.getMail(), findUser.getName(), findUser.getPassword(), findUser.getPhoneNumber(),
                    findUser.getNickName(), findUser.getCreatedDate())));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping
    private TokenResponse register(@ModelAttribute UserRegisterDTO form) {
        return userService.join(form);
    }

    @PutMapping("/{userId}")
    private void update(@ModelAttribute UserUpdateFormDTO userUpdateFormDTO) {
        userService.updateUser(userUpdateFormDTO);
    }

    // detail 조회
    @GetMapping("/{userId}")
    private ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        User findUser = userService.findOne(userId);

        UserDTO result = new UserDTO(findUser.getId(), findUser.getLoginId(),
                findUser.getMail(), findUser.getName(), findUser.getPassword(), findUser.getPhoneNumber(),
                findUser.getNickName(), findUser.getCreatedDate());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    private void remove(@PathVariable Long userId) {
        userService.remove(userId);
    }
}
