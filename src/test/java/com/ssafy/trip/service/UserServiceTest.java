package com.ssafy.trip.service;

import com.ssafy.trip.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void save() {
        User user = User.builder().loginId("test").mail("asd@asd").password("1234")
                .phoneNumber("123-1231-1231").nickName("sadw2").build();

        userService.join(user);
    }

}