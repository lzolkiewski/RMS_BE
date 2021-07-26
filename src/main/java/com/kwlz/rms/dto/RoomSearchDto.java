package com.kwlz.rms.dto;

import lombok.Value;

import java.util.Date;

@Value
public class RoomSearchDto {

    Integer capacity;
    Float dailyCost;
    Integer floor;
    Float surface;

}