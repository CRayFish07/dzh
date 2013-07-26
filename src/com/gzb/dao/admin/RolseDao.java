package com.gzb.dao.admin;

import java.util.List;

import com.gzb.domain.admin.Rolse;

public interface RolseDao {

	public int insertRolse(Rolse rolse) ;
	
	public int updateRolse(Rolse rolse) ;
	
	public Rolse selectRolseById(int id) ;
	public List<Rolse> selectRolseByRolse(Rolse rolse) ;
	
	public List<Rolse>  selectRolseByIds(String ids) ;
}
