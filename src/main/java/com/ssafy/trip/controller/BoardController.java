package com.ssafy.trip.controller;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.user.User;
import com.ssafy.trip.dto.board.BoardDTO;
import com.ssafy.trip.dto.board.BoardFormDTO;
import com.ssafy.trip.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
                boardList.add(new BoardDTO(findBoard.getId(), checkUser(findBoard.getUser()),
                        findBoard.getTitle(), findBoard.getContent(), findBoard.getCount(),
                        findBoard.getCreatedDate(), findBoard.getModifiedDate())));
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    private String checkUser(User user) {
        if (user == null) {
            return "null";
        } else {
            return user.getNickName();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<BoardDTO> getBoard(@PathVariable Long id){
        Board board = boardService.getBoard(id);
        BoardDTO dto = BoardDTO.builder()
                .id(board.getId())
                .nickName(board.getUser().getNickName())
                .count(board.getCount())
                .content(board.getContent())
                .title(board.getTitle())
                .modifiedDate(board.getModifiedDate())
                .build();
        boardService.increaseBoardCnt(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerBoard(HttpServletRequest request, @RequestBody BoardFormDTO boardFormDTO){

        boardService.registBoard(request, boardFormDTO);
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
