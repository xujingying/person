package com.xjy.person.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import org.pmw.tinylog.Logger;

/**
 * 第一个测试类.
 */
public class HelloWord {

    /**
     * 私有构造方法.
     */
    private HelloWord() {
        super();
    }

    /**
     * main方法.
     * @param args 数组参数
     */
    public static void main(String[] args) {
        URL banner = HelloWord.class.getResource("/banner.txt");
        if (banner == null) {
            Logger.info("未获取到banner.txt文件!");
            return;
        }

        File file = new File(banner.getPath());
        Logger.info(txt2String(file));
    }

    /**
     * 读取txt文件的内容.
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    private static String txt2String(File file) {
        StringBuilder sb = new StringBuilder("");
        //构造一个BufferedReader类来读取文件
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                sb.append(System.lineSeparator()).append(s);
            }
        } catch (Exception e) {
            Logger.error(e, "读取文件");
        }
        return sb.toString();
    }

}