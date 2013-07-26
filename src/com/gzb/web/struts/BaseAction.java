package com.gzb.web.struts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession ;

import com.gzb.domain.admin.User;
import com.gzb.global.Final;
import com.gzb.service.admin.UserService;
import com.opensymphony.xwork2.ActionSupport;

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

	private UserService userService ;	//用户服务
	private HttpSession httpSession ;
	private User user ;
	private String date = dateFormatter.format(new Date());
	protected String message ;
	
	public static final String INDEX	= "index" ;
	
	public static final String MAIN		= "main" ;
	public static final String TOP		= "top" ;
	public static final String LEFT		= "left" ;
	public static final String BOTTOM	= "bottom" ;
	public static final String FAIL		= "fail" ;
	
	public static final String LIST		= "list" ;
	public static final String INSERT	= "insert" ;
	public static final String UPDATE	= "update" ;
	public static final String ADD		= "add" ;
	
	public static final String ERROR	= "error" ;
	public static final String RESULT	= "result" ;

	public BaseAction(){
//		if(this.getHttpSession()==null){
//			System.out.println("================session is out time ") ;
//		}
	}
	//做页面跳转
	public void redirect(){
//		this.getRequest()
	}
	public User getUser() {
		user = (User) getHttpSession().getAttribute(Final.SESSION_USER);
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest() ;
	}
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse() ;
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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
