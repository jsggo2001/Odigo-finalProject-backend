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

@CrossOrigin
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

    @GetMapping("/{id}")
    private ResponseEntity<Board> getBoard(@PathVariable Long id){
        Board board = boardService.getBoard(id);
        boardService.increaseBoardCnt(id);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerBoard(@RequestBody BoardDTO BoardDTO){
        Board board = new Board();
        System.out.println(BoardDTO);

        board.setUser(BoardDTO.getUser());
        board.setTitle(BoardDTO.getTitle());
        board.setContent(BoardDTO.getContent());
        board.setCount(BoardDTO.getCount());

        boardService.registBoard(board);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{boardId}")
    private ResponseEntity<?> updateBoard(@RequestBody BoardFormDTO boardFormDTO){
        System.out.println(boardFormDTO);
        boardService.updateBoard(boardFormDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{boardId}")
    private ResponseEntity<?> removeBoard(@PathVariable Long boardId){
        boardService.removeBoard(boardId);
        return ResponseEntity.ok().build();
    }


}
