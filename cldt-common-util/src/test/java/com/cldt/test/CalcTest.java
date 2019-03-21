package com.cldt.test;

import java.math.BigDecimal;
import java.util.Map;

import com.cldt.utils.loancalc.AverageCapitalPlusInterestUtils;
import com.cldt.utils.loancalc.AverageCapitalUtils;

public class CalcTest {

	/**
     * @param args
     */
    public static void main(String[] args) {
//    	double invest = 644000; // 本金
//    	int month = 360;
//    	double yearRate = 0.0588; // 年利率
//    	double yearRate = 0.0539; // 年利率
//    	double yearRate = 0.049; // 年利率
    	
    	double invest = 10000; // 本金
    	int month = 12;
    	double yearRate = 0.1; // 年利率
    	
    	
    	avgCapitalPlusInterest(invest, month, yearRate);
//    	avgCapital(invest, month, yearRate);
//    	System.out.println(16159-(4401.84 + 4800 + 3811.56));
//    	System.out.println((3531.54 + 2007.69));
    }
    
    public static void avgCapitalPlusInterest(double invest, int month, double yearRate){
    	 double perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
         System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
         Map<Integer, BigDecimal> mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(invest, yearRate, month);
         System.out.println("等额本息---每月还款利息：" + mapInterest);
         Map<Integer, BigDecimal> mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(invest, yearRate, month);
         System.out.println("等额本息---每月还款本金：" + mapPrincipal);
         double count = AverageCapitalPlusInterestUtils.getInterestCount(invest, yearRate, month);
         System.out.println("等额本息---总利息：" + count);
         double principalInterestCount = AverageCapitalPlusInterestUtils.getPrincipalInterestCount(invest, yearRate, month);
         System.out.println("等额本息---应还本息总和：" + principalInterestCount);
    }
    
    public static void avgCapital(double invest, int month, double yearRate){
    	Map<Integer, Double> getPerMonthPrincipalInterest = AverageCapitalUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
        System.out.println("等额本金---每月本息：" + getPerMonthPrincipalInterest);
        double benjin = AverageCapitalUtils.getPerMonthPrincipal(invest, month);
        System.out.println("等额本金---每月本金:" + benjin);
        Map<Integer, Double> mapInterest = AverageCapitalUtils.getPerMonthInterest(invest, yearRate, month);
        System.out.println("等额本金---每月利息:" + mapInterest);
 
        double count = AverageCapitalUtils.getInterestCount(invest, yearRate, month);
        System.out.println("等额本金---总利息：" + count);
    }

}
