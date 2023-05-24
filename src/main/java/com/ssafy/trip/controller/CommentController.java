package com.ssafy.trip.controller;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.dto.board.CommentDTO;
import com.ssafy.trip.dto.board.CommentFormDTO;
import com.ssafy.trip.service.BoardService;
import com.ssafy.trip.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final BoardService boardService;

    @GetMapping("/list/{boardId}")
    private ResponseEntity<List<CommentDTO>> getComments(@PathVariable Long boardId){

        System.out.println("comment getComments============");
        List<CommentDTO> commentList = new ArrayList<>();
        List<Comment> comments = boardService.getBoard(boardId).getComments();
//        List<Comment> comments = commentService.getComments();
//        List<CommentDTO> commentList = new ArrayList<>();
//
        comments.stream().forEach(comment ->
                commentList.add(new CommentDTO(comment.getId(),
                        comment.getUser().getLoginId(),
                        comment.getUser().getNickName(),
                        comment.getBoard().getId(),
                        comment.getContent(), comment.getHeart(),
                        comment.getFilePath(),
                        comment.getModifiedDate())));

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    private ResponseEntity<CommentDTO> getComment(@PathVariable Long commentId){
        System.out.println("comment getComment============");
        Comment comment = commentService.getComment(commentId);
        CommentDTO commentDto = new CommentDTO();
        commentDto.setId(commentId);
        commentDto.setBoardId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setFilePath(comment.getFilePath());
        commentDto.setHeart(comment.getHeart());
        commentDto.setLoginId(comment.getUser().getLoginId());
        commentDto.setBoardId(comment.getBoard().getId());
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerComment(HttpServletRequest request, @RequestBody CommentFormDTO commentFormDTO){
        Board board = boardService.getBoard(commentFormDTO.getBoardId());
        commentService.registerComment(request, commentFormDTO, board);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    private ResponseEntity<?> updateComment(@RequestBody CommentFormDTO commentFormDTO){
        commentService.updateComment(commentFormDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    private ResponseEntity<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{commentId}")
    private ResponseEntity<?> increaseHeartCnt(@PathVariable Long commentId){
        boardService.increaseBoardCnt(commentId);
        return ResponseEntity.ok().build();
    }

}
