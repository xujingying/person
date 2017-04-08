package com.xjy.person.controller;

import com.blinkfox.zealot.bean.SqlInfo;
import com.blinkfox.zealot.core.ZealotKhala;
import com.jfinal.core.Controller;
import com.xjy.person.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.pmw.tinylog.Logger;

/**
 * 多条件的模糊查询.
 * Created by Administrator on 2017/4/6.
 */
public class VagueController extends Controller {

    /**
     * 多条件模糊查询1.
     */
    public void select1() {
        String name = getPara("name");
        String sex = getPara("sex");

        String phone = getPara("phone");

        List<Object> params = new ArrayList<Object>();
        StringBuilder sb = new StringBuilder("SELECT * FROM contact AS c WHERE 1 = 1");
        if (name != null && name.trim().length() > 0) {
            sb.append(" AND c.name LIKE ? ");
            params.add("%" + name + "%");
        }

        if (sex != null && sex.length() > 0) {
            sb.append(" AND c.sex = ? ");
            params.add(sex);
        }

        if (phone != null && phone.trim().length() > 0) {
            sb.append(" AND c.phone LIKE ? ");
            params.add("%" + phone + "%");
        }

        String fistdate = getPara("fistdate");
        String lastdate = getPara("lastdate");
        if ((fistdate != null && fistdate.trim().length() > 0) && (lastdate == null || lastdate.length() == 0)) {
            sb.append(" AND c.birthday >= ? ");
            params.add(fistdate);
        } else if ((fistdate == null || fistdate.trim().length() == 0) && (lastdate != null && lastdate.length() > 0)) {
            sb.append(" AND c.birthday <= ? ");
            params.add(lastdate);
        } else if ((fistdate != null && fistdate.trim().length() > 0) && (lastdate != null && lastdate.length() > 0)) {
            sb.append(" AND c.birthday BETWEEN ? AND ? ");
            params.add(fistdate);
            params.add(lastdate);
        }

        String sql = sb.toString();
        Logger.info("sql:{}", sql);
        List<Contact> users = Contact.dao.find(sql, params.toArray());
        renderJson(users);
    }

    /**
     * zealot的查询.
     */
    public void select2() {
        String name = getPara("name");
        String sex = getPara("sex");
        String fistdate = getPara("fistdate");
        String lastdate = getPara("lastdate");
        String phone = getPara("phone");

        SqlInfo sqlInfo = ZealotKhala.start()
                .select("*")
                .from("contact AS c")
                .where("1 = 1")
                .andLike("c.name", name, name != null && name.length() > 0)
                .andEqual("c.sex", sex, sex != null && sex.length() > 0)
                .andLike("c.phone", phone, phone != null && phone.length() > 0)
                .andBetween("c.birthday", fistdate, lastdate, fistdate != null || lastdate != null)
                .limit("2")
                .offset("1")
                .end();

        String sql = sqlInfo.getSql();
        Logger.info("select2的sql:{}", sql);
        List<Contact> users = Contact.dao.find(sql, sqlInfo.getParamsArr());
        renderJson(users);
    }

}
