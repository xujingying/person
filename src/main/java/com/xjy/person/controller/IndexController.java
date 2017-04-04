package com.xjy.person.controller;

import com.jfinal.core.Controller;
import org.pmw.tinylog.Logger;

/**
 * 根控制器.
 */
public class IndexController extends Controller {

    /**
     * index方法.
     */
    public void index() {
        String id = getPara("id");
        Logger.warn("index方法获取的参数id的值为:" + id);
        renderText("Hello JFinal!id:" + id);
    }

    /**
     * hello方法.
     */
    public void hello() {
        String id = getPara("id");
        renderText("55555:" + id);
    }

}