package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.hotplace.HotPlaceComment;

import java.util.List;

public interface HotPlaceCommentCustomRepository {

    public List<HotPlaceComment> getCommentsByBoardId(Long boardId);

}
