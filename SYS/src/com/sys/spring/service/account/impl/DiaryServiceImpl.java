package com.sys.spring.service.account.impl;

import java.util.List;
import java.util.UUID;

import com.sys.spring.dao.account.DiaryDao;
import com.sys.spring.domain.Diary;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.account.DiaryService;

/** 
 * by dyong 2010-6-16
 */
public class DiaryServiceImpl implements DiaryService {

	private DiaryDao diaryDao ;
	
	public DiaryDao getDiaryDao() {
		return diaryDao;
	}

	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

	public Diary findDiaryById(int id) {
		return diaryDao.findDiaryById(id);
	}

	public List<Diary> findDiaryListByUser(User user) {
		String end = "" ;
		String begin = "" ;
		return this.findDiaryListByUser(begin, end, new Diary(), user);
	}
	
	public List<Diary> findDiaryListByUser(String begin, String end, Diary diary,User user) {
		return diaryDao.findDiaryListByUser(begin,end,diary,user);
	}

	public int insertDiary(Diary diary,User user) {
		diary.setUid(UUID.randomUUID().toString()) ;
		diary.setUserId(user.getUid()) ;
		diary.setUsername(user.getUsername()) ;
		return diaryDao.insertDiary(diary);
	}

	public int updateDiary(Diary diary,User user) {
		diary.setUserId(user.getUid()) ;
		diary.setUsername(user.getUsername()) ;
		return diaryDao.updateDiary(diary);
	}

}
