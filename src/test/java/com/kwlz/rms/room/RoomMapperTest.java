package com.kwlz.rms.room;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoomMapperTest {

    RoomMapper roomMapper = new RoomMapper();

    @ParameterizedTest
    @MethodSource("mapToDetailedRoomDto_shouldNotThrow_data")
    void mapToDetailedRoomDto_shouldNotThrow(final Room room) {
        assertDoesNotThrow(() -> roomMapper.mapToDetailedRoomDto(room));
    }

    private static Stream<Room> mapToDetailedRoomDto_shouldNotThrow_data() {
        return Stream.of(
                null,
                Room.builder().build(),
                Room.builder().roomImages(null).build(),
                Room.builder().roomImages(Collections.emptySet()).build(),
                Room.builder().roomImages(Collections.singleton(null)).build()
        );
    }

    @ParameterizedTest
    @MethodSource("mapToRoomDto_shouldNotThrow_data")
    void mapToRoomDto_shouldNotThrow(final Room room) {
        assertDoesNotThrow(() -> roomMapper.mapToRoomDto(room));
    }

    private static Stream<Room> mapToRoomDto_shouldNotThrow_data() {
        return Stream.of(
                null,
                Room.builder().build(),
                Room.builder().roomImages(null).build(),
                Room.builder().roomImages(Collections.emptySet()).build(),
                Room.builder().roomImages(Collections.singleton(null)).build()
        );
    }

}