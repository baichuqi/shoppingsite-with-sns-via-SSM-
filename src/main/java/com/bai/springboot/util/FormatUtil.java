package com.bai.springboot.util;
import org.springframework.util.StringUtils;
public class FormatUtil {

	
	 /**
     * 过滤脚本
     * @param contant
     * @return
     */
    public static String formatScript(String contant) {
        if(StringUtils.isEmpty(contant)) {
            return contant;
        }
        contant = contant.replace("<", "&lt;");
        contant = contant.replace(">", "&gt;");
        return contant;
    }
}
