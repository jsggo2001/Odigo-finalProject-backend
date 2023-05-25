package com.ssafy.trip.controller;

import com.ssafy.trip.domain.plan.Plan;
import com.ssafy.trip.domain.plan.Route;
import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.plan.PlanModifyDTO;
import com.ssafy.trip.dto.plan.PlanRegisterDTO;
import com.ssafy.trip.dto.plan.PlanResponse;
import com.ssafy.trip.jwt.JwtTokenProvider;
import com.ssafy.trip.service.UserService;
import com.ssafy.trip.service.plan.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@Slf4j
public class PlanController {

    private final PlanService planService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping
    public ResponseEntity registerPlan(@RequestBody PlanRegisterDTO dto, HttpServletRequest request) {
        dto.setLogin_id(jwtTokenProvider.getLoginId(request));

        System.out.println(dto);
        planService.save(dto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePlan(@PathVariable Long id) {
        planService.delete(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("modify")
    public ResponseEntity modifyPlan(@RequestBody PlanModifyDTO dto, HttpServletRequest request) throws Exception {
        if (!planService.delete(dto.getId_for_delete())){
            throw new Exception("삭제 요청을 수행하지 못했습니다");
        }
        dto.setLogin_id(jwtTokenProvider.getLoginId(request));
        System.out.println(dto);
        planService.save(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Plan> getPlans(HttpServletRequest request) {
        String loginId = jwtTokenProvider.getLoginId(request);
        User user = userService.findByLoginId(loginId).get();
        System.out.println(planService.getPlansByUserId(user.getId()));
        return planService.getPlansByUserId(user.getId());
    }

    @GetMapping("{planId}")
    public PlanResponse getPlan(@PathVariable long planId) {
        System.out.println(planId);
        Plan plan = planService.getPlan(planId);
        List<Route> routes = plan.getRoutes();
        routes.sort((a, b)->a.getSequence() - b.getSequence());
        PlanResponse res = PlanResponse.builder().id(plan.getId()).name(plan.getName()).endDate(plan.getEndDate())
                .routes(routes).startDate(plan.getStartDate()).description(plan.getDescription())
                .build();
        return res;
    }
}