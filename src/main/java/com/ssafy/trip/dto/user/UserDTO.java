package com.ssafy.trip.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserDTO {

    public UserDTO() {
    }

    public UserDTO(Long id, String loginId, String mail, String name, String password, String phoneNumber, String nickName, LocalDate createdDate) {
        this.id = id;
        this.loginId = loginId;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.createdDate = createdDate;
    }

    private Long id;
    private String loginId;
    private String mail;
    private String name;
    private String password;
    private String phoneNumber;
    private String nickName;
    private LocalDate createdDate;
}
