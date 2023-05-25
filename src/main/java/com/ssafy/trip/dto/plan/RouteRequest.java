package com.ssafy.trip.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouteRequest {
    private long id;
    private String place_name;
    private float x;
    private float y;
    private int cost;
    private String address_name;
    private String place_url;
    private int group;
    private String content;
    private String phone;
    private String category_group_name;
}
