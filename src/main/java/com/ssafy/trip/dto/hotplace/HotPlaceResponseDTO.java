package com.ssafy.trip.dto.hotplace;

import com.ssafy.trip.domain.hotplace.FileInfo;
import com.ssafy.trip.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotPlaceResponseDTO {

        private Long id;
        private String nickName;
        private String title;
        private String content;

        private Long count; // 조회수
        private Long heart; // 좋아요수

        private List<FileInfo> fileInfos;

        private LocalDateTime modifiedDate;

        private String url;
        private Double lat;
        private Double lon;
        private String placeName;
        private String roadName;
}
