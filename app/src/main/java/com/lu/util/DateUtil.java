package com.lu.util;

import java.util.Calendar;

public class DateUtil {
	private static Calendar calendar=null;
	
	/**
	 * 
	 * @return ��ǰ����ʱ�� ��ʽ2014-11-18 14:16:33 
	 */
	public static String getDate(){
		
		return getDay()+" "+getTime();
	}
	/**
	 * 
	 * @return ��ǰ����ʱ�� ��ʽ2014/11/18 14:16:33 
	 */
	public static String getDate2(){
		
		return getDay2()+" "+getTime();
	}
	/**
	 * 
	 * @return ��ǰ����ʱ�� ��ʽ2014_11_18_14_16_33 
	 */
	public static String getDate3(){
		
		return getDay3()+"_"+getTime3();
	}
	/**
	 * 
	 * @return��ǰʱ�� ��ʽ14:16:33 
	 */
	public static String getTime(){
		calendar=Calendar.getInstance();
		StringBuffer buffer=new StringBuffer();
		final int hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<10){
			buffer.append("0"+hour);
		}else{
			buffer.append(String.valueOf(hour));
		}
		buffer.append(":");
		final int minute=calendar.get(Calendar.MINUTE);
		if(minute<10){
			buffer.append("0"+minute);
		}else{
			buffer.append(String.valueOf(minute));
		}
		buffer.append(":");
		final int second=calendar.get(Calendar.SECOND);
		if(second<10){
			buffer.append("0"+second);
		}else{
			buffer.append(String.valueOf(second));
		}
		
		return new String(buffer);
	}
	/**
	 * 
	 * @return��ǰʱ�� ��ʽ14_16_33 
	 */
	public static String getTime3(){
		calendar=Calendar.getInstance();
		StringBuffer buffer=new StringBuffer();
		final int hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<10){
			buffer.append("0"+hour);
		}else{
			buffer.append(String.valueOf(hour));
		}
		buffer.append("_");
		final int minute=calendar.get(Calendar.MINUTE);
		if(minute<10){
			buffer.append("0"+minute);
		}else{
			buffer.append(String.valueOf(minute));
		}
		buffer.append("_");
		final int second=calendar.get(Calendar.SECOND);
		if(second<10){
			buffer.append("0"+second);
		}else{
			buffer.append(String.valueOf(second));
		}
		
		return new String(buffer);
	}
	/**
	 * 
	 * @return��ǰʱ�� ��ʽ 14:16:33 ���� 2:16 
	 */
	public static String getTime2(){
		calendar=Calendar.getInstance();
		StringBuffer buffer=new StringBuffer();
		 int hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour >12){
			buffer.append("����  ");
			hour-=12;
		}else{
			buffer.append("����  ");
			
		}
		
//		if(hour<10){
//			buffer.append("0"+hour);
//		}else {
			buffer.append(String.valueOf(hour));
//		}
		
		
		buffer.append(":");
		final int minute=calendar.get(Calendar.MINUTE);
		if(minute<10){
			buffer.append("0"+minute);
		}else{
			buffer.append(String.valueOf(minute));
		}
		
	
		
		return new String(buffer);
	}
	
	/**
	 * 
	 * @return ��ǰ���� 2014-11-27
	 */
	public static String getDay(){
		calendar=Calendar.getInstance();
		final StringBuffer buffer=new StringBuffer();
		
		final int year=calendar.get(Calendar.YEAR);
		if(year<10){
			buffer.append("0"+year);
		}else{
			buffer.append(String.valueOf(year));
		}
		buffer.append("-");
		final int mouth=(calendar.get(Calendar.MONTH)+1);
		if(mouth<10){
			buffer.append("0"+mouth);
		}else{
			buffer.append(String.valueOf(mouth));
		}
		buffer.append("-");
		final int day=calendar.get(Calendar.DAY_OF_MONTH);
		if(day<10){
			buffer.append("0"+day);
		}else{
			buffer.append(String.valueOf(day));
		}
		
		return new String(buffer);
	}
	/**
	 * 
	 * @return ��ǰ���� 2014_11_27
	 */
	public static String getDay3(){
		calendar=Calendar.getInstance();
		final StringBuffer buffer=new StringBuffer();
		
		final int year=calendar.get(Calendar.YEAR);
		if(year<10){
			buffer.append("0"+year);
		}else{
			buffer.append(String.valueOf(year));
		}
		buffer.append("_");
		final int mouth=(calendar.get(Calendar.MONTH)+1);
		if(mouth<10){
			buffer.append("0"+mouth);
		}else{
			buffer.append(String.valueOf(mouth));
		}
		buffer.append("_");
		final int day=calendar.get(Calendar.DAY_OF_MONTH);
		if(day<10){
			buffer.append("0"+day);
		}else{
			buffer.append(String.valueOf(day));
		}
		
		return new String(buffer);
	}
	/**
	 * 
	 * @return ��ǰ���� 2014/11/27
	 */
	public static String getDay2(){
		calendar=Calendar.getInstance();
		final StringBuffer buffer=new StringBuffer();
		
		final int year=calendar.get(Calendar.YEAR);
		if(year<10){
			buffer.append("0"+year);
		}else{
			buffer.append(String.valueOf(year));
		}
		buffer.append("/");
		final int mouth=(calendar.get(Calendar.MONTH)+1);
		if(mouth<10){
			buffer.append("0"+mouth);
		}else{
			buffer.append(String.valueOf(mouth));
		}
		buffer.append("/");
		final int day=calendar.get(Calendar.DAY_OF_MONTH);
		if(day<10){
			buffer.append("0"+day);
		}else{
			buffer.append(String.valueOf(day));
		}
		return new String(buffer);
	}
	
	
}
