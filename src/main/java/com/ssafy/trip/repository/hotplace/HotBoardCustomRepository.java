package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.hotplace.HotPlace;

import java.util.List;

public interface HotBoardCustomRepository{

    public List<HotPlace> getBoardsByName(String titleName);
    public HotPlace getBoard(Long id);
    public void registerBoard(HotPlace board);

}
