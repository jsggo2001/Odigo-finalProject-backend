package com.ssafy.trip.service;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.dto.board.CommentFormDTO;
import com.ssafy.trip.interceptor.NotFoundException;
import com.ssafy.trip.jwt.JwtTokenProvider;
import com.ssafy.trip.repository.board.CommentRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    @Transactional
    public void registerComment(HttpServletRequest request, CommentFormDTO commentFormDTO, Board board){


        String accessToken = request.getHeader("Access_token");
        System.out.println(accessToken);
        Claims accessClaims = jwtTokenProvider.getClaimsFormToken(accessToken);
        String loginId = (String) accessClaims.get("userId");
        System.out.println("loginId      =>  " + loginId);

        Comment comment = new Comment();
        comment.setHeart(0L);
        comment.setUser(userService.findByLoginId(loginId).get());
        comment.setBoard(board);
        comment.setContent(commentFormDTO.getContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    @Transactional
    public List<Comment> getCommentByBoardId(Long boardId){
        List<Comment> listById = commentRepository.getCommentsByBoardId(boardId);
        return listById;
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
