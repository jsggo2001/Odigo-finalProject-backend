package com.ssafy.trip.controller;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.dto.plan.RouteRequest;
import com.ssafy.trip.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@Transactional
class PlanControllerTest {

    @Autowired
    PlanController planController;
    @Autowired
    UserService userService;
    @Autowired
    EntityManager em;

    @Test
    void registerPlan() {

        RouteRequest[] routes = new RouteRequest[3];

        User user = User.builder().loginId("test").mail("asd@asd").password("1234")
                .phoneNumber("123-1231-1231").nickName("sadw2").build();
        log.info("user {}", user);
        userService.join(user);


        routes[0] = new RouteRequest("route1",1,(float)123.323,(float)142.24231);
        routes[1] = new RouteRequest("route2",2,(float)123.323,(float)142.24231);
        routes[2] = new RouteRequest("route3",3,(float)123.323,(float)142.24231);

        PlanRegisterDTO dto = new PlanRegisterDTO("test","test", routes,user.getLoginId());
        PlanRegisterDTO dto2 = new PlanRegisterDTO("test2","test2", routes,user.getLoginId());

        System.out.println(planController.registerPlan(dto));
        System.out.println(planController.registerPlan(dto2));

    }
}