package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Income;


public interface IncomeMapper  extends MyMapper<Income>{

	List<Income> incomeList(Income income);

	void deletebyId(Integer id);

	List<Income> getAll(Income income);

	void updateSelective(Income income);

	List<Income> grounpByYear(Income income);

	List<Income> grounpByMonth(Income income);

	List<Income> grounpByDay(Income income);

	List<Income> grounpByquarter(Income income);
	
	
}
