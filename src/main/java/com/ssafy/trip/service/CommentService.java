package com.ssafy.trip.service;

import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.dto.board.CommentFormDTO;
import com.ssafy.trip.exception.NotFoundException;
import com.ssafy.trip.repository.board.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService;
    private final UserService userService;

    @Transactional
    public void registerComment(CommentFormDTO commentFormDTO){
        Comment comment = new Comment();
        comment.setHeart(0L);
        comment.setBoard(boardService.getBoard(commentFormDTO.getBoardId()));
        comment.setUser(userService.findOne(commentFormDTO.getUserId()));
        comment.setContent(commentFormDTO.getContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long commentId){
        return commentRepository.findById(commentId).orElseThrow(() -> new NotFoundException("댓글이 존재하지 않습니다."));
    }

    @Transactional
    public void updateComment(CommentFormDTO commentFormDTO){
        Comment comment = commentRepository.findById(commentFormDTO.getId()).get();
        comment.setContent(commentFormDTO.getContent());
    }

    @Transactional
    public void increaseHeartCnt(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NotFoundException("댓글이 존재하지 않습니다."));
        System.out.println("====comment: "+comment);
        Long cnt = comment.getHeart();
        comment.setHeart(cnt+1);
    }
}
