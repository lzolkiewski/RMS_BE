package com.kwlz.rms.validation;

import com.kwlz.rms.dto.ErrorMessage;
import com.kwlz.rms.dto.RoomSearchDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RoomValidator extends Validator<RoomSearchDto> {

    @Override
    public Set<ErrorMessage> validate(RoomSearchDto roomSearchDto) {
        return Collections.emptySet();
    }



}