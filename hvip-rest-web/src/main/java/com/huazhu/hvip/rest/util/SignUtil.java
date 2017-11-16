package com.huazhu.hvip.rest.util;

import com.huazhu.hvip.util.DMD5;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Sign 签名⽣生成规则与验签:
 * 调⽤用 API 时需要对请求参数进⾏行签名,服务端请验证请求参数是否合法。
 * 加密规则：
 * 1 所有请求参数按照字母先后顺序排列
 * 例如:将 hotelId, memberId, resNo, goodsIdList 排序
 * 2 把所有参数名和参数值进⾏行拼装 例如:
 * goodsIdList[1, 2, 3]memberId030999810resNoR20005140000048105
 * 3 把 appSecret 夹在字符串的两端
 * 例如:appSecret + XXXX + appSecret
 * 4 使⽤用 MD5 进⾏行加密,再转化成⼤大写
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SignUtil {

    private static Logger logger = LogManager.getLogger(SignUtil.class);

    public static String encryptSign(Map<String, String> map,String APP_SECRET) {
        String signStr = "";
        try {
            //签名数据
            signStr += APP_SECRET;
            if (map == null) {
                return null;
            }

            //所有参数按照字母想顺序排序
            Set<String> keySet = sortMapKey(map);

            //循环生成签名数据值
            for (String key : keySet) {
                signStr += key + map.get(key);
            }
            signStr += APP_SECRET;
            logger.info("call encryptSign({" + signStr + "})");
            //签名用md5编码
            signStr = DMD5.md5Encode(signStr);
            //转换为大写
            signStr = signStr.toUpperCase();
        } catch (Exception e) {
            logger.error("call encryptSign error", e);
        }
        return signStr;
    }

    //所有参数按照字母想顺序排序
    private static Set sortMapKey(Map map) {
        Set keySet = map.keySet();
        List list = new ArrayList(map.keySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object a, Object b) {
                return a.toString().toLowerCase().compareTo(b.toString()
                        .toLowerCase());
            }
        });
        keySet = new TreeSet(list);
        return keySet;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("hotelId", "2777991");

        String signStr = SignUtil.encryptSign(map,"R8C36C45EH76OP7F9RMJ5KYDD7R0IV8P");
        System.out.println(signStr);

        Map<String,String> map1 = new HashMap<>();
        map1.put("memberId", "030999810");
        map1.put("resNo","R20110720000078211");
        List<Integer> goodsIdList = new ArrayList<>();
        goodsIdList.add(1);
        goodsIdList.add(2);
        goodsIdList.add(3);
        String goodsIdListStr = "";
        for(Integer goodsId : goodsIdList){
            goodsIdListStr += goodsId;
        }
        map1.put("goodsIdList",goodsIdListStr);

        String signStr1 = SignUtil.encryptSign(map1,"V8C37E33DEFDE51IF91E1E03E51657DP");
        System.out.println(signStr1);

        Map<String,String> map2 = new HashMap<>();
        map2.put("year","2016");
        map2.put("month","7");
        String signStr2 = SignUtil.encryptSign(map2,"V8C37E33DEFDE51IF91E1E03E51657DP");
        System.out.println(signStr2);

    }



}
