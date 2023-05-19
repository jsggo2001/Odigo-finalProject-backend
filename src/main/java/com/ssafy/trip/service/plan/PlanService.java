package com.ssafy.trip.service.plan;

import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.domain.plan.UserPlan;
import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.dto.plan.PlanResponse;
import com.ssafy.trip.dto.plan.RouteRequest;
import com.ssafy.trip.repository.plan.PlanRepository;
import com.ssafy.trip.repository.plan.UserPlanRepository;
import com.ssafy.trip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final UserPlanRepository userPlanRepository;
    private final UserService userService;
    private final RouteService routeService;

    @Transactional
    public PlanResponse save(PlanRegisterDTO dto) {

        Plan plan = new Plan();

        User findUser = userService.findUserByName(dto.getLogin_id());

        plan.setName(dto.getName());
        plan.setDescription(dto.getDescription());
        plan.setRecommend(dto.getRecommend());
        planRepository.save(plan);

        UserPlan newUserPlan = UserPlan.builder().user(findUser).plan(plan).build();
        userPlanRepository.save(newUserPlan);

        saveRoutes(dto.getRoutes(), plan);
        return PlanResponse.builder().id(plan.getId())
                .name(plan.getName())
                .description(plan.getDescription())
                .recommend(plan.getRecommend())
                .build();
    }

    @Transactional
    public void saveRoutes(RouteRequest[] routeRequests, Plan plan) {
        int idx = 0;
        for (RouteRequest routeRequest : routeRequests) {
            routeService.save(routeRequest , plan, idx);
            idx += 1;
        }

    }

}
