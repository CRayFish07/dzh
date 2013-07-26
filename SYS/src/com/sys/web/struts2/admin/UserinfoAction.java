package com.sys.web.struts2.admin;

import java.util.List;

import com.sys.spring.domain.admin.Rolse;
import com.sys.spring.domain.admin.User;
import com.sys.spring.domain.admin.Userinfo;
import com.sys.spring.service.admin.RolseService;
import com.sys.spring.service.admin.UserinfoService;
import com.sys.web.struts2.BaseAction;

public class UserinfoAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RolseService rolseService ;
	private UserinfoService userinfoService ;
	
	private List<Userinfo> userinfolist ;
	private List<Rolse> rolselist ;
	private List<User> userlist ;
	private Userinfo userinfo = new Userinfo() ; 
	public String execute(){
		return INDEX ;
	}
	//添加
	public String add(){
		rolselist = rolseService.findRolseList() ;
		userlist = this.getUserService().getAllUser() ;
//		if(userinfo==null){
//			userlist = this.getUserService().getAllUser() ;
//			List<Userinfo> list = userinfoService.findUserinfoList() ;
//			HashSet<Integer> set = new HashSet<Integer>() ;
//			for(Userinfo info:list){
//				set.add(info.getId()) ;
//			}
//			for(User user:userlist){
//				if(set.contains(user.getId())){
//					userlist.remove(user) ;
//				}
//			}
//		} else {
//			userlist = new ArrayList<User>() ;
//			userlist.add(this.getUserService().getUserById(userinfo.getUserid())) ;
//		}
		
		return ADD ;
	}
	//添加/修改提交
	public String addup(){
		int result = 0 ;
		String ids = "" ;
		for(int id :userinfo.getRolsesid()){
			ids += ","+id ;
		}
		ids = ids.substring(1) ;
		userinfo.setRolses(ids) ;

		if(userinfo.getId()==0){
			result = userinfoService.addUserinfo(userinfo) ;
		} else if(userinfo.getId()>0){
			result = userinfoService.updateUserinfo(userinfo) ;
		}
		if(result==1){
			return list() ;
		}
		
		return ADD ;
	}
	//列表
	public String list(){
		userinfolist = userinfoService.findUserinfoList() ;
		return LIST ;
	}
	//修改
	public String update(){
		int id = userinfo.getId() ;//Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		userinfo = userinfoService.findUserinfoByID(id) ;
		return add() ;
	}
	//修改状态
	public String del(){
		int id =userinfo.getId() ;// Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		this.userinfoService.deleteUserinfo(id) ;
		
		return list() ;
	}
	
	public RolseService getRolseService() {
		return rolseService;
	}
	public void setRolseService(RolseService rolseService) {
		this.rolseService = rolseService;
	}
	public List<Rolse> getRolselist() {
		return rolselist;
	}
	public void setRolselist(List<Rolse> rolselist) {
		this.rolselist = rolselist;
	}
	public UserinfoService getUserinfoService() {
		return userinfoService;
	}
	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	public List<Userinfo> getUserinfolist() {
		return userinfolist;
	}
	public void setUserinfolist(List<Userinfo> userinfolist) {
		this.userinfolist = userinfolist;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	
	
}
