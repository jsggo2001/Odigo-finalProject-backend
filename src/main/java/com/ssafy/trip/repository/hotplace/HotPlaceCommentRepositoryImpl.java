package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.hotplace.HotPlaceComment;
import com.ssafy.trip.repository.board.CommentCustomRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HotPlaceCommentRepositoryImpl implements HotPlaceCommentCustomRepository {

    @NonNull
    private final EntityManager em;

    @Override
    public List<HotPlaceComment> getCommentsByBoardId(Long boardId) {
        return em.createQuery(("select c from HotPlaceComment c " +
                        "where c.hotPlace.id = :boardId"), HotPlaceComment.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }

}
