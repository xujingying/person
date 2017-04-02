package com.xjy.person.controller;

import com.jfinal.core.Controller;

/**
 * 根控制器
 */
public class IndexController extends Controller {
	
	/**
	 * index方法.
	 */
	public void index(){
		String id = getPara("id");
		renderText("Hello JFinal!id:" + id);
	}
	
	/**
	 * hello方法.
	 */
	public void hello(){
		String id = getPara("id");
		renderText("55555:" + id);
	}

}