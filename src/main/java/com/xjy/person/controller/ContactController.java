package com.xjy.person.controller;

import com.jfinal.core.Controller;
import com.xjy.person.model.Contact;

/**
 * 从页面接收参数，实现对数据库的增删改查
 * 从页面接收参数函数： getPara（）
 * Created by Administrator on 2017/4/5.
 */
public class ContactController extends Controller {

    /**
     * add.
     */
    public void add() {
        new Contact().set("name", "James").set("age", 1).save();
        renderText("恭喜你，添加成功!");
    }

    /**
     * 删除用户的方法.
     */
    public void del() {
        String id = getPara("id");
        if (id == null || id.trim().length() == 0) {
            renderText("没有接收到需要修改的用户的id!");
        } else {
            Contact.dao.deleteById(id);
            renderText("恭喜你，删除成功!");
        }
    }

    /**
     * 更新用户的方法.
     */
    public void update() {
        String id = getPara("id");
        if (id == null || id.trim().length() == 0) {
            renderText("没有接收到需要修改的用户的id!");
        } else {
            Contact contact = Contact.dao.findById(id);
            if (contact == null) {
                renderText("要修改的用户id在数据库中不存在!");
            } else {
                contact.set("name", "阿银").update();
                renderText("恭喜你，修改信息成功!");
            }
        }

    }

    /**
     * 单个查询用户的方法.
     */
    public void select() {
        String id = getPara("id");
        if (id == null || id.trim().length() == 0) {
            renderText("没有接收到需要查询的用户的id!");
        } else {

            Contact contact = Contact.dao.findById(id);
            if (contact == null) {
                renderText("要查询的用户id在数据库中不存在!");
            } else {
                renderText("恭喜你，查询信息成功!");
            }
        }
    }

}
