package com.kwlz.rms.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RoomRepository extends JpaRepository<Room, BigDecimal> {
}
