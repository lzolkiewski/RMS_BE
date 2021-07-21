package com.kwlz.rms.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchErrorMessage extends ErrorMessage {

    String field;
    String value;

    @Builder
    public SearchErrorMessage(final String field, final String value, final String message) {
        super(message);
        this.field = field;
        this.value = value;
    }

}