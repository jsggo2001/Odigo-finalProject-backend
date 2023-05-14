package com.ssafy.trip.dto.plan;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RouteResponse {

    private String plan_name;
    private String name;
    private int sequence;
    private float latitude;
    private float longitude;
}
