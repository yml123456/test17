package com.yuanmingli.common.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yuanmingli.common.utils.DateUtil;

public class UtilTest {

	public static void main(String[] args) {
//		将上面{1}的位置使用DateUtil工具类中的getDateByInitMonth()返回值替换，将上面{2}的位置使用DateUtil工具类中的
//		getDateByFullMonth()返回值替换。最后打印出正确拼接的SQL字符串。
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 替换
		sql = sql.replaceFirst("\\{1\\}", "{" + sdf.format(DateUtil.getDateByInitMonth(date))  + "}");
		sql = sql.replaceFirst("\\{2\\}", "{" + sdf.format(DateUtil.getDateByFullMonth(date))  + "}");
		
		System.out.println(sql);
	}
}
