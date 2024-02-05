package com.example.app.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WeightBmi {

	private int weightId;
	private int userId;
	private double userWeight;
	private double bmi;
	private double healthyWeight;
	
	//再表示用にHTMLのtype="date"の型に合わせる
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;

}