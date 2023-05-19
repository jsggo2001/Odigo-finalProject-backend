package com.ssafy.trip.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;

    private Long userId;
    private String loginId;
    private Long boardId;

    private String content;

    private Long heart; // 좋아요수

    private String filePath; // img

    private LocalDateTime modifiedDate;

}
