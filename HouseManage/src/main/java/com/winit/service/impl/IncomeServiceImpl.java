package com.winit.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.StyleConstants.ColorConstants;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.winit.common.constans.Constant;
import com.winit.entity.pojo.Income;
import com.winit.mapper.IncomeMapper;
import com.winit.service.IncomeService;
@Service
public class IncomeServiceImpl implements IncomeService{
	@Resource
	private IncomeMapper incomeMapper;
	@Override
	public List<Income> incomeList(Income income) {
		PageHelper.startPage(income.getPage(),income.getRows());
		return incomeMapper.incomeList(income);
	}

	@Override
	public int save(Income income) {
		if(income.getId()!=null) {
			return incomeMapper.updateByPrimaryKeySelective(income);
		}
		 income.setCreateTime(new Date());
		return incomeMapper.insertSelective(income);
	}
      
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		incomeMapper.deletebyId(id);
	}

	@Override
	public List<Income> incomeALL(Income income) {
		List<Income> list=incomeMapper.getAll(income);
		return list;
	}

	@Override
	public int updateselective(Income income) {
		incomeMapper.updateSelective(income);
		return 1;
	}

	@Override
	public List<Income> grounpByYear(Income income) {
		// TODO Auto-generated method stub
		return incomeMapper.grounpByYear(income);
	}

	@Override
	public List<Income> grounpByMonth(Income income) {
		// TODO Auto-generated method stub
		return incomeMapper.grounpByMonth(income);
	}

	@Override
	public List<Income> grounpByDay(Income income) {
		// TODO Auto-generated method stub
		return incomeMapper.grounpByDay(income);
	}

	@Override
	public List<Income> grounpByquarter(Income income) {
		// TODO Auto-generated method stub
		return incomeMapper.grounpByquarter(income);
	}
	
}
