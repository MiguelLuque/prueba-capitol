package com.miguel.prueba.capitol.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.miguel.prueba.capitol.models.dto.PriceDto;
import com.miguel.prueba.capitol.models.entity.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {	
	
	/**
	 * To dto.
	 * 
	 * 	Cambiamos a string las fechas para la salida pues suele ser más facil
	 * 	trabajar con ellas para los consumidores
	 *
	 * @param target the target
	 * @return the price dto
	 */
	@Mapping(target = "startDate", source = "target.startDate", dateFormat = "yyyy-MM-dd HH:mm")
	@Mapping(target = "endDate", source = "target.endDate", dateFormat = "yyyy-MM-dd HH:mm")
	PriceDto toDto(Price target);

}
