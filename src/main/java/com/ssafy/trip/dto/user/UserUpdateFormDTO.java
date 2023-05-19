package com.ssafy.trip.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateFormDTO {
	private Long id;
	
	private String loginId;
	
	private String mail;
	
	private String name;
	
	private String password;

	private String phoneNumber;

	private String nickName;
	
}
