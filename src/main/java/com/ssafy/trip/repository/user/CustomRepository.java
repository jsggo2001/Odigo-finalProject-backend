package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.user.User;

import java.util.List;

public interface CustomRepository {
    void customSave(User user);

    User customFindOne(Long id);

    List<User> customFindAll();

    User customGetUser(String loginId);

    List<User> customGetUserByName(String loginId);
}
