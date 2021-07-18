package com.kwlz.rms.repository;

import com.kwlz.rms.repository.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, BigDecimal> {
    Optional<Room> findByNumber(final int number);
}
