package com.ssafy.trip.controller;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.UserDTO;
import com.ssafy.trip.dto.UserRegisterDTO;
import com.ssafy.trip.dto.UserUpdateFormDTO;
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
    private void register(@ModelAttribute UserRegisterDTO form) {
        User user = new User();
        user.setLoginId(form.getLoginId());
        user.setMail(form.getMail());
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setNickName(form.getNickName());
        userService.join(user);
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
