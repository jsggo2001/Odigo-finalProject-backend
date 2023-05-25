package com.ssafy.trip.domain.plan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    @JsonIgnore
    private Plan plan;

    public void addPlan(Plan plan) {
        this.plan = plan;
        this.plan.getRoutes().add(this);
    }

    private long preId;
    private int sequence;
    private String place_name;
    private float x;
    private float y;
    private int cost;
    private String address_name;
    private String place_url;
    private int day;
    private String content;
    private String phone;
    private String category_group_name;



}
