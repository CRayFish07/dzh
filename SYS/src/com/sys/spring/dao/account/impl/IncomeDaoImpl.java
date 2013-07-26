package com.sys.spring.dao.account.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.account.IncomeDao;
import com.sys.spring.domain.Income;

/** 
 * by dyong 2010-6-16
 */
public class IncomeDaoImpl extends AbstractDBDao implements IncomeDao {
	private static final Logger log = Logger.getLogger(IncomeDaoImpl.class);

	public int insertIncome(Income in) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("insertIncome") ;
		
		String sql = "INSERT INTO income(uid,title,money,kindId,kindTitle,datetime,userId,userName) VALUES (?,?,?,?,?,?,?,?)" ;
//		log.info(sql+"	"+kind.getTitle()+"	"+kind.getNote()+"	"+kind.getParentId()) ;
		Object[] params = {in.getUid(),in.getTitle(),in.getMoney(),in.getKindid(),in.getKindTitle(),in.getDatetime(),in.getUserId(),in.getUsername()} ;
		
		int result = this.update(sql, params) ;

		buf.append("|").append(sql)
		.append("|").append(params.toString())
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		return result ;
	}

	public int updateIncome(Income income) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteIncome(String uid) {
		// TODO Auto-generated method stub
		
	}

	public Income findIncomeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Income> findIncomeList(String begin, String end, Income income) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
