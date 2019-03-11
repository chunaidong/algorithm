package com.chunaidong.algorithm.util;

import java.util.Random;

/**
 * 数组生成工厂
 */
public class ArrayBuilderFactory {

    private static Random random = new Random();

    /**
     * 整型数组生成器
     * @param n 数组数量
     * @param rangeL 数值最小值
     * @param rangeR 数值最大值
     * @return 数组
     */
    public static int[] buildIntArray(int n,int rangeL,int rangeR){

        int arrays[] = new int[n];

        for(int i = 0; i <arrays.length;i++){
            arrays[i] = random.nextInt(rangeR-rangeL)+rangeL;
        }

        return arrays;
    }

    /**
     * 数组打印
     * @param arrays
     */
    public static void printlnArray(int arrays[]){
        for(int i = 0; i<arrays.length ; i++){
            System.out.println(arrays[i]);
        }
    }

    /**
     * 是否已经排序
     * @param arrays
     * @return
     */
    public static boolean isSorted(int[] arrays) {
        for(int i = 0 ; i<arrays.length - 1 ; i++){
            if(arrays[i] > arrays[i+1]){
                return false;
            }
        }
        return true;
    }


}
