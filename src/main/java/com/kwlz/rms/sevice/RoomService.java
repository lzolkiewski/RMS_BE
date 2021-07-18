package com.kwlz.rms.sevice;

import com.kwlz.rms.dto.DetailedRoomDto;
import com.kwlz.rms.dto.RoomDto;
import com.kwlz.rms.dto.RoomResponse;
import com.kwlz.rms.dto.RoomsResponse;
import com.kwlz.rms.repository.RoomRepository;
import com.kwlz.rms.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomsResponse<RoomDto> fetchRooms() {
        final var rooms = roomRepository.findAll();
        final var roomsDto = rooms.stream()
                .map(roomMapper::mapToRoomDto)
                .collect(Collectors.toSet());

        return RoomsResponse.<RoomDto>builder().rooms(roomsDto).build();
    }

    public RoomResponse<DetailedRoomDto> fetchRoom(final Integer number) {
        final var room = roomRepository.findByNumber(number).orElse(null);
        final var roomDto = roomMapper.mapToDetailedRoomDto(room);

        return RoomResponse.<DetailedRoomDto>builder().room(roomDto).build();
    }

}