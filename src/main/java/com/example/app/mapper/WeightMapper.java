package com.example.app.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Weight;

@Mapper
public interface WeightMapper {

//表示
	//体重表示
	List<Weight> selectWeight(Weight userId, LocalDate date) throws Exception;
	//BMI表示
//	List<Weight> selectBmi(Weight userWeight, User height) throws Exception;
	
//登録
	//体重の登録
	void insertWeight(Weight userWeight) throws Exception;

	//BMIの登録
	void insertBmi(Weight bmi) throws Exception;
	
	
}