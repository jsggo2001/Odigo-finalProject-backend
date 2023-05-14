package com.ssafy.trip.dto.plan;

import com.ssafy.trip.domain.plan.Route;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanRegisterDTO {

    private String name;

    private String description;

    private int recommend = 0;

    private RouteRequest[] routes;

    public PlanRegisterDTO(String name, String description, int recommend) {
        this.name = name;
        this.description = description;
        this.recommend = recommend;
    }
}
