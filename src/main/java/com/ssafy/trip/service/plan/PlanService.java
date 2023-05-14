package com.ssafy.trip.service.plan;

import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.dto.plan.PlanResponse;
import com.ssafy.trip.dto.plan.RouteRequest;
import com.ssafy.trip.repository.plan.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final RouteService routeService;

    @Transactional
    public PlanResponse save(PlanRegisterDTO dto) {

        Plan plan = new Plan();

        plan.setName(dto.getName());
        plan.setDescription(dto.getDescription());
        plan.setRecommend(dto.getRecommend());
        planRepository.save(plan);

        saveRoutes(dto.getRoutes());
        return PlanResponse.builder().id(plan.getId())
                .name(plan.getName())
                .description(plan.getDescription())
                .recommend(plan.getRecommend())
                .build();
    }

    @Transactional
    public void saveRoutes(RouteRequest[] routeRequests) {
        for (RouteRequest routeRequest : routeRequests) {
            routeService.save(routeRequest);
        }

    }

}
