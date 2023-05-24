package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.hotplace.HotPlace;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotBoardRepository extends JpaRepository<HotPlace,Long>, HotBoardCustomRepository {


}
