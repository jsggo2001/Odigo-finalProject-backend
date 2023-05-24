package com.ssafy.trip.domain.hotplace;


import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.domain.user.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class HotPlaceComment {
    @Id
    @GeneratedValue
    @Column(name="comment_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hot_place_id")
    private HotPlace hotPlace;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @CreatedDate
    @Column(name="created_date", updatable = false)
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long heart;

    private String filePath; // img
}
