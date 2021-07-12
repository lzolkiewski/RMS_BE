package com.kwlz.rms.room;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<RoomsResponse<RoomDto>> getRooms() {
        return ResponseEntity.ok(roomService.fetchRooms());
    }

    @GetMapping("{number}")
    public ResponseEntity<RoomResponse<DetailedRoomDto>> getRoom(@PathVariable("number") final Integer number) {
        return ResponseEntity.ok(roomService.fetchRoom(number));
    }

}