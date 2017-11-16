/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SerialUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;


public class SerialUtil {

    public static String generateSerialNo(String jsonRule, HashMap paramMap) {
        Collection<HashMap> list2 = JSONArray.toList(JSONArray.fromObject(jsonRule), HashMap.class);
        String result = "";
        for (HashMap rule : list2) {
            if ("staticChar".equals(rule.get("type"))) {
                result = result + rule.get("value");
            } else if ("datetime".equals(rule.get("type"))) {

                String format = (String) rule.get("format");
                SimpleDateFormat sdf = new SimpleDateFormat(format);

                String paramValueName = (String) rule.get("paramValueName");

                Date value = new Date();
                if (paramValueName != null && !"".equals(paramValueName)) {
                    value = (Date) paramMap.get(paramValueName);

                }

                String tmp = sdf.format(value);
                result = result + tmp;

            } else if ("randomChar".equals(rule.get("type"))) {
                int length = ((Integer) rule.get("length")).intValue();
                String randString = RandomStringUtils.randomAlphabetic(length);
                result = result + randString;
            } else if ("randomNum".equals(rule.get("type"))) {
                int length = ((Integer) rule.get("length")).intValue();
                String randString = RandomStringUtils.randomNumeric(length);
                result = result + randString;
            } else if ("serial".equals(rule.get("type"))) {

                int start = ((Integer) rule.get("start")).intValue();
                int length = ((Integer) rule.get("length")).intValue();

                String paramValueName = (String) rule.get("paramValueName");
                int curValue = ((Integer) paramMap.get(paramValueName)).intValue();

                result = result + StringUtils.leftPad("" + curValue, length, "0");

            } else if ("param".equals(rule.get("type"))) {
                result = result + paramMap.get((String) rule.get("paramValueName"));
            } else if ("currentTimeMillis".equals(rule.get("type"))) {
                Long currTime =  System.currentTimeMillis();
                result = result + currTime;
            } else {

            }

            // System.out.println(rule.toString());
        }
        return result;
    }

    public static void main(String[] args) {

        List list = new ArrayList();

        HashMap map = new HashMap();
        map.put("type", "staticChar");
        map.put("value", "PO");
        list.add(map);

        map = new HashMap();
        map.put("type", "datetime");
        map.put("format", "yyyyMMdd");
        map.put("paramValueName", "billDate");

        list.add(map);

        map = new HashMap();
        map.put("type", "randomChar");
        map.put("length", new Integer(2));
        list.add(map);

        map = new HashMap();
        map.put("type", "randomNum");
        map.put("length", new Integer(2));
        list.add(map);

        map = new HashMap();
        map.put("type", "serial");
        map.put("start", new Integer(100));
        map.put("length", new Integer(4));
        map.put("paramValueName", "curValue");

        list.add(map);

        map = new HashMap();
        map.put("type", "param");
        map.put("paramValueName", "dept");

        list.add(map);

        //JSONArray jsonArray1 = JSONObject.fromObject(list);

        String str = null;//jsonArray1.toString();
        System.out.println(str);

        HashMap paramMap = new HashMap();
        paramMap.put("billDate", new Date());
        paramMap.put("curValue", 304);
        paramMap.put("dept", "IT");

        String sequNo = generateSerialNo(str, paramMap);

			/*

			[{"value":"PO","type":"staticChar"},{"paramValueName":"billDate","format":"yyyyMMdd","type":"datetime"},{"length":2,"type":"randomChar"},{"length":2,"type":"randomNum"},{"paramValueName":"curValue","start":100,"length":4,"type":"serial"},{"paramValueName":"dept","type":"param"}]

			*/
        //JSONObject jsonObject2 = JSONObject.fromObject(str);

	/*
            Collection<HashMap> list2 = JSONArray.toList(JSONArray.fromObject(str), HashMap.class);
		      //DateUtil.getFormatDate(date,fmtstr)日期转字符串这里不再写代码了
		   for (HashMap map1 : list2) {
		      System.out.println(map1.toString());
		   } */


        //	List list2 = (List) JSONObject.toBean(jsonObject2, ArrayList.class);


        System.out.println(sequNo);


    }

}