//package com.ssafy.trip.service;
//
//import com.ssafy.trip.domain.board.Board;
//import com.ssafy.trip.domain.board.Comment;
//import com.ssafy.trip.domain.user.User;
//import com.ssafy.trip.dto.board.CommentFormDTO;
//import com.ssafy.trip.dto.user.UserRegisterDTO;
//import com.ssafy.trip.repository.board.BoardRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//@SpringBootTest
//@Transactional
//@Commit
//class CommentServiceTest {
//
//    @Autowired
//    UserService userService;
//    @Autowired
//    BoardRepository boardRepository;
//    @Autowired
//    CommentService commentService;
//    @Autowired
//    EntityManager em;
//
//    @Test
//    void registerTest() {
//        UserRegisterDTO userDto = UserRegisterDTO.builder().loginId("test2").mail("asd@asd").password("1234")
//                .phoneNumber("123-1231-1231").nickName("sadw2").build();
//
//        userService.join(userDto);
//        User user = userService.findByLoginId(userDto.getLoginId()).get();
//        Board board = new Board();
//        boardRepository.save(board);
//
//        em.flush();
//        em.clear();
//
//        Comment comment = new Comment();
//        CommentFormDTO dto = new CommentFormDTO();
//        dto.setContent("asdasdd");
//        dto.setUserId(user.getId());
//        dto.setBoardId(board.getId());
//
//        commentService.registerComment(dto);
//    }
//
//    @Test
//    void getCommentTest() {
//        UserRegisterDTO userDto = UserRegisterDTO.builder().loginId("test").mail("asd@asd").password("1234")
//                .phoneNumber("123-1231-1231").nickName("sadw2").build();
//
//        userService.join(userDto);
//        User user = userService.findByLoginId(userDto.getLoginId()).get();
//
//        Board board = new Board();
//        boardRepository.save(board);
//
//        em.flush();
//        em.clear();
//
//        Comment comment = new Comment();
//        CommentFormDTO dto = new CommentFormDTO();
//        dto.setContent("asdasdd");
//        dto.setUserId(user.getId());
//        dto.setBoardId(board.getId());
//
//        commentService.registerComment(dto);
//    }
//
//}