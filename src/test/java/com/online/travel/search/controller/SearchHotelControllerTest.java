package com.online.travel.search.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.travel.search.dto.HotelDto;
import com.online.travel.search.service.SearchHotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchHotelController.class)
public class SearchHotelControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchHotelService service;

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/hotel/search")
                        .content(asJsonString(HotelDto.builder().hotelDescription("desc")
                                .hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}