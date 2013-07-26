package com.sys.spring.service.account;

import java.util.List;

import com.sys.spring.domain.Account;
import com.sys.spring.domain.AccountTable;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-6-16
 */
public interface AccountService {
	
	public int insertAccount(Account account,User user) ;
	
	public int updateAccount(Account account,User user) ;
	
	public List<Account> findAccountList(String begin,String end,Account account,User user) ;
	
	public Account findAccountById(int id,User user) ;
	
	public List<AccountTable> findAccountTableList(String begin,String end,Account account,User user,String type) ;
	
}
