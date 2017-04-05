package com.xjy.person.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Administrator on 2017/4/5.
 */
public class Contact extends Model<Contact> {
    public static final Contact dao = new Contact().dao();
}
