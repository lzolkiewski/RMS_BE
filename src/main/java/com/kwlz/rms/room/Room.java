package com.kwlz.rms.room;

import com.kwlz.rms.roomimages.RoomImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "room", schema = "rms")
public class Room {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_generator")
    @SequenceGenerator(name = "room_generator", sequenceName = "room_seq",
            schema = "rms", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private BigDecimal id;

    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "daily_cost", nullable = false)
    private Float dailyCost;

    @Column(name = "surface", nullable = false)
    private Float surface;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "description", length = 512)
    private String description;

    @OneToMany(mappedBy = "room")
    Set<RoomImage> roomImages;

}