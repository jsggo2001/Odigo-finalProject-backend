package com.ssafy.trip.controller;

import com.ssafy.trip.domain.hotplace.HotPlace;
import com.ssafy.trip.dto.hotplace.HotPlaceDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceRegisterDTO;
import com.ssafy.trip.service.hotplace.HotPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotplace")
@RequiredArgsConstructor
public class HotPlaceController {

    private final HotPlaceService hotPlaceService;

    @GetMapping
    private ResponseEntity<List<HotPlaceDTO>> getBoards(){
        List<HotPlace> boardLists = hotPlaceService.getBoards();
        List<HotPlaceDTO> boardList = new ArrayList<>();

        boardLists.stream().forEach(findBoard ->
                boardList.add(new HotPlaceDTO(findBoard.getId(), findBoard.getUser(),
                        findBoard.getTitle(), findBoard.getContent(), findBoard.getCount(),
                        findBoard.getHeart(), findBoard.getFileInfos(),
                        findBoard.getCreatedDate(), findBoard.getModifiedDate())));
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<HotPlace> getBoard(@PathVariable Long id){
        HotPlace hotPlace = hotPlaceService.getBoard(id);
        hotPlaceService.increaseBoardCnt(id);
        return new ResponseEntity<>(hotPlace, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerBoard(@RequestBody HotPlaceDTO hotPlaceDTO){

        hotPlaceService.registBoard(hotPlaceDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{boardId}")
    private ResponseEntity<?> updateBoard(@RequestBody HotPlaceRegisterDTO boardFormDTO){
        System.out.println(boardFormDTO);
        hotPlaceService.updateBoard(boardFormDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{boardId}")
    private ResponseEntity<?> removeBoard(@PathVariable Long boardId){
        hotPlaceService.removeBoard(boardId);
        return ResponseEntity.ok().build();
    }
    
    
}
