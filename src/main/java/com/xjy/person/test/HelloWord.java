package com.xjy.person.test;

import java.io.*;
import java.net.URL;

public class HelloWord {

    /**
     * 私有构造方法.
     */
    private HelloWord() {
        super();
    }

	public static void main(String[] args) {
        URL banner = HelloWord.class.getResource("/banner.txt");
        if (banner == null) {
            System.out.println("未获取到banner.txt文件!");
            return;
        }

		File file = new File(banner.getPath());
		System.out.println(txt2String(file));
	}

	/**
	 * 读取txt文件的内容
	 * @param file 想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String txt2String(File file){
		StringBuilder result = new StringBuilder();
		//构造一个BufferedReader类来读取文件
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s = null;
			while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}