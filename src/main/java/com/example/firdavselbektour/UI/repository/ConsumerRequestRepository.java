package com.example.firdavselbektour.UI.repository;

import com.example.firdavselbektour.UI.entity.ConsumerRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRequestRepository extends JpaRepository<ConsumerRequestEntity,Long> {
}
