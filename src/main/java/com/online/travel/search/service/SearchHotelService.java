package com.online.travel.search.service;

import com.online.travel.search.dto.HotelDto;
import org.springframework.stereotype.Service;

@Service
public class SearchHotelService {
    public HotelDto searchHotel(HotelDto hotel)
    {
        return hotel;
    }
}