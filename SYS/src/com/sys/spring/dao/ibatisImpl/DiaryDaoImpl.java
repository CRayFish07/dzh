package com.sys.spring.dao.ibatisImpl;

import java.util.List;

import com.sys.spring.dao.account.DiaryDao;
import com.sys.spring.domain.Diary;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-7-5
 */
public class DiaryDaoImpl extends DaoImpl implements DiaryDao {

	public Diary findDiaryById(int id) {
		// TODO Auto-generated method stub
		return (Diary) super.queryForObject("selectDiaryById",id);
	}

	public List<Diary> findDiaryListByUser(String begin, String end, Diary diary,User user) {
		// TODO Auto-generated method stub
		return (List<Diary>) super.queryForList("selectAllDiarys", user);
	}

	public int insertDiary(Diary diary) {
		// TODO Auto-generated method stub
		super.insert("saveDiary", diary) ;
		return 0;
	}

	public int updateDiary(Diary diary) {
		// TODO Auto-generated method stub
		return super.update("updateDiary", diary);
	}

}
