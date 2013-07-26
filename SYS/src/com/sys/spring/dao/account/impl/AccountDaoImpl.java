package com.sys.spring.dao.account.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.account.AccountDao;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.AccountTable;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-6-16
 */
public class AccountDaoImpl extends AbstractDBDao implements AccountDao {
	private static final Logger log = Logger.getLogger(AccountDaoImpl.class);
	
	public List<Account> findAccountList(String begin, String end,Account account) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("findAccountList") ;
		
		StringBuffer sql = new StringBuffer("select * from account where datetime>=? and datetime<=? ") ;
		
		ArrayList<Object> params = new ArrayList<Object>() ;
		params.add(begin) ;
		params.add(end) ;
		
		if(account.getKindid()!=null && account.getKindid().length()>0){
			sql.append(" and kindid=?") ;
			params.add(account.getKindid()) ;
		}
		if(account.getUserId()!=null){
			sql.append(" and userid=?") ;
			params.add(account.getUserId()) ;
		}
		if(account.getTitle()!=null){
			sql.append(" and title like ?") ;
			params.add("%"+account.getTitle()+"%") ;
		}
		if(account.getMoney()>0){
			sql.append(" and money>?") ;
			params.add(account.getMoney()) ;
		}
		
		buf.append("|").append(sql) ;
		buf.append("|").append(this.list2String(params)) ;
		List<Account> list = this.selectList(sql.toString(), params.toArray(), Account.class) ;
		
		buf.append("|").append(list.size()) ;
		buf.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		return list ;
	}

	public int insertAccount(Account acc) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("insertAccount") ;
		
		String sql = "insert into account (uid,title,money,kindid,kindtitle,datetime,userid,username) values(?,?,?,?,?,?,?,?)" ;
//		log.info(sql+"	"+acc.getUid()+"	"+acc.getTitle()+"	"+acc.getMoney()+"	"+acc.getKindId()+"	"+acc.getKindTitle()
//				+"	"+acc.getDatetime()+"	"+acc.getUserId()+"	"+acc.getUserName()) ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		params.add(acc.getUid()) ;
		params.add(acc.getTitle()) ;
		params.add(acc.getMoney()) ;
		params.add(acc.getKindid()) ;
		params.add(acc.getKindTitle()) ;
		params.add(acc.getDatetime()) ;
		params.add(acc.getUserId()) ;
		params.add(acc.getUsername()) ;
		
		int result = this.update(sql, params.toArray()) ;
		
		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		return result ;
	}

	public int updateAccount(Account acc) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("updateAccount") ;

		StringBuffer sql = new StringBuffer("update account set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		
		if(acc.getTitle()!=null){
			sql.append(" title=? ,") ;
			params.add(acc.getTitle()) ;
		}
		if(acc.getMoney()>0){
			sql.append(" money=? ,") ;
			params.add(String.valueOf(acc.getMoney())) ;
		}
		if(acc.getDatetime()!=null){
			sql.append(" datetime=? ,") ;
			params.add(acc.getDatetime()) ;
		}
		if(acc.getKindid()!=null){
			sql.append(" kindid=? ,") ;
			params.add(acc.getKindid()) ;
		}
		if(acc.getKindTitle()!=null){
			sql.append(" kindtitle=? ,") ;
			params.add(acc.getKindTitle()) ;
		}
		sql.append(" id=?").append(" where id=?") ;
		params.add(acc.getId()) ;
		params.add(acc.getId()) ;
		
		int result = this.update(sql.toString(), params.toArray()) ;

		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		
		return result ;
	}

	public Account findAccountById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("findAccountById") ;

		String sql = "select * from account where id = ? ";
		
		List<Account> list = this.selectList(sql, new Object[] {id}, Account.class) ;
		
		buf.append("|").append(sql)
		.append("|").append(id)
		.append("|").append(list.size())
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		
		if(list==null || list.size()==0){
			return new Account() ;
		} else {
			return list.get(0) ;
		}
	}

	public List<AccountTable> findAccountTableList(String begin, String end,
			Account account, User user,String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

}
