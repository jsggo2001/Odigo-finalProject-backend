package com.ssafy.trip.service;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.user.UserRegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void save() {

        UserRegisterDTO dto = UserRegisterDTO.builder().loginId("test").mail("asd@asd").password("1234")
                .phoneNumber("123-1231-1231").nickName("sadw2").build();
        userService.join(dto);
    }

}