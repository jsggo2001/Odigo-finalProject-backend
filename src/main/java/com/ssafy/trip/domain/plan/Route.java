package com.ssafy.trip.domain.plan;

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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public void addPlan(Plan plan) {
        this.plan = plan;
        this.plan.getRoutes().add(this);
    }

    private String name;

    private int sequence;

    private float latitude;

    private float longitude;

    private int cost;

    private String address;

    private String url;

    private int day;
}
