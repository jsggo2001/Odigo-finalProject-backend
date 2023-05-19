package com.ssafy.trip.dto.board;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class BoardFormDTO {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime modifiedDate;

}