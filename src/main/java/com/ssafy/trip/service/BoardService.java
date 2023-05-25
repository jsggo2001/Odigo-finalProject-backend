package com.ssafy.trip.service;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.dto.board.BoardDTO;
import com.ssafy.trip.dto.board.BoardFormDTO;
import com.ssafy.trip.jwt.JwtTokenProvider;
import com.ssafy.trip.repository.board.BoardRepository;
import com.ssafy.trip.repository.board.CommentRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final CommentService commentService;

    @Transactional
    public boolean registBoard(HttpServletRequest request, BoardFormDTO boardFormDTO){

        String accessToken = request.getHeader("Access_token");
        System.out.println(accessToken);
        Claims accessClaims = jwtTokenProvider.getClaimsFormToken(accessToken);
        String loginId = (String) accessClaims.get("userId");
        System.out.println("loginId      =>  " + loginId);

        Board board = new Board();
        System.out.println(boardFormDTO);


        board.setUser(userService.findByLoginId(loginId).get());
        board.setTitle(boardFormDTO.getTitle());
        board.setContent(boardFormDTO.getContent());

        board.setCount(0L);

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

    public Board getBoard(Long id){return boardRepository.getBoard(id); }
    @Transactional
    public List<Board> getBoardsByTitle(String title){
        return boardRepository.getBoardsByName(title);
    }

    @Transactional
    public void updateBoard(BoardFormDTO boardFormDto){
        System.out.println(boardFormDto.getId());
        Board board = boardRepository.findById(boardFormDto.getId()).get();
        board.setContent(boardFormDto.getContent());
        board.setTitle(boardFormDto.getTitle());
    }

    @Transactional
    public void removeBoard(Long id){

        // 댓글먼저 삭제하기
        List<Comment> listById = commentService.getCommentByBoardId(id);

        for(Comment comm : listById){
          //  try {
                commentService.deleteComment(comm.getId());
           // }catch(Exception e){}
        }
        //보드삭제
        boardRepository.deleteById(id);
    }

    @Transactional
    public void increaseBoardCnt(Long id){
        Board board = boardRepository.getBoard(id);
        System.out.println(board);
       Long hit = board.getCount();
       board.setCount(hit+1);
    }



}
