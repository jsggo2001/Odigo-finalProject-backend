package com.ssafy.trip.repository.board;

import com.ssafy.trip.domain.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentCustomRepository {

    public List<Comment> getCommentsByBoardId(Long boardId);

}
