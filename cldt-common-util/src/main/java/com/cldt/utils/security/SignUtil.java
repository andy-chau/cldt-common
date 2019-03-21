package com.cldt.utils.security;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/**
 * 编解码.
 *
 * @author zhoukj
 * @created 2016年10月18日 下午3:51:34
 */
public class SignUtil {
	
	public static String sortJsonStringByAscii(String jsonString){
		if(jsonString==null || jsonString.length()<=0 )
			return null;
		String[] jsonArr=jsonString.replaceAll("^\\{|\\}$", "").split(",");
		Arrays.sort(jsonArr);
		String sortedJsonStr=StringUtils.join(jsonArr, ",");
		sortedJsonStr="{"+sortedJsonStr+"}";
		
		return sortedJsonStr;
	}

	public static void main(String[] args){
		System.out.println(sortJsonStringByAscii("{\"mobile\":\"18664971369\",\"type\":1}"));
		System.out.println();
		System.out.println(MD5Encrypt.md5("gLC0qvcenWp8k38SRfIJ5uDf{\"mobile\":\"18664971369\",\"type\":1}"));
	}
}
