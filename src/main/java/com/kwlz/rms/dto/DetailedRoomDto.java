package com.kwlz.rms.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class DetailedRoomDto {

    Integer number;
    Integer capacity;
    Float dailyCost;
    Float surface;
    Integer floor;
    String description;
    Set<byte[]> images;

}