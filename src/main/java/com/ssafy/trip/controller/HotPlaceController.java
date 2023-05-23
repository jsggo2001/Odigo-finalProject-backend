package com.ssafy.trip.controller;

import com.ssafy.trip.domain.hotplace.FileInfo;
import com.ssafy.trip.domain.hotplace.HotPlace;
import com.ssafy.trip.dto.hotplace.HotPlaceDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceRegisterDTO;
import com.ssafy.trip.dto.hotplace.HotPlaceResponseDTO;
import com.ssafy.trip.service.hotplace.HotPlaceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/hotplace")
@RequiredArgsConstructor
public class HotPlaceController {

    private final HotPlaceService hotPlaceService;
    private final Logger logger = LoggerFactory.getLogger(HotPlace.class);
    private String uploadPath;

    @GetMapping
    private ResponseEntity<List<HotPlaceResponseDTO>> getBoards() {
        List<HotPlace> boardLists = hotPlaceService.getBoards();
        List<HotPlaceResponseDTO> boardList = new ArrayList<>();

        boardLists.stream().forEach(findBoard ->
                boardList.add(new HotPlaceResponseDTO(findBoard.getId(), findBoard.getUser().getLoginId(),
                        findBoard.getTitle(), findBoard.getContent(), findBoard.getCount(),
                        findBoard.getHeart(), findBoard.getFileInfos(),
                        findBoard.getModifiedDate())));
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<HotPlaceResponseDTO> getBoard(@PathVariable Long id) {
        HotPlace hotPlace = hotPlaceService.getBoard(id);
        HotPlaceResponseDTO dto = HotPlaceResponseDTO.builder()
                .content(hotPlace.getContent())
                .loginId(hotPlace.getUser().getLoginId())
                .heart(hotPlace.getHeart())
                .fileInfos(hotPlace.getFileInfos())
                .count(hotPlace.getCount())
                .modifiedDate(hotPlace.getModifiedDate())
                .id(hotPlace.getId())
                .title(hotPlace.getTitle())
                .build();


        hotPlaceService.increaseBoardCnt(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> registerBoard(HttpServletRequest request, @RequestBody HotPlaceDTO hotPlaceDTO) throws IOException {


        hotPlaceService.registBoard(request, hotPlaceDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{boardId}")
    private ResponseEntity<?> updateBoard(@RequestBody HotPlaceRegisterDTO boardFormDTO) {
        System.out.println(boardFormDTO);
        hotPlaceService.updateBoard(boardFormDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{boardId}")
    private ResponseEntity<?> removeBoard(@PathVariable Long boardId) {
        hotPlaceService.removeBoard(boardId);
        return ResponseEntity.ok().build();
    }


}
