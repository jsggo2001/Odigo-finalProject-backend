package com.ssafy.trip.service.plan;

import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.repository.plan.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public void save(Plan plan) {
        planRepository.save(plan);
    }

}
