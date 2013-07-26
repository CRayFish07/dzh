package com.sys.web.struts2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.admin.UserService;
import com.sys.web.Final;

/** 
 * by dyong 2010-5-24
 */
public class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(BaseAction.class);
	protected SimpleDateFormat datetimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	protected SimpleDateFormat monthFormatter = new SimpleDateFormat("yyyy-MM-");


	private String beginDate = monthFormatter.format(new Date())+"01";
	private String endDate = dateFormatter.format(new Date()) ;
	private UserService userService ;	//用户服务

	private HttpSession httpSession ;
	private String message ;
	private User user ;
	private String date = dateFormatter.format(new Date());
	protected String error ;
	
	public static final String FAIL		= "fail" ;
	public static final String INDEX	= "index" ;
	public static final String MAIN		= "main" ;
	public static final String TOP		= "top" ;
	public static final String LEFT		= "left" ;
	public static final String BOTTOM	= "bottom" ;
	
	public static final String LIST		= "list" ;
	public static final String INSERT	= "insert" ;
	public static final String UPDATE	= "update" ;
	public static final String ADD		= "add" ;
	public static final String RESULT	= "result" ;
	
	public static final String ERROR	= "error" ;
	
	
	public User getUser() {
		user = (User) getHttpSession().getAttribute(Final.SESSION_USER);
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpSession getHttpSession() {
		if(httpSession==null){
			httpSession = ServletActionContext.getRequest().getSession() ;
		}
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	public void setHttpSession(User user,int outtime) {
		httpSession = getHttpSession() ;
		httpSession.setAttribute(Final.SESSION_USER,user) ;
		httpSession.setMaxInactiveInterval(outtime) ;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
}
