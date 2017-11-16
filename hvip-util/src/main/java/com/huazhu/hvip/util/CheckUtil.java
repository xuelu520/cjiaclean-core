package com.huazhu.hvip.util;

import java.util.Collection;

/**
 * @author cmy
 * @create 2017-08-07 17:02
 **/
public class CheckUtil  {
    public  static  boolean checkListIsNull(Collection list){
        if(list!=null&&list.size()>0){
            return  true;
        }else {
            return false;
        }
    }
}
