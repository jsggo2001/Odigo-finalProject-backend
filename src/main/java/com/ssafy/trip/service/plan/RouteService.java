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

        Route route = Route.builder().name(request.getPlace_name()).sequence(idx).day(request.getGroup())
                        .latitude(request.getX()).longitude(request.getY())
                .address(request.getAddress_name()).url(request.getPlace_url()).cost(request.getCost())
                .build();
        route.addPlan(plan);
        System.out.println(route);
        routeRepository.save(route);

        return RouteResponse.builder().name(route.getName()).plan_name(plan.getName())
                .sequence(route.getSequence()).latitude(route.getLatitude()).longitude(route.getLongitude()).build();
    }
}
