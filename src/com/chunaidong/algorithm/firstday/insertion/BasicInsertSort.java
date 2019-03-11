package com.chunaidong.algorithm.firstday.insertion;

public class BasicInsertSort {


    /**
     * 插入算法
     * @param arrays
     */
    public static void insertSort(int[] arrays){
        // 3 5 6 1 2
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

    /**
     * 插入算法
     * @param arrays
     */
    public static void insertSort2(int[] arrays){
        // 3 5 6 1 2
        // i =3;
        for(int i = 1 ; i < arrays.length ; i++){
            int tmp = arrays[i];
            int j;
            for (j = i ; j > 0 ; j--){
                if(arrays[j-1] > tmp){
                   arrays[j] = arrays[j-1];
                }else {
                    break;
                }
            }
            arrays[j] = tmp;
        }
    }




}
