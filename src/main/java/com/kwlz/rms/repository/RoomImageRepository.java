package com.kwlz.rms.repository;

import com.kwlz.rms.repository.model.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RoomImageRepository extends JpaRepository<RoomImage, BigDecimal> {
}