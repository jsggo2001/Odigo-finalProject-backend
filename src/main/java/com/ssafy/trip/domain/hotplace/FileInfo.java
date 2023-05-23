package com.ssafy.trip.domain.hotplace;

import com.ssafy.trip.domain.board.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class FileInfo {
    private String saveFolder;
    private String originFile;
    private String saveFile;


    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hot_place_id")
    private HotPlace hotPlace;

}
