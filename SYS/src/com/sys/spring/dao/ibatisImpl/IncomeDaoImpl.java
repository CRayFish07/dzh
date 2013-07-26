package com.sys.spring.dao.ibatisImpl;

import java.util.HashMap;
import java.util.List;

import com.sys.spring.dao.account.IncomeDao;
import com.sys.spring.domain.Income;

/** 
 * by dyong 2010-9-29
 */
public class IncomeDaoImpl extends DaoImpl implements IncomeDao {

	public int insertIncome(Income income) {
		super.insert("saveIncome", income) ;
		return 0;
	}

	public int updateIncome(Income income) {
		return super.update("updateIncome", income) ;
	}

	public void deleteIncome(String uid) {
		super.delete("deleteIncome", uid) ;
	}

	public Income findIncomeById(String id) {
		return (Income) super.queryForObject("selectIncomeById", id);
	}

	@SuppressWarnings("unchecked")
	public List<Income> findIncomeList(String begin, String end, Income income) {
		HashMap<String, Object> map = new HashMap<String, Object>() ;
		map.put("in", income) ;
		map.put("begin", begin) ;
		map.put("end", end) ;
		return (List<Income>) super.queryForList("selectAllIncome", map);
	}

}
