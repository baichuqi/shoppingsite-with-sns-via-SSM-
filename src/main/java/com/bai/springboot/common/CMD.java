package com.bai.springboot.common;

public class CMD {

	
	public static final String USER_NAME_CREATE = "/USER_NAME_CREATE/";

    public static boolean isCMD(String message) {
        return message.startsWith(USER_NAME_CREATE);
    }
}
