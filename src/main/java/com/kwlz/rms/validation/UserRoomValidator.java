package com.kwlz.rms.validation;

import com.kwlz.rms.dto.ErrorMessage;
import com.kwlz.rms.dto.SearchErrorMessage;
import com.kwlz.rms.dto.UserRoomSearchDto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserRoomValidator extends Validator<UserRoomSearchDto> {

    @Override
    public Set<ErrorMessage> validate(UserRoomSearchDto userRoomSearchDto) {
        return Stream.of(areDatesValid(userRoomSearchDto.getDateFrom(), userRoomSearchDto.getDateTo()))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private SearchErrorMessage areDatesValid(final Date dateFrom, final Date dateTo) {
        final var currentDate = new Date();
        if (dateFrom.before(currentDate) && dateFrom.before(dateTo)) {
            return null;
        }

        return SearchErrorMessage.builder()
                .field("Date")
                .value("from: " + dateFrom + ", to: " + dateTo)
                .message("Dates are invalid.")
                .build();
    }

}