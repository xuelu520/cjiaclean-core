/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SimpleMemeryCache.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;

import java.util.HashMap;
import java.util.Map;


public class SimpleMemeryCache{
	
	private static SimpleMemeryCache instance;
	
   
	private  Map<String, Object> dataMap;

    private  SimpleMemeryCache(){
    }
    
    public synchronized static SimpleMemeryCache getInstance(){
    	if(instance==null){
    		
    		instance= new SimpleMemeryCache();
    	}
    	return instance;
    }

     public synchronized void pub(String name,Object value) {
    	 if(dataMap==null){
    		 dataMap = new HashMap<String, Object> ();
    	 }
    	 dataMap.put(name, value);
     }
     
     public synchronized Object get(String name) {
    	 Object obj= null;
    	 if(dataMap!=null && dataMap.containsKey(name)){
    		 obj = dataMap.get(name);
    	 }
    	
    	 return obj;
    	 
     }
}
