/*
package com.online.travel.search.service;

import com.online.travel.search.config.Consumer;
import com.online.travel.search.dto.HotelDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class SearchHotelServiceTest {

    @Mock
    private Consumer consumer;

    @InjectMocks
    private SearchHotelService service;

    @Test
    public void when_user_search_hotel_it_should_return_hotel() {
        HotelDto dto = HotelDto.builder().hotelDescription("Desc").hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build();
        HotelDto savedDto = service.searchHotel(dto);
        Assert.assertEquals(savedDto.getHotelName(),dto.getHotelName());
    }
}
*/
