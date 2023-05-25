package com.ssafy.trip.service.plan;

import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.domain.plan.Route;
import com.ssafy.trip.dto.plan.RouteRequest;
import com.ssafy.trip.dto.plan.RouteResponse;
import com.ssafy.trip.repository.plan.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RouteService {

    private final RouteRepository routeRepository;

    @Transactional
    public RouteResponse save(RouteRequest request, Plan plan, int idx) {

        Route route = Route.builder().place_name(request.getPlace_name()).sequence(idx).day(request.getGroup())
                        .x(request.getX()).y(request.getY()).content(request.getContent()).phone(request.getPhone())
                .address_name(request.getAddress_name()).place_url(request.getPlace_url()).cost(request.getCost())
                .category_group_name(request.getCategory_group_name()).preId(request.getId())
                .build();
        route.addPlan(plan);
        System.out.println(route);
        routeRepository.save(route);

        return RouteResponse.builder().name(route.getPlace_name()).plan_name(plan.getName())
                .sequence(route.getSequence()).latitude(route.getX()).longitude(route.getY()).build();
    }

    @Transactional
    public void deleteByPlanId(Long planId) {
        routeRepository.deleteByPlanId(planId);
    }
}
