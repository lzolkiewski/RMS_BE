package com.kwlz.rms.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserRoomKey implements Serializable {

    @Column(name = "user_id", nullable = false)
    private BigDecimal userId;

    @Column(name = "room_id", nullable = false)
    private BigDecimal roomId;

}
