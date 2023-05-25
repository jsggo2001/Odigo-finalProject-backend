package com.ssafy.trip.domain.hotplace;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileInfo {

    @Lob
    @Column(length=10000, columnDefinition = "LONGBLOB")
    private String originFile;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hot_place_id")
    private HotPlace hotPlace;


}
