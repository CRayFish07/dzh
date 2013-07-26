package com.sys.web.struts2;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sys.web.Final;

/** 
 * by dyong 2010-5-24
 */
@SuppressWarnings("serial")
public class BaseInterceptor extends AbstractInterceptor {
	
	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		
//		ActionContext actionContext = actionInvocation.getInvocationContext();
//		Map session = actionContext.getSession() ;
//		
//		((BaseAction)actionInvocation.getProxy().getAction()).setSession(session) ;
//		
//		User u = (User)session.get(Final.SESSION_USER) ;
//		if(u==null){
//			return BaseAction.FAIL ;
//		}
//		
		HttpSession hs = ServletActionContext.getRequest().getSession() ;
		if(hs.getAttribute(Final.SESSION_USER)==null){
			return BaseAction.FAIL ;
		}
//		String re = actionInvocation.invoke();
//		UserAction action = (UserAction) actionInvocation.getProxy().getAction() ;
		return actionInvocation.invoke();
	}

}
