package com.miguel.prueba.capitol.models.dto;

import lombok.Data;

@Data
public class PriceDto {

	private Long id;

	private String startDate;

	private String endDate;

	private Long product;

	private Long brand;

	private Double value;
}
