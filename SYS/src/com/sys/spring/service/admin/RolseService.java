package com.sys.spring.service.admin;

import java.util.List;

import com.sys.spring.domain.admin.Rolse;

public interface RolseService {

	public int addRolse(Rolse rolse) ;
	public int updateRolse(Rolse rolse) ;
	public Rolse findRolseByID(int id) ;
	public List<Rolse> findRolseList(Rolse rolse) ;
	public List<Rolse> findRolseList() ;
	
	public List<Rolse> findRolseListByIds(String ids) ;
}
