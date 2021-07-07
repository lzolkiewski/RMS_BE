package com.kwlz.rms.room;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class RoomsResponse<T> {

    Set<T> rooms;

}