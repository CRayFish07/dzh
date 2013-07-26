package com.sys.spring.dao.admin;

import java.util.List;

import com.sys.spring.domain.admin.Rolse;

/**
 * 角色查询
 * @author Administrator
 *
 */
public interface RolseDao {

	public int insertRolse(Rolse rolse) ;
	
	public int updateRolse(Rolse rolse) ;
	
	public Rolse selectRolseById(int id) ;
	
	public List<Rolse> selectRolseByRolse(Rolse rolse) ;
	
	public List<Rolse>  selectRolseByIds(String ids) ;	//按ID批量查询
}
