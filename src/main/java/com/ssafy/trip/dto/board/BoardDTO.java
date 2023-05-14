package com.ssafy.trip.dto.board;

import com.ssafy.trip.domain.user.User;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

        private Long id;

        private User user;

        private String title;

        private String content;

        private Long count; // 조회수

        private LocalDate createdDate;

        private LocalDate modifiedDate;

}
