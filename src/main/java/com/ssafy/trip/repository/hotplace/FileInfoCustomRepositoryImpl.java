package com.ssafy.trip.repository.hotplace;

import com.ssafy.trip.domain.board.Comment;
import com.ssafy.trip.domain.hotplace.FileInfo;
import com.ssafy.trip.domain.hotplace.HotPlace;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FileInfoCustomRepositoryImpl implements FileInfoCustomRepository {

    @NonNull
    private final EntityManager em;

    @Override
    public List<FileInfo> getFilesByHotPlaceId(Long hotPlaceId) {
        return em.createQuery(("select f from FileInfo f " +
                        "where f.hotPlace.id = :hotPlaceId"), FileInfo.class)
                .setParameter("hotPlaceId", hotPlaceId)
                .getResultList();
    }

}
