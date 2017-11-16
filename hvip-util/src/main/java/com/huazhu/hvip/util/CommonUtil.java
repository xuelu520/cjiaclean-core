/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CommonUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

/**
 *
 */
package com.huazhu.hvip.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtil {

    /**
     * 产生2,3,6随机数
     *
     * @param n :表示几位
     * @return
     */
    public static int createRandomNum(int n) {
        Random rand = new Random();

        if (n == 3) {
            int ro = rand.nextInt(999);
            while (ro < 100)
                ro += ro * 10;
            return ro;
        } else if (n == 4) {
            int ro = rand.nextInt(9999);
            while (ro < 1000)
                ro += ro * 10;
            return ro;

        } else {
            // 默认是六位随机数
            int ro = rand.nextInt(999999);
            while (ro < 100000)
                ro += ro * 10;
            return ro;
        }
    }

    // 计算两个时间点之间秒钟差
    public static long calInterSec(String src) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date d1 = df.parse(src);
            Date d2 = new Date();
            long diff = (d2.getTime() - d1.getTime()) / 1000;
            return diff;
        } catch (Exception e) {
            return 0l;
        }
    }

    // 计算两个时间点之间毫秒差
    public static long calInterMill(Date date) {

        try {
            Calendar now = Calendar.getInstance();
            now.setTime(date);
            now.add(Calendar.HOUR_OF_DAY, 2);
            Date start = new Date();
            long diff = (now.getTimeInMillis() - start.getTime()) / 1000;
            return diff;
        } catch (Exception e) {
            return 0l;
        }
    }

    public static String generatePrimaryKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // 拼接sql条件为 or
    public static String buildListParamter4Query(String name, Object[] paras, String oper) {
        String sql = "";
        if (paras != null && paras.length > 0) {
            boolean isString = false;
            if (StringUtils.isBlank(oper)) {
                oper = " = ";
            }
            if (paras[0] instanceof String) {
                isString = true;
            }
            sql += " and ( ";
            for (int i = 0; i < paras.length; i++) {
                if (isString) {
                    sql += name + oper + "'" + paras[i] + "' or ";
                } else {
                    sql += name + oper + paras[i] + " or ";
                }
            }
            if (sql.endsWith("or ")) {
                sql = StringUtils.removeEnd(sql, "or ");
            }
            sql += ")";
        }
        return sql;
    }

    public static String getCharAndNumr(int length) {
        String val = RandomStringUtils.randomAlphanumeric(length);

        if (!isNumeric(val)) {
            val = StringUtils.substring(val, 0, 5) + RandomStringUtils.randomNumeric(1);
        }
        return val;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]+?");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.find()) {
            return false;
        }
        return true;
    }

    public static String[] chineseDigits = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    /**
     * 把金额转换为汉字表示的数量，小数点后四舍五入保留两位
     *
     * @param amount
     * @return
     */
    public static String amountToChinese(double amount) {

        if (amount > 99999999999999.99 || amount < -99999999999999.99)
            throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");

        boolean negative = false;
        if (amount < 0) {
            negative = true;
            amount = amount * (-1);
        }

        long temp = Math.round(amount * 100);
        int numFen = (int) (temp % 10); // 分
        temp = temp / 10;
        int numJiao = (int) (temp % 10); //角
        temp = temp / 10;
        //temp 目前是金额的整数部分

        int[] parts = new int[20]; // 其中的元素是把原来金额整数部分分割为值在 0~9999 之间的数的各个部分
        int numParts = 0; // 记录把原来金额整数部分分割为了几个部分（每部分都在 0~9999 之间）
        for (int i = 0; ; i++) {
            if (temp == 0)
                break;
            int part = (int) (temp % 10000);
            parts[i] = part;
            numParts++;
            temp = temp / 10000;
        }

        boolean beforeWanIsZero = true; // 标志“万”下面一级是不是 0

        String chineseStr = "";
        for (int i = 0; i < numParts; i++) {

            String partChinese = partTranslate(parts[i]);
            if (i % 2 == 0) {
                if ("".equals(partChinese))
                    beforeWanIsZero = true;
                else
                    beforeWanIsZero = false;
            }

            if (i != 0) {
                if (i % 2 == 0)
                    chineseStr = "亿" + chineseStr;
                else {
                    if ("".equals(partChinese) && !beforeWanIsZero)   // 如果“万”对应的 part 为 0，而“万”下面一级不为 0，则不加“万”，而加“零”
                        chineseStr = "零" + chineseStr;
                    else {
                        if (parts[i - 1] < 1000 && parts[i - 1] > 0) // 如果"万"的部分不为 0, 而"万"前面的部分小于 1000 大于 0， 则万后面应该跟“零”
                            chineseStr = "零" + chineseStr;
                        chineseStr = "万" + chineseStr;
                    }
                }
            }
            chineseStr = partChinese + chineseStr;
        }

        if ("".equals(chineseStr))  // 整数部分为 0, 则表达为"零元"
            chineseStr = chineseDigits[0];
        else if (negative) // 整数部分不为 0, 并且原金额为负数
            chineseStr = "负" + chineseStr;

        chineseStr = chineseStr + "元";

        if (numFen == 0 && numJiao == 0) {
            chineseStr = chineseStr + "整";
        } else if (numFen == 0) { // 0 分，角数不为 0
            chineseStr = chineseStr + chineseDigits[numJiao] + "角";
        } else { // “分”数不为 0
            if (numJiao == 0)
                chineseStr = chineseStr + "零" + chineseDigits[numFen] + "分";
            else
                chineseStr = chineseStr + chineseDigits[numJiao] + "角" + chineseDigits[numFen] + "分";
        }

        return chineseStr;

    }


    /**
     * 把一个 0~9999 之间的整数转换为汉字的字符串，如果是 0 则返回 ""
     *
     * @param amountPart
     * @return
     */
    private static String partTranslate(int amountPart) {

        if (amountPart < 0 || amountPart > 10000) {
            throw new IllegalArgumentException("参数必须是大于等于 0，小于 10000 的整数！");
        }


        String[] units = new String[]{"", "拾", "佰", "仟"};

        int temp = amountPart;

        String amountStr = new Integer(amountPart).toString();
        int amountStrLength = amountStr.length();
        boolean lastIsZero = true; //在从低位往高位循环时，记录上一位数字是不是 0
        String chineseStr = "";

        for (int i = 0; i < amountStrLength; i++) {
            if (temp == 0)  // 高位已无数据
                break;
            int digit = temp % 10;
            if (digit == 0) { // 取到的数字为 0
                if (!lastIsZero)  //前一个数字不是 0，则在当前汉字串前加“零”字;
                    chineseStr = "零" + chineseStr;
                lastIsZero = true;
            } else { // 取到的数字不是 0
                chineseStr = chineseDigits[digit] + units[i] + chineseStr;
                lastIsZero = false;
            }
            temp = temp / 10;
        }
        return chineseStr;
    }

    /**
     * 判断字符串是否为空或者是NULL
     *
     * @param str
     * @return boolean
     */
    public static boolean isNullOREmpty(String str) {
        return (null == str || "".equals(str));
    }

    /**
	 * 获取支付结果中的支付信息参数值
	 */
	public static double getPayAmount(String payInfo, String dataName){
		if(StringUtil.isEmpty(payInfo) || StringUtil.isEmpty(dataName))
			return 0.00;

		String remark[] = payInfo.split("\\|");
		double dataValue = 0.00;
		for(String param : remark){
			String keyValue[] = param.trim().split("\\^");
			if(keyValue[0].equals(dataName)){
				dataValue = Double.valueOf(keyValue[2]);
				break;
			}
		}

		return dataValue;
	}

    public static void main(String[] args) {

        String s = "CRMValue|CRMPoint";
        String[] methods = s.split("\\|");
        System.out.println(methods);
//        if(args.length == 0) {
//            System.out.println("转换演示：");
//            System.out.println("-------------------------");
//            System.out.println("25000000000005.999: " + amountToChinese(25000000000005.999));
//            System.out.println("45689263.626: " + amountToChinese(45689263.626));
//            System.out.println("0.69457: " + amountToChinese(0.69457));
//            System.out.println("253.0: " + amountToChinese(253.0));
//            System.out.println("0: " + amountToChinese(0));
//            System.out.println("-------------------------");
//
//            System.out.println("999: " + amountToChinese(999));
//
//            //System.out.println(Long.MAX_VALUE);
//            //System.out.println(Long.MIN_VALUE);
//        }
//        else {
//            System.out.println("转换结果：");
//            System.out.println(args[0] + ": " + amountToChinese(Double.parseDouble(args[0])));
//        }

    }
}
