package com.ssafy.trip.repository.plan;

import com.ssafy.trip.domain.plan.UserPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlanRepository extends JpaRepository<UserPlan, Long> {
}
