package com.ssafy.trip.controller;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.board.BoardDTO;
import com.ssafy.trip.dto.board.BoardFormDTO;
import com.ssafy.trip.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    private ResponseEntity<List<BoardDTO>> getBoards(){
        List<Board> boardLists = boardService.getBoards();
        List<BoardDTO> boardList = new ArrayList<>();

        boardLists.stream().forEach(findBoard ->
                boardList.add(new BoardDTO(findBoard.getId(), findBoard.getUser(),
                        findBoard.getTitle(), findBoard.getContent(), findBoard.getCount(),
                        findBoard.getCreatedDate(), findBoard.getModifiedDate())));
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }


    @PostMapping
    private void registerBoard(@ModelAttribute BoardDTO BoardDTO){
        Board board = new Board();
        System.out.println(BoardDTO);

        board.setUser(BoardDTO.getUser());
        board.setTitle(BoardDTO.getTitle());
        board.setContent(BoardDTO.getContent());
        board.setCount(BoardDTO.getCount());

        boardService.registBoard(board);
    }

    @PutMapping("/{boardId}")
    private void updateBoard(@ModelAttribute BoardFormDTO boardFormDTO){
        boardService.updateBoard(boardFormDTO);
    }

    @DeleteMapping("/{boardId}")
    private void removeBoard(@PathVariable Long boardId){
        boardService.removeBoard(boardId);
    }


}
