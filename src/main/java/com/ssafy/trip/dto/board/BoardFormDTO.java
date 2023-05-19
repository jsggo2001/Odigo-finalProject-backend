package com.ssafy.trip.dto.board;

<<<<<<< HEAD
=======
import com.ssafy.trip.domain.User;
import lombok.Data;
>>>>>>> develop
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