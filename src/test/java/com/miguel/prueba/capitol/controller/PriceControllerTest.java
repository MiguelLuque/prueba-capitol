package com.miguel.prueba.capitol.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.miguel.prueba.capitol.mappers.PriceMapperImpl;
import com.miguel.prueba.capitol.models.entity.Price;
import com.miguel.prueba.capitol.service.IPriceService;

@SpringBootTest
class PriceControllerTest {
	
	@Mock
    private IPriceService priceService;
	

    @InjectMocks 
    private PriceController priceController = new PriceController();
    
    @InjectMocks 
    private PriceMapperImpl priceMapper = new PriceMapperImpl();
      

    @BeforeEach
    void setMockOutput() {
        
    }

    @DisplayName("LocalDateTime dates test")
    @Test
    void testFindByParams() {
    	
    	LocalDateTime applicationDate = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
    	
    	LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 00, 00, 00);
    	LocalDateTime endDate = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);
    	
    	Price price = new Price(1L, startDate, endDate, "EUR", 35455L, 1L,0, 35.50);
    	when(priceService.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(priceMapper.toDto(price));
    	
        assertEquals(priceMapper.toDto(price), priceController.getPriceByParams(applicationDate, 35445L, 1L));
    }
    
    @DisplayName("String dates test")
    @Test
    void testFindByParamsV2() {
    	
    	String applicationDate = "2020-06-14 00:00:00";
    	
    	LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 00, 00, 00);
    	LocalDateTime endDate = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);
    	
    	Price price = new Price(1L, startDate, endDate, "EUR", 35455L, 1L,0, 35.50);
    	when(priceService.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(priceMapper.toDto(price));
    	
        assertEquals(priceMapper.toDto(price), priceController.getPriceByParams(applicationDate, 35445L, 1L));
    }
    
    
    

}
