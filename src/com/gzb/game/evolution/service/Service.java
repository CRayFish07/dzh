package com.gzb.game.evolution.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;


import com.gzb.game.evolution.Const;

public class Service {

	private HashSet<String> set = new HashSet<String>() ;
	private int leve ;
	
	/**
	 * 点击处理
	 * @param table
	 * @param org
	 * @param _leve
	 */
	public void change(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org, int _leve){
		this.leve = _leve ;	//设置起始查找等级
		//查找需要合并的数据
		List<Organism> list = this.getSames(table, org) ;
		
		//数据不足三个，不需要合并，改变当前位置即可
		if(list.size()<3){
			org.change(_leve) ;
			return ;
		}
		//需要合并的处理。 首先将所有需合并的初始化，再将最初的位置设置成最高级
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
	private List<Organism> getSames(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org){
		//查找起始等级数据
		List<Organism> list = this.getSames(table, org, leve) ;
		List<Organism> allList = list ;	//存储查找到的数据
		//数据超过三个，等级升一级，继续查找
		while(list.size()>=3){
			leve++ ;	//等级加
			set = new HashSet<String>() ;	//统计集合重置
			list = this.getSames(table, org, leve) ;
			
			//数据不足三个，停止找
			if(list.size()<3){
				break ;
			}
			//够数目了，添加到返回的数组中
			allList.addAll(list) ;
		}
		
		return allList ;
	}
	
	/**
	 * 查找相邻的相同类型的数据
	 * @param table	二维数据表
	 * @param org	定位查找位置
	 * @param leve	制定类型
	 * @return
	 */
	private List<Organism> getSames(Hashtable<Integer,Hashtable<Integer,Organism>> table , Organism org,int leve){
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
			if(_org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		if(x<Const.size-1){
			Organism _org = table.get(x+1).get(y) ;
			if(_org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		
		//判断上下
		if(y>0){
			Organism _org = table.get(x).get(y-1) ;
			if(_org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		if(y<Const.size-1){
			Organism _org = table.get(x).get(y+1) ;
			if(_org.getLeve()==leve){
				list.addAll(this.getSames(table,_org,leve)) ;
			}
		}
		return list ;
	}
}
