package com.kwlz.rms.repository;

import com.kwlz.rms.repository.model.UserRoom;
import com.kwlz.rms.repository.model.UserRoomKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, UserRoomKey> {
}
