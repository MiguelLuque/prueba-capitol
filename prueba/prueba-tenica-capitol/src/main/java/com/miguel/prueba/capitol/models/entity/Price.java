package com.miguel.prueba.capitol.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "prices")
public class Price implements Serializable {

	private static final long serialVersionUID = -5323149401158101756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "start_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;

	@Column(name = "end_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime endDate;

	private String currency;

	@Column(name = "product_id")
	private Long product;

	@Column(name = "brand_id")
	private Long brand;

	private Integer priority;

	private Double value;

}
