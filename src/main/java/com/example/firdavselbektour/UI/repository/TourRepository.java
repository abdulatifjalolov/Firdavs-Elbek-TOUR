package com.example.firdavselbektour.UI.repository;

import com.example.firdavselbektour.UI.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TourRepository extends JpaRepository<TourEntity,Integer> {
    Optional<TourEntity> findByImgUUID(UUID imageUUID);
    boolean deleteByImgUUID(UUID imageUUID);
}
