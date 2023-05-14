package com.ssafy.trip.service.plan;

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
    public RouteResponse save(RouteRequest request) {

        Route route = Route.builder().name(request.getName()).sequence(request.getSequence())
                        .latitude(request.getLatitude()).longitude(request.getLongitude()).build();
        routeRepository.save(route);

        return RouteResponse.builder().name(route.getName()).plan_name(route.getPlan().getName())
                .sequence(route.getSequence()).latitude(route.getLatitude()).longitude(route.getLongitude()).build();
    }
}
