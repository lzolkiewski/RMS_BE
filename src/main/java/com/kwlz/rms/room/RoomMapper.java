package com.kwlz.rms.room;

import com.kwlz.rms.roomimages.RoomImage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class RoomMapper {

    public DetailedRoomDto mapToDetailedRoomDto(final Room room) {
        return Optional.ofNullable(room)
                .map(item -> DetailedRoomDto.builder()
                        .number(item.getNumber())
                        .capacity(item.getCapacity())
                        .floor(item.getFloor())
                        .dailyCost(item.getDailyCost())
                        .description(item.getDescription())
                        .surface(item.getSurface())
                        .images(getImages(item.getRoomImages()))
                        .build())
                .orElse(null);
    }

    private Set<byte[]> getImages(final Set<RoomImage> roomImages) {
        return Optional.ofNullable(roomImages)
                .map(items -> items.stream()
                        .filter(Objects::nonNull)
                        .map(RoomImage::getImage)
                        .collect(Collectors.toSet()))
                .orElseGet(Collections::emptySet);
    }

    public RoomDto mapToRoomDto(final Room room) {
        return Optional.ofNullable(room)
                .map(item -> RoomDto.builder()
                        .number(item.getNumber())
                        .capacity(item.getCapacity())
                        .floor(item.getFloor())
                        .dailyCost(item.getDailyCost())
                        .image(getFirstImage(item.getRoomImages()))
                        .build())
                .orElse(null);
    }

    private byte[] getFirstImage(final Set<RoomImage> roomImages) {
        return Optional.ofNullable(roomImages)
                .flatMap(items -> items.stream()
                        .filter(Objects::nonNull)
                        .findFirst()
                        .map(RoomImage::getImage))
                .orElse(null);
    }

}