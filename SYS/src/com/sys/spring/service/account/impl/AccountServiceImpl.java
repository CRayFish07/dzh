package com.sys.spring.service.account.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.sys.spring.dao.account.AccountDao;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.AccountTable;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.account.AccountService;
import com.sys.util.LogUtil;

/** 
 * by dyong 2010-6-16
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao ;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account findAccountById(int id,User user) {
		// TODO Auto-generated method stub
		Account acc = accountDao.findAccountById(id);
		acc.setMoney(this.round(acc.getMoney(), 2, 1)) ;
		return acc ;
	}

	public List<Account> findAccountList(String begin, String end,
			Account account,User user) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "findAccountList", begin+","+end+","+account.toString()) ;
		return accountDao.findAccountList(begin, end, account);
	}

	public int insertAccount(Account account,User user) {
		// TODO Auto-generated method stub
		account.setUid(UUID.randomUUID().toString()) ;
		LogUtil.logInfo(user.getUsername(), "insertAccount", account.toString()) ;
		return accountDao.insertAccount(account);
	}

	public int updateAccount(Account account,User user) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "updateAccount", account.toString()) ;
		return accountDao.updateAccount(account);
	}

	public List<AccountTable> findAccountTableList(String begin, String end,
			Account account, User user,String type) {
		// TODO Auto-generated method stub
		LogUtil.logInfo(user.getUsername(), "findAccountTableList", begin+","+end+","+account.toString()) ;
		return accountDao.findAccountTableList(begin, end, account, user,type);
	}


    private double round(double value, int scale,
             int roundingMode) {  
        BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;  
        return d;  
    }   
}
