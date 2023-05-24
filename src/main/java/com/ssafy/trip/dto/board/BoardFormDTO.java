package com.ssafy.trip.dto.board;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardFormDTO {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime modifiedDate;

}