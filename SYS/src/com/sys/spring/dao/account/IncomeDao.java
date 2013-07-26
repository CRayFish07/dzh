package com.sys.spring.dao.account;

import java.util.List;

import com.sys.spring.domain.Income;

/** 
 * by dyong 2010-9-29
 */
public interface IncomeDao {

	public int insertIncome(Income income) ;
	
	public int updateIncome(Income income) ;
	
	public void deleteIncome(String uid) ;

	public Income findIncomeById(String id) ;
	
	public List<Income> findIncomeList(String begin,String end,Income income) ;
	
}
