package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.hotplace.HotPlaceComment;
import com.ssafy.trip.repository.board.CommentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotPlaceCommentRepository extends JpaRepository<HotPlaceComment, Long>, HotPlaceCommentCustomRepository {


}
