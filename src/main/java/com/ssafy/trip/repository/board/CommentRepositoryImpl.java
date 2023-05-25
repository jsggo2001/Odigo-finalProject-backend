package com.ssafy.trip.repository.board;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.board.Comment;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CommentRepositoryImpl implements CommentCustomRepository {

    @NonNull
    private final EntityManager em;

    @Override
    public List<Comment> getCommentsByBoardId(Long boardId) {
        return em.createQuery(("select c from Comment c " +
                        "where c.board.id = :boardId"), Comment.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }

}
