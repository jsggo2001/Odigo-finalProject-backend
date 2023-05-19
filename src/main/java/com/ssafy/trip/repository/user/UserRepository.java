package com.ssafy.trip.repository.user;

import com.ssafy.trip.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, CustomRepository {
}
