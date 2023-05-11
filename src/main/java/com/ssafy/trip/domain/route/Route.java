package com.ssafy.trip.domain.route;

import javax.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    private String name;

    private int sequence;

    private float latitude;

    private float longitude;

}
