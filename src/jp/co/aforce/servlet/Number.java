package jp.co.aforce.servlet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Number {

	public static String time() {
		LocalDateTime nowDate = LocalDateTime.now();


	     DateTimeFormatter dtf3 =
	             DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	                 String formatNowDate = dtf3.format(nowDate);

					return formatNowDate;

	}



}
