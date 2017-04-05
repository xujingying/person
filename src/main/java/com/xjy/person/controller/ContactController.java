package com.xjy.person.controller;

import com.jfinal.core.Controller;
import com.xjy.person.model.Contact;

/**
 * Created by Administrator on 2017/4/5.
 */
public class ContactController extends Controller {

    public void add() {
        new Contact().set("name", "James").set("age", 1).save();
    }

    public void del() {
        Contact.dao.deleteById(1);
    }

    public void update(){
        Contact.dao.findById (1).set("name", "James").update();
    }

    public void select(){
        Contact user = Contact.dao.findById (1);
    }

}
