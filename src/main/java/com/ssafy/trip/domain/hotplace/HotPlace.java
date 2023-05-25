package com.ssafy.trip.domain.hotplace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class HotPlace {

    @Id
    @GeneratedValue
    @Column(name = "hot_place_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    private User user;

    @Column(length = 1000)
    private String content;

    private Long count; // 조회수
    private Long heart; // 좋아요수

    @JsonIgnore
    @OneToMany(mappedBy ="hotPlace")
    private List<FileInfo> fileInfos = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    private String url;
    private Double lat;
    private Double lon;
    private String placeName;
    private String roadName;

    @JsonIgnore
    @OneToMany(mappedBy ="hotPlace")
    private List<HotPlaceComment> comments = new ArrayList<>();

}