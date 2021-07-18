package com.kwlz.rms.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoomResponse<T> {

    T room;

}