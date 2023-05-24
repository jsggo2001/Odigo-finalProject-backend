package com.ssafy.trip.dto.hotplace;

import lombok.Data;

@Data
public class HotPlaceCommentFormDTO {
    private Long id;

    private Long boardId;

    private String content;

    private Long heart; // 좋아요수

    private String filePath; // img

}
