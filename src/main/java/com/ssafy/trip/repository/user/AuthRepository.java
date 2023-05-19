package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.user.Auth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepository extends JpaRepository<Auth, Long> {
}
