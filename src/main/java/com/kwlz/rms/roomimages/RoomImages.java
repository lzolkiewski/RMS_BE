package com.kwlz.rms.roomimages;

import com.kwlz.rms.room.Room;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "room_images", schema = "rms")
public class RoomImages {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_images_generator")
    @SequenceGenerator(name = "room_images_generator", sequenceName = "room_images_seq",
            schema = "rms", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private BigDecimal id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "image", nullable = false, unique = true)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}
