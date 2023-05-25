package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.plan.UserPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPlanRepository extends JpaRepository<UserPlan, Long> {
    List<UserPlan> findAllByUserId(Long userId);
    void deleteByPlanId(Long planId);
}
