package com.lxl.lu.util;


import java.text.DecimalFormat;

public class StringUtil {


	public static void formatNumber(double d) {
		final DecimalFormat decimalFormat = new DecimalFormat("#.00");
		decimalFormat.format(d);
	}
}
