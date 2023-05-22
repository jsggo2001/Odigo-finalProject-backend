package com.ssafy.trip.dto.user;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserRequest {
    private String userId;
    private String userPw;
}
