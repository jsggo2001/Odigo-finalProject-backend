package com.ssafy.trip.dto.plan;

import com.ssafy.trip.domain.User;
import lombok.AllArgsConstructor;
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

    private String login_id;

    public PlanRegisterDTO(String name, String description, RouteRequest[] routes, String login_id) {
        this.name = name;
        this.description = description;
        this.routes = routes;
        this.login_id = login_id;
    }
}
