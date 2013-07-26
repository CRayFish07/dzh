package com.sys.web.struts2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.admin.UserService;
import com.sys.web.Final;

public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = 9035439762362528232L;
	public static final Logger log = Logger.getLogger(IndexAction.class);

	private UserService userService ;	//用户服务
	private HttpSession httpSession ;
	protected String message ;
	
	private User u = new User() ;
	public String execute(){
		return BaseAction.INDEX ;
	}
	
	/**
	 * 登录
	 */
	public void check(){
		String username = ServletActionContext.getRequest().getParameter("username") ;
		String pwd = ServletActionContext.getRequest().getParameter("password") ;
//		System.out.println(username+"======"+password) ;
		User u = new User() ;
		u.setName(username) ;
		u.setPassword(pwd) ;
		User user = this.getUserService().userLogin(u) ;
		
		String str = "0" ;
		if(user==null){
			str = "-2" ;
		} else {
			int outtime = 60*60*2 ;
			this.setHttpSession(user, outtime ) ;
		}
		try {
			HttpServletResponse response = ServletActionContext.getResponse() ;
			response.setCharacterEncoding("utf-8");
			response.setContentLength(str.length());
			ServletOutputStream os = response.getOutputStream();
			os.write(str.getBytes("utf-8"));
			os.flush();
			os.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "check" ;
	}
	
	public String login(){
		String username = ServletActionContext.getRequest().getParameter("username") ;
		String pwd = ServletActionContext.getRequest().getParameter("password") ;

		u.setName(username) ;
//		user.setPassword(password) ;
//		String pwd = u.getPassword() ;
		List<User> list = this.getUserService().getUsersByUser(u) ;
		
		String str = "成功" ;
		if(list==null || list.size()!=1){
			str = "用户不存在" ;
		} else {
			User user = list.get(0) ;
			if(!user.getPassword().equals(pwd)){
				str = "密码不正确" ;
			} else {
				int outtime = 60*60*2 ;
				this.setHttpSession(user, outtime ) ;
				return SUCCESS ;
			}
		}
		this.setMessage(str) ;
		return BaseAction.INDEX ;
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String loginout(){
		this.setHttpSession(null,1) ;
		return "out" ;
	}

	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setHttpSession(User user,int outtime) {
		httpSession = getHttpSession() ;
		httpSession.setAttribute(Final.SESSION_USER,user) ;
		httpSession.setMaxInactiveInterval(outtime) ;
	}

}
