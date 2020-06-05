package com.yuanmingli.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流工具类
 * @author yml
 *
 */
public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传入无限个。
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(AutoCloseable...autoCloseables){
		try {
			for (int i = 0; i < autoCloseables.length; i++) {
				autoCloseables[i].close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream src) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(src));
		
		StringBuffer buffer = new StringBuffer();
		String str = "";
		
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str + "\r\n");
		}
		
		closeAll(bufferedReader,src);
		
		return buffer.toString();
	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws IOException{
		FileInputStream inputStream = new FileInputStream(txtFile);
		
		return readTextFile(inputStream);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(readTextFile(new File("src/test/resources/a.txt")));
	}
}
