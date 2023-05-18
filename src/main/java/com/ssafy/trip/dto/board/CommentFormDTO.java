package com.ssafy.trip.dto.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentFormDTO {
    private Long id;

    private Long userId;
    private Long boardId;

    private String content;

    private Long heart; // 좋아요수

    private String filePath; // img

    private LocalDateTime modifiedDate;


}
