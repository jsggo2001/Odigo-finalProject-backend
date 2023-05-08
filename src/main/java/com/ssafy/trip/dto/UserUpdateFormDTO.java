package com.ssafy.trip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateFormDTO {
	
	private String loginId;
	
	private String mail;
	
	private String name;
	
	private String password;

	private String phoneNumber;

	private String nickName;
	
}
