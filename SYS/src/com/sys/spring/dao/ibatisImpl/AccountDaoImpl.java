package com.sys.spring.dao.ibatisImpl;

import java.util.HashMap;
import java.util.List;

import com.sys.spring.dao.account.AccountDao;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.AccountTable;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-7-5
 */
public class AccountDaoImpl extends DaoImpl implements AccountDao {


	public int insertAccount(Account account) {
		super.insert("saveAccount", account) ;
		return 0;
	}
	public int updateAccount(Account account) {
		return super.update("updateAccount", account);
	}
	public void deleteAccount(Account account) {
		super.delete("deleteAccount", account);
	}
	public Account findAccountById(int id) {
		return (Account) super.queryForObject("selectAccountById", id);
	}

	public List<Account> findAccountList(String begin, String end,
			Account account) {
		HashMap<String, Object> map = new HashMap<String, Object>() ;
		map.put("acc", account) ;
		map.put("begin", begin) ;
		map.put("end", end) ;
		return (List<Account>) super.queryForList("selectAllAccounts",map);
	}

	public List<AccountTable> findAccountTableList(String begin, String end,
			Account account, User user,String type) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>() ;
		map.put("begin", begin) ;
		map.put("end", end) ;
		map.put("acc", account) ;
		map.put("user", user) ;
		map.put("type", type) ;	//值：kind	year	month	day
		return (List<AccountTable>) super.queryForList("groupAccounts",map);
	}

}
