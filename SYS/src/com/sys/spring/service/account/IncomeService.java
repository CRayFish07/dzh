package com.sys.spring.service.account;

import java.util.List;

import com.sys.spring.domain.Income;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-9-29
 */
public interface IncomeService {

	public int insertIncome(Income income,User user) ;
	
	public int updateIncome(Income income,User user) ;
	
	public List<Income> findIncomeList(String begin,String end,Income income,User user) ;
	
	public Income findIncomeById(String id,User user) ;
	
}
