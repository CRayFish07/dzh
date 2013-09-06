package com.gzb.game.evolution.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;


import com.gzb.game.evolution.Const;

public class Service {

	private HashSet<String> set = new HashSet<String>() ;
	private int leve ;
	
	public void change(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org, int _leve){
		this.leve = _leve ;
		List<Organism> list = this.getSames(table, org) ;
		for(Organism _org : list){
			_org.change(0) ;
		}
		org.change(leve) ;
	}
	
	/**
	 * 查找所有相同数据，包括升级数据
	 * 相同数据数量超过三个，升一级，继续查找。
	 * @param table
	 * @param org
	 * @return
	 */
	public List<Organism> getSames(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org){
		
		List<Organism> list = this.getSames(table, org, leve) ;
		List<Organism> allList = list ;
		while(list.size()>=3){
			leve++ ;
			list = this.getSames(table, org, leve) ;
			allList.addAll(list) ;
		}
		
		return allList ;
	}
	/**
	 * 查找相同数据
	 * @param table
	 * @param org
	 * @return
	 */
	public List<Organism> getSames(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org,int leve){
		List<Organism> list = new ArrayList<Organism>() ;
		
		int x = org.getX() ;
		int y = org.getY() ;
		
		//用set保存，预防重复查找
		String key = x+"_"+y ;
		if(set.contains(key)){
			return list ;
		}
		list.add(org) ;
		set.add(key) ;
		
		//判断左右
		if(x>0){
			Organism _org = table.get(x-1).get(y) ;
			if(org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		if(x<Const.size-1){
			Organism _org = table.get(x+1).get(y) ;
			if(org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		
		//判断上下
		if(y>0){
			Organism _org = table.get(x).get(y-1) ;
			if(org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		if(y<Const.size-1){
			Organism _org = table.get(x).get(y+1) ;
			if(org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		return list ;
	}
}
