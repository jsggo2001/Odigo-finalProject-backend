package com.ssafy.trip.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    private String name;
    private int sequence;
    private float latitude;
    private float longitude;
    private float Plan_name;
}
