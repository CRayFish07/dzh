package com.gzb.web.struts.index;


import org.apache.log4j.Logger;

import com.gzb.web.struts.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = 9035439762362528232L;
	public static final Logger log = Logger.getLogger(IndexAction.class);

	public String execute(){
		return BaseAction.INDEX ;
	}
	
}
