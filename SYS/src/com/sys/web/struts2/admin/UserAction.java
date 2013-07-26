package com.sys.web.struts2.admin;

import java.util.List;

import com.sys.spring.domain.admin.User;
import com.sys.web.struts2.BaseAction;


public class UserAction extends BaseAction{
	private static final long serialVersionUID = -1761856308311431565L;
	private User u = new User() ;
	private List<User> list ;
	public String execute(){
		return LOGIN ;
	}
	/**
	 * 用户列表
	 * @return
	 */
	public String list(){
		list = this.getUserService().getAllUser() ;
		return LIST ;
	}
	/**
	 * REGISTE
	 * @return
	 */
	public String add(){
//		this.getUserService().userRegister(u) ;
		return ADD ;
	}
	public String addup(){
		int result = 0 ;
		if(u.getId()==0){
			result = this.getUserService().userRegister(u) ;
		} else if(u.getId()>0){
			result = this.getUserService().userUpdate(u) ;
		}
		if(result==1){
			this.setMessage("用户添加成功") ;
		} else {
			this.setMessage("用户添加失败") ;
		}
		return SUCCESS ;
	}
	public String update(){
		u = this.getUserService().getUserById(u.getId()) ;
		return add() ;
	}
	public String del(){
		boolean b = this.getUserService().userDelete(u.getId()) ;
		if(b){
			
		}
		return list() ;
	}

	public String pwd(){
		int uid = u.getId() ;
		if(uid==0){
			uid = this.getUser().getId() ;
		}
		u = this.getUserService().getUserById(uid) ;
		return "pwd" ;
	}

	public String pwdup(){
		int result = this.getUserService().userPasswordUpdate(u) ;
		if(result==1){
			this.setMessage("密码修改成功") ;
		} else {
			this.setMessage("密码修改失败") ;
		}
		return SUCCESS ;
	}
	public String check(){
		return LOGIN ;
	}
	
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	
}
