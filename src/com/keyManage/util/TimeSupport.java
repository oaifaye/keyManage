package com.keyManage.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeSupport {
	
	/**
	 * 将字符串时间格式化为需要的Timestamp格式
	 * @param dateString 要被格式化的时间字符串
	 * @param dateFormat 需要的格式，如yyyy-MM-dd HH:mm
	 * @return Timestamp类型的时间
	 * */
	public static Timestamp parseTime(String dateString,String dateFormat){
		Timestamp reslutTime = null;
		try {
			SimpleDateFormat formate = new SimpleDateFormat(dateFormat);
			reslutTime=new Timestamp(formate.parse(dateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reslutTime;
	}
	
	/**
	 * 将字符串时间格式化为需要的Timestamp格式
	 * @param dateString 要被格式化的Timestamp时间
	 * @param dateFormat 需要的格式，如yyyy-MM-dd HH:mm
	 * @return Timestamp类型的时间
	 * */
	public static Timestamp parseTime(Timestamp dateString,String dateFormat){
		Timestamp reslutTime = null;
		try {
			SimpleDateFormat formate = new SimpleDateFormat(dateFormat);
			reslutTime=new Timestamp(formate.parse(dateString.toString()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reslutTime;
	}
	
	/**
	 * 将Timestamp时间格式化为需要的String格式
	 * @param dateTime 要被格式化的Timestamp时间
	 * @param dateFormat 需要的格式，如yyyy-MM-dd HH:mm
	 * @return String类型的时间
	 * */
	public static String formateTime(Timestamp dateTime,String dateFormat){
		String reslutTime;
		SimpleDateFormat formate = new SimpleDateFormat(dateFormat);
		reslutTime=formate.format(dateTime);
		return reslutTime;
	}
	
}
	
