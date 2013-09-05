package com.gzb.web.struts.game;


import org.apache.log4j.Logger;

import com.gzb.web.struts.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

public class GameAction extends ActionSupport{

	private static final long serialVersionUID = 9035439762362528232L;
	public static final Logger log = Logger.getLogger(GameAction.class);

	public String execute(){
		return BaseAction.INDEX ;
	}
	
}
