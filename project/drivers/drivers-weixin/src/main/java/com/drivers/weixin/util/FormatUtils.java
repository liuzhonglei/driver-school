/**
 * 
 */
package com.drivers.weixin.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>格式化工具
 *
 * @author LiangBin
 * @since 2012-9-19 下午01:30:32
 * @version 1.0
 */
public class FormatUtils {

	private static final DecimalFormat DECIMAL_FORMAT = new  DecimalFormat("#####0.00");
	
	private static final SimpleDateFormat SIMPLEDATEFORMAT_DATE_FORMAT = new  SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/**
	 * <p>格式化金额  1000000.11
	 *  2012-9-19 下午01:32:52 edit by LiangBin 
	 *
	 * @param money
	 * @return
	 */
	public static String formatMoney(double money){
		return DECIMAL_FORMAT.format(money);
	}
	
	/**
	 * <p>格式化小数  1000000.11
	 * 2013-9-17 下午3:14:43 edit by LiangBin 
	 *
	 * @param num
	 * @param style #####0.00
	 * @return
	 */
	public static String formatNum(double num,String style){
		DecimalFormat df = new DecimalFormat(style);
		return df.format(num);
	}
	
	/**
	 * <p>格式化日期时间
	 * 2013-9-17 下午3:15:24 edit by LiangBin 
	 *
	 * @param date
	 * @param dateStyle
	 * @return
	 */
	public static String formatDataTime(Date date, String dateStyle){
		if(date == null){
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateStyle);
		dateFormat.applyPattern(dateStyle);
		return dateFormat.format(date);
	}
	
	/**
	 * <p>格式化日期时间
	 *  2012-9-19 下午01:34:31 edit by LiangBin 
	 *
	 * @param date
	 * @return
	 */
	public static String formatDataTime(Date date){
		if(date == null){
			return "";
		}
		return SIMPLEDATEFORMAT_DATE_FORMAT.format(date);
	}
	
	/**
	 * <p>字符串转日期
	 * 2013-9-17 下午3:15:59 edit by LiangBin
	 *
	 * @param dateStr
	 * @param dateStyle
	 * @return
	 */
	public static Date parseDate(String dateStr, String dateStyle){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateStyle);
			dateFormat.applyPattern(dateStyle);
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>字符串转timestamp
	 * 2016-7-11 下午3:15:59 edit by LiangBin
	 *
	 * @param dateStr
	 * @param dateStyle
	 * @return
	 */
	public static Timestamp parseTimestamp(String dateStr, String dateStyle){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateStyle);
			dateFormat.applyPattern(dateStyle);
			return new Timestamp(dateFormat.parse(dateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>字符串转化  把字符串中{0}、{1}...按顺序替换
	 * 2013-3-22 下午2:10:26 edit by LiangBin 
	 *
	 * @param str
	 * @param obj
	 * @return
	 */
	public static String replaceData4String(String str, Object...obj){
		for (int i = 0; i < obj.length; i++) {
			str = StringUtils.replace(str, "{" + i + "}", String.valueOf(obj[i]));
		}
		return str;
	}
	
	/**
	 * <p>返回每个月的天数
	 * 2014-1-9 下午3:50:40 edit by LiangBin 
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDayMonth(int year,int month){
		int num=0;
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			num=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			num=30;
			break;
		case 2:
			num = isLeapYear(year)?29:28;
			break;
		default:
			System.out.println("非法月份");
			break;
		}
		return num;
	}
	
	//定义方法isLeapYear()方法判断指定的年份是否为闰年
	public static boolean isLeapYear(int year){  
		if((year%4==0)&&(year%100!=0)||(year%400==0))
			return true;
		else
			return false;
	}
	
	public static int toWeekIndex(String weekStr){
		return Week.commentOf(weekStr).index;
	}
	
	public static Time toTime(String timeStr){
		return Time.valueOf(timeStr);
	}
	
	public enum Week{
		MONDAY(1,"星期一"),
		TUESDAY(2,"星期二"),
		WEDNESDAY(3,"星期三"),
		THURSDAY(4,"星期四"),
		FRIDAY(5,"星期五"),
		SATURDAY(6,"星期六"),
		SUNDAY(7,"星期日");
		
		private int index;
		private String comment;
		private Week(int index,String comment){
			this.index = index;
			this.comment = comment;
		}
		public static Week commentOf(String comment){
			Week[] weeks = Week.values();
			for (Week week : weeks) {
				if(week.comment.equals(comment)){
					return week;
				}
			}
			return null;
		}
		public static Week indexOf(int index){
			Week[] weeks = Week.values();
			for (Week week : weeks) {
				if(week.index == index){
					return week;
				}
			}
			return null;
		}
		public int getIndex() {
			return index;
		}
		public String getComment() {
			return comment;
		}
	}

	public static Long formatCheckoutPrice(String price){
		return Math.round(Double.valueOf(price) * 100);
	}

	public static String formatAlipayPrice(Long price){
		return formatMoney(price / 100.0);
	}

	/**
	 * 字符串类型值转基本类型值（反射中使用）
	 *
	 * @param value  值
	 * @param typeName  转化类型
	 * @return
	 * @throws ParseException
	 */
	public static Object stringParseBaseType(String value, String typeName){
		if(value == null || "null".equals(value)){
			return null;
		}
		Object fieldValue = value;
		if("double".equals(typeName) || "java.lang.Double".equals(typeName)){
			if(!NumberUtils.isNumber(value)){
				return 0;
			}
			fieldValue = NumberUtils.createNumber(value).doubleValue();
		}else if("int".equals(typeName) || "java.lang.Integer".equals(typeName)){
			if(!NumberUtils.isNumber(value)){
				return 0;
			}
			fieldValue = NumberUtils.createNumber(value).intValue();
		}else if("long".equals(typeName)  || "java.lang.Long".equals(typeName)){
			if(!NumberUtils.isNumber(value)){
				return 0;
			}
			fieldValue = NumberUtils.createNumber(value).longValue();
		}else if("float".equals(typeName) || "java.lang.Float".equals(typeName)){
			if(!NumberUtils.isNumber(value)){
				return 0;
			}
			fieldValue = NumberUtils.createNumber(value).floatValue();
		}else if("char".equals(typeName) || "java.lang.Character".equals(typeName)){
			fieldValue = typeName.charAt(0);
		}else if("byte".equals(typeName)|| "java.lang.Byte".equals(typeName)){
			fieldValue = Byte.valueOf(value);
		}else if("short".equals(typeName)|| "java.lang.Short".equals(typeName)){
			fieldValue = Short.valueOf(value);
		}else if("boolean".equals(typeName)|| "java.lang.Boolean".equals(typeName)){
			fieldValue = Boolean.valueOf(value);
		}
		return fieldValue;
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 * @param clazz
	 * @return
     */
	public static List<Field> getDeclaredFields(Class<?> clazz){
		Map<String,Field> fieldMap = new HashMap<String,Field>();

		for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
			try {
				Field [] fields = clazz.getDeclaredFields() ;
				for (Field field : fields){
					fieldMap.put(field.getName(),field);
				}
			} catch (Exception e) {
				//这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				//如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了

			}
		}

		return new ArrayList<>(fieldMap.values());
	}

}

