package com.kwlz.rms.controller;

import com.kwlz.rms.dto.DetailedRoomDto;
import com.kwlz.rms.dto.RoomDto;
import com.kwlz.rms.dto.RoomResponse;
import com.kwlz.rms.dto.SearchErrorMessage;
import com.kwlz.rms.sevice.RoomService;
import com.kwlz.rms.dto.RoomsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Search Rooms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successful")
    })
    public ResponseEntity<RoomsResponse<RoomDto>> getRooms() {
        return ResponseEntity.ok(roomService.fetchRooms());
    }

    @GetMapping("{number}")
    @Operation(summary = "Find room with given number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch successful")
    })
    public ResponseEntity<RoomResponse<DetailedRoomDto>> getRoom(@PathVariable("number") final Integer number) {
        final var o = SearchErrorMessage.builder().field(null).value(null).message(null).build();
        return ResponseEntity.ok(roomService.fetchRoom(number));
    }

}