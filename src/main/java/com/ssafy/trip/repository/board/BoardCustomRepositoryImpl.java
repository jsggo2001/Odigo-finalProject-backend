package com.ssafy.trip.repository.board;

import com.ssafy.trip.domain.User;
import com.ssafy.trip.domain.board.Board;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    @NonNull
    private final EntityManager em;

    @Override
    public List<Board> getBoardsByName(String titleName) {

        return em.createQuery(("select b from Board b " +
                "where b.title = :title"),Board.class)
                .setParameter("title", titleName)
                .getResultList();

    }
    @Override
    public Board getBoard(Long id) {
        return em.find(Board.class, id);
    }
    @Override
    public void registerBoard(Board board){
        em.persist(board);
    }
}
