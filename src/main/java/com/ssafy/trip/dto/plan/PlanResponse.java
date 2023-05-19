package com.ssafy.trip.dto.plan;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PlanResponse {

    private Long id;
    private String name;
    private int recommend;
    private String description;
}
