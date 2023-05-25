package com.ssafy.trip.controller;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.hotplace.HotPlace;
import com.ssafy.trip.domain.hotplace.HotPlaceComment;
import com.ssafy.trip.dto.board.CommentDTO;
import com.ssafy.trip.dto.board.CommentFormDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceCommentDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceCommentFormDTO;
import com.ssafy.trip.service.BoardService;
import com.ssafy.trip.service.CommentService;
import com.ssafy.trip.service.HotPlaceCommentService;
import com.ssafy.trip.service.hotplace.HotPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotcomment")
@RequiredArgsConstructor
public class HotPlaceCommentController {

    private final HotPlaceCommentService commentService;
    private final HotPlaceService boardService;

    @GetMapping("/list/{boardId}")
    private ResponseEntity<List<HotPlaceCommentDTO>> getComments(@PathVariable Long boardId){

        System.out.println("hotplace getComments============");
        List<HotPlaceCommentDTO> commentList = new ArrayList<>();
        List<HotPlaceComment> comments = boardService.getBoard(boardId).getComments();

        comments.stream().forEach(comment ->
                commentList.add(new HotPlaceCommentDTO(comment.getId(),
                        comment.getUser().getLoginId(),
                        comment.getUser().getNickName(),
                        comment.getHotPlace().getId(),
                        comment.getContent(), comment.getHeart(),
                        comment.getFileInfo(),
                        comment.getModifiedDate())));

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    private ResponseEntity<HotPlaceCommentDTO> getComment(@PathVariable Long commentId){
        System.out.println("comment getComment============");
        HotPlaceComment comment = commentService.getComment(commentId);
        HotPlaceCommentDTO commentDto = new HotPlaceCommentDTO();
        commentDto.setId(commentId);
        commentDto.setBoardId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setFileInfo(comment.getFileInfo());
        commentDto.setHeart(comment.getHeart());
        commentDto.setLoginId(comment.getUser().getLoginId());
        commentDto.setBoardId(comment.getHotPlace().getId());
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerComment(HttpServletRequest request, @RequestBody HotPlaceCommentFormDTO commentFormDTO){
        HotPlace board = boardService.getBoard(commentFormDTO.getBoardId());
        commentService.registerComment(request, commentFormDTO, board);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    private ResponseEntity<?> updateComment(@RequestBody HotPlaceCommentFormDTO commentFormDTO){
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
