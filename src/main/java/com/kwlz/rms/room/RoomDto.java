package com.kwlz.rms.room;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoomDto {

    Integer number;
    Integer capacity;
    Float dailyCost;
    Integer floor;
    byte[] image;

}