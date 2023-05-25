package com.ssafy.trip.dto.plan;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.trip.domain.plan.Route;
import com.ssafy.trip.domain.plan.UserPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class PlanResponse {

    private Long id;

    private String name;

    private List<Route> routes = new ArrayList<>();

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
