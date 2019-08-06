package com.winit.service;

import java.util.List;

import com.winit.entity.pojo.Income;


public interface IncomeService {

	void delete(Integer id);

	List<Income> incomeList(Income income);

	int save(Income income);

	List<Income> incomeALL(Income income);

	int updateselective(Income income);

	List<Income> grounpByYear(Income income);

	List<Income> grounpByMonth(Income income);

	List<Income> grounpByDay(Income income);

	List<Income> grounpByquarter(Income income);

}
