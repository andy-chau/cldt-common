package com.cldt.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    
    /**
     * 将json数据转换成对象map
     * <p>Title: jsonToMap</p>
     * <p>Description: </p>
     * @param jsonData
     * @return
     */
    public static Map<String, String> jsonToMap(String jsonData,String ...key)  
	   {     
	    JSONArray json =null;
		try
		{
			json = new JSONArray(jsonData);
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
		JSONObject jsonOne=null;
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<json.length();i++){
			try
				{
					jsonOne = json.getJSONObject(i);
					map.put((String) jsonOne.get(key[0]),(String) jsonOne.get(key[1]));
				} catch (JSONException e)
				{
					e.printStackTrace();
				} 
		}
		return map;  
	   }
    

    
}
