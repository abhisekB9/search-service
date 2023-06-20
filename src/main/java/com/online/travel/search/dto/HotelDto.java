package com.online.travel.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    private long id;

    private String hotelName;

    private String hotelDescription;

    private BigDecimal hotelPrice;
}

