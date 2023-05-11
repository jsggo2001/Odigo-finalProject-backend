package com.ssafy.trip.domain.plan;

import com.ssafy.trip.domain.User;

import javax.persistence.*;

@Entity
public class UserPlan {

    @Id @GeneratedValue
    @Column(name = "user_plan_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;
}
