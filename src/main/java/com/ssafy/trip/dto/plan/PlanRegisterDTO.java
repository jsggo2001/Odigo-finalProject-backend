package com.ssafy.trip.dto.plan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlanRegisterDTO {

    private String name;

    private String description;

    private int recommend = 0;

    private RouteRequest[] routes;

    public PlanRegisterDTO(String name, String description, RouteRequest[] routes) {
        this.name = name;
        this.description = description;
        this.routes = routes;
    }
}
