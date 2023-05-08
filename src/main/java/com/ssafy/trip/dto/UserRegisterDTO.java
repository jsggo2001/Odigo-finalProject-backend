package com.ssafy.trip.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterDTO {

    private String loginId;

    private String mail;

    private String name;

    private String password;

    private String phoneNumber;

    private String nickName;
}
