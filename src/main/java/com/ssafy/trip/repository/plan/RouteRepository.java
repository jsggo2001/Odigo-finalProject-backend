package com.ssafy.trip.repository.plan;

import com.ssafy.trip.domain.plan.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
