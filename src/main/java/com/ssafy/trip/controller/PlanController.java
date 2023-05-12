package com.ssafy.trip.controller;

import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping
    private void registerPlan(@ModelAttribute PlanRegisterDTO dto) {
        Plan plan = new Plan();

        plan.setName(dto.getName());
        plan.setDescription(dto.getDescription());
        plan.setRecommend(dto.getRecommend());

        planService.

    }


}
