package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.hotplace.HotPlace;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HotBoardCustomRepositoryImpl implements HotBoardCustomRepository {

    @NonNull
    private final EntityManager em;


    @Override
    public List<HotPlace> getBoardsByName(String titleName) {

        return em.createQuery(("select b from HotPlace b " +
                        "where b.title = :title"), HotPlace.class)
                .setParameter("title", titleName)
                .getResultList();
    }

    @Override
    public HotPlace getBoard(Long id) {
        return em.find(HotPlace.class, id);
    }

    @Override
    public void registerBoard(HotPlace board) {
        em.persist(board);
    }

}
