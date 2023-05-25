package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.hotplace.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileInfoRepository  extends JpaRepository<FileInfo, Long>, FileInfoCustomRepository {
}
