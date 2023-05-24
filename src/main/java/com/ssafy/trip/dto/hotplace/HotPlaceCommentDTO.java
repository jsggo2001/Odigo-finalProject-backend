package com.ssafy.trip.dto.hotplace;

import com.ssafy.trip.domain.hotplace.HotPlace;
import com.ssafy.trip.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotPlaceCommentDTO {
    private Long id;

    private String loginId;
    private String nickName;
    private Long boardId;

    private String content;

    private Long heart; // 좋아요수

    private String filePath; // img

    private LocalDateTime modifiedDate;


}
