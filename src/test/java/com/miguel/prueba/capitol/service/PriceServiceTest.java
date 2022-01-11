package com.miguel.prueba.capitol.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.miguel.prueba.capitol.mappers.PriceMapper;
import com.miguel.prueba.capitol.mappers.PriceMapperImpl;
import com.miguel.prueba.capitol.models.entity.Price;
import com.miguel.prueba.capitol.repository.PriceRepository;

@SpringBootTest
class PriceServiceTest {
	
	@Mock
    private PriceRepository priceRepository;
	
	@Mock
    private PriceMapper iPriceMapper;

    @InjectMocks 
    private PriceServiceImpl priceService = new PriceServiceImpl();
    
    @InjectMocks 
    private PriceMapperImpl priceMapper = new PriceMapperImpl();

    @BeforeEach
    void setMockOutput() {
        
    }

    @DisplayName("Test OK")
    @Test
    void testFindByParams() {
    	
    	LocalDateTime applicationDate = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
    	
    	LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 00, 00, 00);
    	LocalDateTime endDate = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);
    	
    	Price price = new Price(1L, startDate, endDate, "EUR", 35455L, 1L,0, 35.50);
    	when(priceRepository.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(Optional.of(price));
    	when(iPriceMapper.toDto(Mockito.any(Price.class))).thenReturn(priceMapper.toDto(price));
    	
        assertEquals(priceMapper.toDto(price), priceService.findByParams(applicationDate, 35445L, 1L));
    }
    
    @DisplayName("Test Error")
    @Test
    void testFindByParamsNotFound(){
    	
    	// Comprobamos que devuelve una expceción al recibir un optional vacío
    	LocalDateTime applicationDate = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
    	
    	when(priceRepository.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(Optional.empty());
    	
        assertThrows(NoSuchElementException.class, () -> {
        	priceService.findByParams(applicationDate, 35445L, 1L);
    	});
        
    }
    
    

}
