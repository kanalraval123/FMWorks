package com.imageupload.util;

import java.util.Calendar;

public class Util {
	public static long getTimeInLong() {
		return Calendar.getInstance().getTime().getTime();
	}
}
