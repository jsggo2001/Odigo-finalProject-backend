package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomRepository {
    Optional<User> findByLoginId(String loginId);
}
