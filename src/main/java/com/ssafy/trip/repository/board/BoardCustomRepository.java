package com.ssafy.trip.repository.board;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardCustomRepository{

    public List<Board> getBoardsByName(String titleName);
    public Board getBoard(Long id);
    public void registerBoard(Board board);

}
