package com.ssafy.trip.repository.board;

import com.ssafy.trip.domain.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
