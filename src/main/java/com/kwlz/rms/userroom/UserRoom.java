package com.kwlz.rms.userroom;

import com.kwlz.rms.room.Room;
import com.kwlz.rms.roomstatus.RoomStatus;
import com.kwlz.rms.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_room", schema = "rms")
public class UserRoom {

    @EmbeddedId
    private UserRoomKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @MapsId("roomId")
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne
    @MapsId("roomStatusId")
    @JoinColumn(name = "room_status_id")
    private RoomStatus roomStatus;

    @Column(name = "date_from", columnDefinition = "DATE", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", columnDefinition = "DATE", nullable = false)
    private Date dateTo;

}
