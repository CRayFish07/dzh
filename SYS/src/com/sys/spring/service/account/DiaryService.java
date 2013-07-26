package com.sys.spring.service.account;

import java.util.List;

import com.sys.spring.domain.Diary;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-6-16
 */
public interface DiaryService {

	public int insertDiary(Diary diary,User user) ;
	
	public int updateDiary(Diary diary,User user) ;

	public List<Diary> findDiaryListByUser(User user) ;
	
	public List<Diary> findDiaryListByUser(String begin, String end, Diary diary,User user) ;
	
	public Diary findDiaryById(int id) ;
}
