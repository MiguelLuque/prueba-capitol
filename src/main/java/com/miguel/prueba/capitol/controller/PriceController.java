package com.miguel.prueba.capitol.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.prueba.capitol.models.dto.PriceDto;
import com.miguel.prueba.capitol.service.IPriceService;

/**
 * The Class PriceController.
 */
@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired
	private IPriceService priceService;

	private static final DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 * Gets the price by params.
	 *
	 * @param startDate the start date
	 * @param productId the product id
	 * @param brandId the brand id
	 * @return the price by params
	 */
	@GetMapping("/price")
	@ResponseStatus(HttpStatus.OK)
	public PriceDto getPriceByParams(
			@RequestParam(name = "start_date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(name = "product_id", required = true) Long productId,
			@RequestParam(name = "brand_id", required = true) Long brandId) {
		return priceService.findByParams(startDate, productId, brandId);
	}

	

	/**
	 * Gets the price by params.
	 * 
	 * Este endpoint es igual al anterior pero aceptando un string con formato
	 *
	 * @param startDate the start date
	 * @param productId the product id
	 * @param brandId the brand id
	 * @return the price by params
	 */
	@GetMapping("/v2/price")
	@ResponseStatus(HttpStatus.OK)
	public PriceDto getPriceByParams(@RequestParam(name = "start_date", required = true) String startDate,
			@RequestParam(name = "product_id", required = true) Long productId,
			@RequestParam(name = "brand_id", required = true) Long brandId) {

		LocalDateTime startDateTime = LocalDateTime.parse(startDate, dt);

		return priceService.findByParams(startDateTime, productId, brandId);
	}
}
