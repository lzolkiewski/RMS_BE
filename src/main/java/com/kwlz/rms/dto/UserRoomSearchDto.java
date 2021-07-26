package com.kwlz.rms.dto;

import lombok.Value;

import java.util.Date;

@Value
public class UserRoomSearchDto {

    Date dateFrom;
    Date dateTo;

}