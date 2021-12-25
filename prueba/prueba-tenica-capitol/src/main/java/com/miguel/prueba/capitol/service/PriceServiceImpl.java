package com.miguel.prueba.capitol.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miguel.prueba.capitol.mappers.PriceMapper;
import com.miguel.prueba.capitol.models.dto.PriceDto;
import com.miguel.prueba.capitol.models.entity.Price;
import com.miguel.prueba.capitol.repository.PriceRepository;

@Service
public class PriceServiceImpl implements IPriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private PriceMapper priceMapper;
	
	@Override
	@Transactional(readOnly = true)
	public PriceDto findByParams(LocalDateTime startDate, Long productId, Long brandId) {
	
		Price price = priceRepository.findByParams(startDate, productId, brandId).orElse(null);
		
		return priceMapper.toDto(price);
	}

}