package com.miguel.prueba.capitol.service;

import java.time.LocalDateTime;

import com.miguel.prueba.capitol.models.dto.PriceDto;

public interface IPriceService {

	public PriceDto findByParams(LocalDateTime startDate, Long productId, Long brandId);	
	
}
