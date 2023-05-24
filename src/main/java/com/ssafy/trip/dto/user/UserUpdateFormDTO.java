package com.ssafy.trip.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserUpdateFormDTO {
	private Long id;
	
	private String loginId;
	
	private String mail;
	
	private String name;
	
	private String password;

	private String phoneNumber;

	private String nickName;
	
}
