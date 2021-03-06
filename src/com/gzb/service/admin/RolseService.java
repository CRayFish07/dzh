package com.gzb.service.admin;

import java.util.List;

import com.gzb.domain.admin.Rolse;

public interface RolseService {

	public int addRolse(Rolse rolse) ;
	public int updateRolse(Rolse rolse) ;
	public Rolse findRolseByID(int id) ;
	public List<Rolse> findRolseList(Rolse rolse) ;
	public List<Rolse> findRolseList() ;
	
	public List<Rolse> findRolseListByIds(String ids) ;
}
