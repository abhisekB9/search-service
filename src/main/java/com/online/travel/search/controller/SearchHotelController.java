package com.online.travel.search.controller;

import com.online.travel.search.dto.HotelDto;
import com.online.travel.search.service.SearchHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class SearchHotelController {

    @Autowired
    private SearchHotelService service;

    @PostMapping("/search")
    public HotelDto searchHotel(@RequestBody HotelDto hotel){
        return service.searchHotel(hotel);
    }

    @GetMapping("/health")
    public String health(){
        return "Success";
    }
}
