/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DoorLockUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;

import org.apache.commons.lang.StringUtils;


public class DoorLockUtil {
   
	// public static int seed=0; //全局变量
      
	  public static int jiesuan(String suiju){
		int j=0;
		for (int i=0;i<suiju.length();i++){
		   j=j+Integer.parseInt(suiju.substring(i,1+i));
		}		
		return j;
	  }
	  
	  private static int nextSeed(int seed){
		  return  seed*7+12345;
	  }
      //public static int Random6(int seed ){
	//	int j=0;
		//seed=seed*7+12345;  //每次都会增加seed的值，因为是全局变量
	//	j=seed%6;
		//j=Math.abs(seed%6);
		//j = RandomUtils.nextInt()%6;
	//	return j;
	// }
     
      public static String randExc(String suiju,String miyao ){
		String[] myArray=new String[6]; 
        int rand=0;
        int j=0;
        String Temp="";
        String mima="";
		for (int i=0;i<=5;i++){
			myArray[i]=suiju.substring(i,i+1);	
		}
		int seed = jiesuan(suiju);
		for (int i=0;i<=5;i++){
			seed = nextSeed(seed );   //每次都会变成不同的数字，也会改变seed的值
			rand= seed % 6;
			Temp=myArray[i];
			myArray[i]=myArray[rand];   //根据数字错位把随机号错位
			myArray[rand]=Temp;
		}
	    for (int i=0;i<=5;i++){
			j=Integer.parseInt(myArray[i])+Integer.parseInt(miyao.substring(i,i+1));//错位后的随机号与密钥的位数相加后的余数为密码
			if (j>=10){
				j=j%10;
			}
			mima=mima+String.valueOf(j);
		}
		return mima;
	}	

     /**
      * 创建密码 
      * @param doorNo
      * @param seqNo
      * @param passwordCode
      * @return
      */
    public static String createPwd(String doorNo,String seqNo,String miyao,int timeNo){
    	
    	String suiju=doorNo + seqNo;
    	
    	String purePwd=randExc(suiju,miyao);
    	
    	String pwdWithTime=purePwd+""+ StringUtils.leftPad(( jiesuan(purePwd)+timeNo)+"", 2, "0"); 
    	
    	return pwdWithTime;
    }
     

  
	public static void main(String[] args){
		
		//String initLockNo="0112 3661 8697";
		
		//97870941
		//93840833
	 
	/*	
		设置的是333333 012345 678900?
				主密码1天为:00842125   70296236
				副密码5分钟为:00831325 02802426
*/
		
		//主82200316   70296227
		 //副00831316   02802518
				
		
		/*设置的是333333 012345 678900?
				主密码1天为:00842116   70296227
				副密码5分钟为:00831316 02802417
				以这个为准*/

				
	 	String doorNo="68";
		String seqNo="0766";
		String miyao="661400";
	 
		
	/*	String doorNo="66";
		String seqNo="1402";
		String miyao="680765";*/
		
		//49 2751 493936
		
	/*	String doorNo="13";
		String seqNo="2815";
		String miyao="133282";*/
		
		int locktimelen=1;
		
		String mima =createPwd(doorNo,seqNo,miyao,locktimelen);
		System.out.println("mima:"+mima);
		
		//主密钥：012345 678900
		//00842116(序号2345) 70296227
		
		
		//String suiju="011236";
		//int locktimelen=1;//取值范围0~43,根据时间单位参考取值方法 锁范围
		//int  seed= jiesuan(suiju);
		
		//String miyao="618697";
		//String mima=randExc(suiju,miyao);
		// seed= jiesuan(suiju);
		//System.out.println("mima:"+mima);
		
		//String mimatime=mima+""+(jiesuan(mima)+locktimelen);
		//System.out.println("mimatime:"+mimatime);
	
		
	/*	suiju为:011234,miyao为:618697,生成的6位密码为:751799
		suiju为:011235,miyao为:618697,生成的6位密码为:138908
		suiju为:011236,miyao为:618697,生成的6位密码为:978709
		suiju为:011237,miyao为:618697,生成的6位密码为:321609*/

	}

	
	/*设置12位密钥:333333+6位(锁号+流水号)+6位(密钥),设置成功后,
	12位主密钥即为:6位(锁号+流水号)+6位(密钥)
	12位副密钥即为:6位(密钥)+6位(锁号+流水号)
	如设置为:333333 012345 678900
	则主密钥为:012345 678900
	副密钥为:678900 012345
	设置成功后,主副密码为双系统,后续工作中各自按各自的流水号加1
	时间控制为密码的后2位,即为前6位密码和+时间控制码,门锁仅在首次使用时才会保存时间控制码,非首次使用时间控制码任意数均可
	主密码时间控制码分配:
	  1~31为1~31天,(32~43)-31为1~12月
	副密码时间控制码分配:
	  0为临时一次性使用,开一次即失效
	  (1~42)*5分钟为副密码的时间,即定范围为:(1*5~42*5)
	  43为永久密码,即不限时间,除非下一密码使用,否则一直有效*/
	  
	//副密码时间
	public static Integer getSlaveTimeNo(String type, Integer minutes) {
		int timeNo=0;
		if("0".equals(type)){
			timeNo=0;
		}else if("43".equals(type)){
			timeNo=43;
		}else{
		 timeNo=  (int)minutes/5;
		}
		
		return timeNo;
	}
	//主密码时间
	public static Integer getMasterTimeNo(Integer[] dateRange) {
		
		int year = dateRange[0];
		int month = dateRange[1];
		int days = dateRange[2];
		int timeNo=0;
		if(month==0){
			timeNo = days+1;
		}else{
			timeNo = 31 + month+1;
			
		}
		return timeNo;
	}

}
