package com.test.join2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reple {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer repleNum;
	
	private String repleCon;
	
	private LocalDateTime repleDate;
	
	// N:1 관계를 가지고 있음을 알려줌
	@ManyToOne
	private Board board;
	
}
