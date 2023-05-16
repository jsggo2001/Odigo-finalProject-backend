package com.ssafy.trip.dto.board;

import com.ssafy.trip.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;


@Data
public class BoardFormDTO {

    private Long id;

    private String title;

    private String content;

    private LocalDate modifiedDate;

}