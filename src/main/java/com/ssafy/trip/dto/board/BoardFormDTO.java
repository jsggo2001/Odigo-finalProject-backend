package com.ssafy.trip.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class BoardFormDTO {

    private Long id;

    private String title;

    private String content;

    private LocalDate modifiedDate;

}