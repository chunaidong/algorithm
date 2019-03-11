package com.chunaidong.algorithm.firstday.insertion;

public class BasicInsertSort {


    /**
     * 插入算法
     * @param arrays
     */
    public static void insertSort(int[] arrays){
        for(int i = 1 ; i < arrays.length ; i++){
            for (int j = i ; j > 0 ; j--){
                if(arrays[j] < arrays[j-1]){
                    int tmp = arrays[j];
                    arrays[j] = arrays[j-1];
                    arrays[j-1] = tmp;
                }else {
                    break;
                }
            }
        }
    }



}
