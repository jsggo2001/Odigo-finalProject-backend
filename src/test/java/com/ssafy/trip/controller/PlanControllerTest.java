package com.ssafy.trip.controller;

import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.dto.plan.RouteRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class PlanControllerTest {

    @Autowired
    PlanController planController;

    @Autowired
    EntityManager em;

    @Test
    void registerPlan() {

        RouteRequest[] routes = new RouteRequest[3];

        routes[0] = new RouteRequest("route1",1,(float)123.323,(float)142.24231);
        routes[1] = new RouteRequest("route2",2,(float)123.323,(float)142.24231);
        routes[2] = new RouteRequest("route3",3,(float)123.323,(float)142.24231);

        PlanRegisterDTO dto = new PlanRegisterDTO("test","test", routes);

        System.out.println(planController.registerPlan(dto));

    }
}