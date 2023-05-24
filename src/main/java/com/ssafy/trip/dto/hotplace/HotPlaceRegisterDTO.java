package com.ssafy.trip.dto.hotplace;

import com.ssafy.trip.domain.hotplace.FileInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class HotPlaceRegisterDTO {

    private String loginId;

    private Long id;

    private String title;

    private String content;

    private List<FileInfo> fileInfos;

    private LocalDateTime modifiedDate;

    private String url;
    private Double lat;
    private Double lon;
    private String placeName;
    private String roadName;

}
