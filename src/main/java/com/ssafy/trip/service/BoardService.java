package com.ssafy.trip.service;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.board.BoardFormDTO;
import com.ssafy.trip.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public boolean registBoard(Board board){
        try {
            boardRepository.registerBoard(board);
            log.debug("registBoard: "+ board);
            return true;
        }catch (Exception e){
            log.debug("registBoard: ",e.getMessage());
            return false;
        }
    }

    public List<Board> getBoards(){return boardRepository.findAll(); }

    @Transactional
    public List<Board> getBoardsByTitle(String title){
        return boardRepository.getBoardsByName(title);
    }

    @Transactional
    public void updateBoard(BoardFormDTO boardFormDto){
        Board board = boardRepository.findById(boardFormDto.getId()).get();
        board.setContent(boardFormDto.getContent());
        board.setTitle(boardFormDto.getTitle());
    }

    @Transactional
    public void removeBoard(Long id){
        boardRepository.deleteById(id);
    }




}
