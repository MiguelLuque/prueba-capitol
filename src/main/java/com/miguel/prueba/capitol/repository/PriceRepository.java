package com.miguel.prueba.capitol.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguel.prueba.capitol.models.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query(value = "SELECT * FROM PRICES WHERE " + "START_DATE <= ?1 AND END_DATE > ?1 AND " + "PRODUCT_ID = ?2 AND BRAND_ID = ?3 "
			+ "ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
	Optional<Price> findByParams(LocalDateTime startDate, Long productId, Long brandId);

}
