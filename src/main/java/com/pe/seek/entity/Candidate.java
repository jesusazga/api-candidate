package com.pe.seek.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	private String email;
	private String gender;
	private BigDecimal salaryExpected;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String processDate;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String modificationDate;
	
}
