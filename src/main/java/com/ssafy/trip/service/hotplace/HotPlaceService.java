package com.ssafy.trip.service.hotplace;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.hotplace.HotPlace;
import com.ssafy.trip.dto.board.BoardDTO;
import com.ssafy.trip.dto.board.BoardFormDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceRegisterDTO;
import com.ssafy.trip.repository.board.BoardRepository;
import com.ssafy.trip.repository.hotplace.HotBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HotPlaceService {

    private final HotBoardRepository hotBoardRepository;
    @Transactional
    public boolean registBoard(HotPlaceDTO boardDTO){

        HotPlace hotBoard = new HotPlace();
        System.out.println(boardDTO);

        hotBoard.setUser(boardDTO.getUser());
        hotBoard.setTitle(boardDTO.getTitle());
        hotBoard.setContent(boardDTO.getContent());
        hotBoard.setCount(0L);
        hotBoard.setHeart(0L);
        try {
            hotBoardRepository.registerBoard(hotBoard);
            log.debug("registHotplace: "+ hotBoard);
            return true;
        }catch (Exception e){
            log.debug("registHotplace: ",e.getMessage());
            return false;
        }
    }

    public List<HotPlace> getBoards(){return hotBoardRepository.findAll(); }

    public HotPlace getBoard(Long id){return hotBoardRepository.getBoard(id); }
    @Transactional
    public List<HotPlace> getBoardsByTitle(String title){
        return hotBoardRepository.getBoardsByName(title);
    }

    @Transactional
    public void updateBoard(HotPlaceRegisterDTO hotPlaceRegisterDTO){
        System.out.println(hotPlaceRegisterDTO.getId());
        HotPlace hotPlace = hotBoardRepository.findById(hotPlaceRegisterDTO.getId()).get();
        hotPlace.setContent(hotPlaceRegisterDTO.getContent());
        hotPlace.setTitle(hotPlaceRegisterDTO.getTitle());
    }

    @Transactional
    public void removeBoard(Long id){
        hotBoardRepository.deleteById(id);
    }

    @Transactional
    public void increaseBoardCnt(Long id){
        HotPlace board = hotBoardRepository.getBoard(id);
        System.out.println(board);
        Long hit = board.getCount();
        board.setCount(hit+1);
    }


}
