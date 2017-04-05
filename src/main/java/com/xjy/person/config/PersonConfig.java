package com.xjy.person.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.xjy.person.controller.ContactController;
import com.xjy.person.controller.IndexController;
import com.xjy.person.model.Contact;
import org.pmw.tinylog.Logger;

/**
 * person的Jfinal主配置类.
 * @author xjy on 2017-04-03
 */
public class PersonConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
        me.add("/contact", ContactController.class);
    }

    @Override
    public void configEngine(Engine me) {
        Logger.info("加载configEngine...");
    }

    @Override
    public void configHandler(Handlers me) {
        Logger.info("加载configHandler...");
    }

    @Override
    public void configInterceptor(Interceptors me) {
        Logger.info("加载configInterceptor...");
    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://192.168.0.105/person?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "123456");
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.addMapping("contact", Contact.class);
    }

}