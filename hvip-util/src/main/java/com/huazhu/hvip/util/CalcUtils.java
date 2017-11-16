/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CalcUtils.java
 * Author:   admin
 * Date:     2016-03-10 17:06:44
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 17:06:44><version><desc><source>
 */

package com.huazhu.hvip.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用于计算的工具类
 * <功能详细描述>
 *
 * @auth: HUQIANBO
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CalcUtils {

    /**
     * <strong>该方法计算可能存在误差，请使用方法{@link #formatRent(BigDecimal)}</strong>
     * @version 1.0
     * @see #formatPrice(double)
     */
    @Deprecated
    public static long formatPrice(BigDecimal price) {
        return formatPrice(price.doubleValue());
    }

    /**
     * 根据规则计算价格<br>
     * <p>1.如果计算出来有小数，四舍五入取整</p>
     * <p>2.取整后再采用四舍五入将价格精确到十位，例如： 2976会被处理为2980</p>
     * <p>3.如果个、十、百位上的数字都为9（有可能是第一次四舍五入前或者后），那么以上两条规则都作废，直接舍弃小数取整，例如： 2999.82会被处理为2999</p>
     * <p>4.价格必须大于0</p>
     * <strong>该方法计算可能存在误差，请使用方法{@link #formatRent(double)}</strong>
     *
     * @param price 原始价格
     * @return 规范后的价格
     * @version 1.0
     */
    @Deprecated
    public static long formatPrice(double price) {
        //将价格转为整数（分），四舍五入取整数
        long newPrice = (long) Math.rint(price);
        //获取整数元部分，去掉分和角
        long integralPart = newPrice / 100;
        //如果不足10元则为10元
        if (integralPart < 10) {
            newPrice = 10;
        } else {
            //获取最后的三位，元、角、分
            long tempPrice = newPrice % 1000;
            //如果后三位小于445则舍为0元
            if (tempPrice < 445) {
                newPrice = (integralPart / 10) * 10;
                //如果大于等于445小于845则向进位
            } else if (tempPrice < 845) {
                newPrice = ((integralPart / 10) + 1) * 10;
                //如果大于等于845，则个位向十位进一
            } else {
                //取十位和百位
                tempPrice = integralPart % 1000 / 10;
                //获取千位
                long temp = integralPart / 1000;
                //如果百位和十位不足10，则十位+1
//                if (tempPrice < 10) {
//                    newPrice = temp * 1000 + (tempPrice + 1) * 10;
//                } else
                //如果百位和十位不足99，则十位+1
                if (tempPrice < 99) {
                    newPrice = temp * 1000 + (tempPrice + 1) * 10;
                    //否则视为999
                } else {
                    newPrice = temp * 1000 + 999;
                }
            }
        }
        return newPrice * 100;
    }

    /**
     * @version 1.1
     * @see #formatRent(double)
     */
    public static long formatRent(BigDecimal rent) {
        return formatRent(rent.doubleValue());
    }

    /**
     * 租金计算规则：(该方法以分为单位进行计算)<br>
     * <p>1.将原数值的小数部分直接去掉，不做四舍五入操作（由架构确定）</p>
     * <p>2.直接舍弃分，不以分做四舍五入（由产品确定）</p>
     * <p>3.如果原始值的整元部分的个、十、百位为999，则去掉原始值的小数部分，直接返回该整元值</p>
     * <p>4.以角作四舍五入</p>
     * <p>5.如果计算出来的整元部分个、十、百位为999，则直接返回</p>
     * <p>6.如果计算出来的整元部分个、十、百位不为999，如果该整元部分大于100则以个位进行四舍五入</p>
     *
     * @param rent 原始租金，以分为单位
     * @return 根据规则规范化后的租金，以分为单位
     * @version 1.1
     */
    public static long formatRent(double rent) {
        //将租金的小数部分直接丢弃，转换为整分值
        long newRent = (long) rent;
        //获取整数元部分，去掉分和角
        long integralYuanPart = newRent / 100;
        //如果原金额的整元部分末尾为999，则直接返回去掉小数后的整数值，*100转换为分
        if (999 == integralYuanPart % 1000) {
            newRent = integralYuanPart * 100;
        } else {
            //直接舍弃分获取角，以角做四舍五入
            int decimalJiaoPart = (int) ((newRent / 10) % 10);
            //如果角大于等于5则进一位，整元各位+1，否则不变，直接舍弃角
            long tempRent = integralYuanPart;
            if (decimalJiaoPart >= 5) {
                tempRent = integralYuanPart + 1;
            }
            //如果以角四舍五入之后的整元的个、十、百位不为999，则以元做四舍五入
            if (999 != tempRent % 1000) {
                //如果值大于100才做各位四舍五入运算
                if (tempRent > 100) {
                    //获取整元的个位
                    int integralUnitPart = (int) (tempRent % 10);
                    //如果整元的个位大于等于5则进位，十位+1，否则舍弃个位
                    if (integralUnitPart >= 5) {
                        newRent = (tempRent / 10 + 1) * 10;
                    } else {
                        newRent = (tempRent / 10) * 10;
                    }
                } else {
                    if (tempRent <= 0) {
                        newRent = 0;
                    } else {
                        newRent = tempRent;
                    }
                }
            } else {
                newRent = tempRent;
            }
            //*100转换为分
            newRent = newRent * 100;
        }
        return newRent;
    }

    /**
     * <strong>该方法计算可能存在误差，请使用方法{@link #formatCommonFee(BigDecimal)}</strong>
     * @version 1.0
     * @see #formatServiceFee(double)
     */
    public static long formatServiceFee(BigDecimal price) {
        return formatServiceFee(price.doubleValue());
    }

    /**
     * 服务费格式化，精确到十元（十位）<br>
     * <p>1.如果计算出来有小数，四舍五入取整</p>
     * <p>2.取整后再采用四舍五入将价格精确到十位，例如： 2976会被处理为2980</p>
     * <strong>该方法计算可能存在误差，请使用方法{@link #formatCommonFee(double)}</strong>
     *
     * @param serviceFee
     * @return
     * @version 1.0
     */
    @Deprecated
    public static long formatServiceFee(double serviceFee) {
        long newPrice = (long) Math.rint(serviceFee);
        //获取整数元部分，去掉分和角
        double integralPart = new BigDecimal(newPrice).divide(new BigDecimal("100.0")).doubleValue();
        //如果不足10元则为10元
        if (integralPart < 10) {
            newPrice = 10;
        } else {
            long tempPrice = (long) Math.rint(integralPart);
            newPrice = ((long) Math.rint((tempPrice / 10.0))) * 10;
        }
        return newPrice * 100;
    }

    /**
     * @version 1.1
     * @see #formatCommonFee(double)
     */
    public static long formatCommonFee(BigDecimal fee) {
        return formatCommonFee(fee.doubleValue());
    }

    /**
     * 定金、服务费、押金等常规费用的计算规则：(该方法以分为单位进行计算)<br>
     * <p>1.将原数值的小数部分直接去掉，不做四舍五入操作（由架构确定）</p>
     * <p>2.直接舍弃分，不以分做四舍五入（由架构确定）</p>
     * <p>3.以角作四舍五入</p>
     * <p>4.如果计算出来的整元部分大于100则以个位进行四舍五入</p>
     *
     * @param fee 定金、服务费、押金等常规费用，以分为单位
     * @return 规范化后的费用，以分为单位
     * @version 1.1
     */
    public static long formatCommonFee(double fee) {
        //丢弃小数
        long tempFee = (long) fee;
        //获取整数元部分，去掉分和角
        long newFee = tempFee / 100;
        //直接舍弃分获取角，以角做四舍五入
        int decimalJiaoPart = (int) ((tempFee / 10) % 10);
        //如果角大于等于5则进一位，整元各位+1，否则不变，直接舍弃角
        if (decimalJiaoPart >= 5) {
            newFee = tempFee / 100 + 1;
        }
        if (newFee > 100) {
            //获取整元的个位
            int integralUnitPart = (int) (newFee % 10);
            //如果整元的个位大于等于5则进位，十位+1，否则舍弃个位
            if (integralUnitPart >= 5) {
                tempFee = (newFee / 10 + 1) * 10;
            } else {
                tempFee = (newFee / 10) * 10;
            }
        } else {
            if (newFee <= 0) {
                tempFee = 0;
            } else {
                tempFee = newFee;
            }
        }
        return tempFee * 100;
    }

    /**
     * 仅为换房提供接口，在整体价格系统调整时，需要删除该方法
     *
     * @param serviceFee 服务费
     * @return 服务费
     */
    public static long formatServiceFee_ForChangeRoom(double serviceFee) {
        long newPrice = (long) Math.rint(serviceFee);
        //获取整数元部分，去掉分和角
        double integralPart = new BigDecimal(newPrice).divide(new BigDecimal("100.0")).doubleValue();
//        //如果不足10元则为10元
//        if (integralPart < 10) {
//            newPrice = 10;
//        } else {
        long tempPrice = (long) Math.rint(integralPart);
        newPrice = ((long) Math.rint((tempPrice / 10.0))) * 10;
//        }
        return newPrice * 100;
    }

    public static List<Integer> setCalcList(int begin, int end) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = begin; i < end; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> retainCalcList(List<Integer> leaseList, List<Integer> paywayList) {
        List<Integer> s1 = new ArrayList<Integer>(leaseList);
        List<Integer> s2 = new ArrayList<Integer>(paywayList);
        s1.retainAll(s2);
        return s1;
    }

    public static void main(String[] args) {
//            List<Integer> leaseList = setCalcList(2,10);
//            List<Integer> paywayList = setCalcList(1,3);
//            List<Integer> paywayList1 = setCalcList(3,7);
//            List<Integer> paywayList2 = setCalcList(9,13);
//            List<Integer> paywayList3 = setCalcList(8,13);
//            List<Integer> i = retainCalcList(leaseList, paywayList);
//            List<Integer> i2 = retainCalcList(leaseList, paywayList1);
//            List<Integer> i3 = retainCalcList(leaseList,paywayList2);
//            List<Integer> i4 = retainCalcList(leaseList,paywayList3);
//
//        System.out.println("取得交集为 " + i.toString() + "最小值为 " + Collections.min(i) + " , 最大值为 " + Collections.max(i));
//        System.out.println("取得交集为 " + i2.toString() + "最小值为 " + Collections.min(i2) + " , 最大值为 " + Collections.max(i2));
//        System.out.println("取得交集为 " + i3.toString() + "最小值为 " + Collections.min(i3) + " , 最大值为 " + Collections.max(i3));
//        System.out.println("取得交集为 " + i4.toString() + "最小值为 " + Collections.min(i4) + " , 最大值为 " + Collections.max(i4));
    }

}
