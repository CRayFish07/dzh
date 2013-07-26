package com.sys.spring.service.account.impl;

import java.util.List;
import java.util.UUID;

import com.sys.spring.dao.account.IncomeDao;
import com.sys.spring.domain.Income;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.account.IncomeService;
import com.sys.util.LogUtil;

/** 
 * by dyong 2010-9-29
 */
public class IncomeServiceImpl implements IncomeService {
	private IncomeDao incomeDao ;
	
	public IncomeDao getIncomeDao() {
		return incomeDao;
	}

	public void setIncomeDao(IncomeDao incomeDao) {
		this.incomeDao = incomeDao;
	}

	public Income findIncomeById(String id, User user) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "findIncomeById", id) ;
		return incomeDao.findIncomeById(id);
	}

	public List<Income> findIncomeList(String begin, String end, Income income,
			User user) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "findIncomeList", begin+","+end+","+income.toString()) ;
		return incomeDao.findIncomeList(begin, end, income);
	}

	public int insertIncome(Income income, User user) {
		// TODO Auto-generated method stub
		income.setUserId(user.getUid()) ;
		income.setUsername(user.getName()) ;
		income.setUid(UUID.randomUUID().toString()) ;
		LogUtil.logInfo(user.getUsername(), "insertIncome", income.toString()) ;
		return incomeDao.insertIncome(income);
	}

	public int updateIncome(Income income, User user) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "updateIncome", income.toString()) ;
		return incomeDao.updateIncome(income);
	}

}
