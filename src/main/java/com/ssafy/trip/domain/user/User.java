package com.ssafy.trip.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.plan.UserPlan;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	@Column(name = "login_id")
	private String loginId;

	private String mail;

	private String name;

	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "nick_name")
	private String nickName;

	@CreatedDate
	@Column(name = "created_date")
	private LocalDate createdDate;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Board> boards = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserPlan> userPlans = new ArrayList<>();
}
