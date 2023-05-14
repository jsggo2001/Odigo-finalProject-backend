package com.ssafy.trip.domain.plan;

import com.ssafy.trip.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Plan {
    @Id
    @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "plan")
    private List<Route> routes = new ArrayList<>();

    @OneToMany(mappedBy = "plan")
    private List<UserPlan> userPlans = new ArrayList<>();

    private int recommend;

    @Column(length = 1000)
    private String description;
}
