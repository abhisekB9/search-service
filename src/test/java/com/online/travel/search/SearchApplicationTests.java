package com.online.travel.search;

import com.online.travel.search.dto.HotelDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
//@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class SearchApplicationTests {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testCreateCricketer() throws Exception {
        HotelDto dto = HotelDto.builder().hotelDescription("Desc").hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build();

        ResponseEntity<HotelDto> response = restTemplate.postForEntity(createURLWithPort("/hotel/search"), dto, HotelDto.class);

		HotelDto actual = response.getBody();

        assertTrue(actual.getHotelName().equals(dto.getHotelName()));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}