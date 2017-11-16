package com.huazhu.hvip.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FinanceSubject {

    public static void main(String[] args) {

        List<GoodsFinanceSubject> list = new ArrayList<>();

        Long[] goodsSub = new Long[]{2L,3L,4L,5L,6L,7L,8L,9L,10L};

        Long[] serviceSub = new Long[]{1L,15L,16L,17L,18L,80L,81L,82L,83L,84L,100L,101L,102L,103L,104L,105L,106L,107L,108L,109L,110L,111L,112L,113L,114L,115L,116L,117L,118L};

        Long[] thirdpartySub = new Long[]{11L,12L,13L,14L,19L};

        GoodsFinanceSubject sub = null;

        for (Long id : goodsSub){
            sub = new GoodsFinanceSubject();
            sub.setGoodsId(id);
            sub.setDebitCode("8200");
            sub.setDebitAdjustCode("8210");
            sub.setRemark("百宝箱-商品升级");
            list.add(sub);
        }

        for (Long id : serviceSub){
            sub = new GoodsFinanceSubject();
            sub.setGoodsId(id);
            sub.setDebitCode("6600");
            sub.setDebitAdjustCode("6610");
            sub.setRemark("百宝箱-服务升级");
            list.add(sub);
        }

        for (Long id : thirdpartySub){
            sub = new GoodsFinanceSubject();
            sub.setGoodsId(id);
            sub.setDebitCode("8300");
            sub.setDebitAdjustCode("8310");
            sub.setRemark("百宝箱-第三方服务");
            list.add(sub);
        }

        String s = JsonUtil.JSON_List2String(list);

        System.out.println(s);

    }

}
