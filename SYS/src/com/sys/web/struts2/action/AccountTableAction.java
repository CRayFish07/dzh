package com.sys.web.struts2.action;

import java.util.Date;
import java.util.List;

import com.sys.spring.domain.Account;
import com.sys.spring.domain.AccountTable;
import com.sys.spring.domain.Kind;
import com.sys.spring.service.account.AccountService;
import com.sys.spring.service.account.KindService;
import com.sys.web.struts2.BaseAction;

/** 
 * by dyong 2010-6-16
 */
public class AccountTableAction extends BaseAction {

	private AccountService accountService ;
	private KindService kindService ;
	
	private List<Kind> kinds ;
	
	private Account acc ;
	private List<Account> list ;
	private List<AccountTable> tableList ;
	private String beginDate = monthFormatter.format(new Date())+"01";
	private String endDate = dateFormatter.format(new Date()) ;
	private String type = "year";	//值：kind	year	month	day。分别按类别、年、月、日分类查询统计
	
	public String monthList(){
		kinds = kindService.findKindList(-1) ;
		list = accountService.findAccountList(beginDate, endDate, acc,super.getUser()) ;
		
		return "monthList" ;
	}
	
	public String countList(){
		kinds = kindService.findKindList(-1) ;
		tableList = accountService.findAccountTableList(beginDate, endDate, acc,super.getUser(),type) ;
		
		return "countList" ;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public KindService getKindService() {
		return kindService;
	}

	public void setKindService(KindService kindService) {
		this.kindService = kindService;
	}

	public List<Kind> getKinds() {
		return kinds;
	}

	public void setKinds(List<Kind> kinds) {
		this.kinds = kinds;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	public String getType() {
		return type;
	}

	public List<AccountTable> getTableList() {
		return tableList;
	}

	public void setTableList(List<AccountTable> tableList) {
		this.tableList = tableList;
	}

	public void setType(String type) {
		this.type = type;
	}
}
