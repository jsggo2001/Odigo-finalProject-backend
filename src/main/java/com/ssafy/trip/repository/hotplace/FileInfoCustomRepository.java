package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.hotplace.FileInfo;
import com.ssafy.trip.domain.hotplace.HotPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FileInfoCustomRepository {

    public List<FileInfo> getFilesByHotPlaceId(Long hotPlaceId);
}
