package com.ssafy.trip.dto.board;

import com.ssafy.trip.domain.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
