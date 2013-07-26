package com.sys.web.struts2.action;

import java.util.List;

import com.sys.spring.domain.Diary;
import com.sys.spring.service.account.DiaryService;
import com.sys.util.StringUtil;
import com.sys.web.struts2.BaseAction;

/** 
 * by dyong 2010-6-16
 */
public class DiaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471988367046101653L;

	private DiaryService diaryService ;
	
	private Diary diary ;
	private List<Diary> list ;
	
	public String insert(){
		return INSERT ;
	}
	public String update(){
		diary = diaryService.findDiaryById(diary.getId()) ;
		return insert() ;
	}
	public String list(){
		list = diaryService.findDiaryListByUser(this.getBeginDate(),this.getEndDate(),diary,super.getUser()) ;
		return LIST ;
	}
	
	public String addup(){

		diary.setUid(StringUtil.getUUID()) ;
		int result = 0 ;
		if(diary.getId()==0){
			result = diaryService.insertDiary(diary,super.getUser()) ;
		} else {
			result = diaryService.updateDiary(diary, super.getUser()) ;
		}
		if(result==1){
			
		}
		return list() ;
	}
	
	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	public List<Diary> getList() {
		return list;
	}

	public void setList(List<Diary> list) {
		this.list = list;
	}

}
