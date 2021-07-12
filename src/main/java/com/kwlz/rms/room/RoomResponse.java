package com.kwlz.rms.room;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoomResponse<T> {

    T room;

}