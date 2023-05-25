package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.user.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByUserId(Long userId);
    Optional<Auth> findById(Long authId);

    void deleteByUserId(Long userID);
}
