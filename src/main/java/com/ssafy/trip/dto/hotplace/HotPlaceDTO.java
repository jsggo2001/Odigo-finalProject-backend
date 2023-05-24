package com.ssafy.trip.dto.hotplace;

import com.ssafy.trip.domain.hotplace.FileInfo;
import com.ssafy.trip.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotPlaceDTO {

        private Long id;

        private User user;

        private String title;

        private String content;

        private Long count; // 조회수
        private Long heart; // 좋아요수

        private List<String> fileInfos;

        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        private String url;
        private Double lat;
        private Double lon;
        private String placeName;
        private String roadName;
}
