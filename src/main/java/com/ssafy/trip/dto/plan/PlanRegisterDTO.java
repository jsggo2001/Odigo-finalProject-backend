package com.ssafy.trip.dto.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlanRegisterDTO {

    private String name;

    private String description;

    private int recommend = 0;

    private RouteRequest[] routes;

    private String login_id;



    private LocalDateTime start_date;

    private LocalDateTime end_date;
}
