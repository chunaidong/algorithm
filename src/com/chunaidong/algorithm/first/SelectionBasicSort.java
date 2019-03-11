package com.chunaidong.algorithm.first;


import com.chunaidong.algorithm.util.ArrayBuilderFactory;

/**
 * 基础排序算法
 */
public class SelectionBasicSort {


    public static void main(String[] args) {

        int arrays[] = ArrayBuilderFactory.buildIntArray(10, 0, 11);
        selectionSortArrays(arrays);
        for(int i = 0 ; i < arrays.length ; i++){
            System.out.print(arrays[i]);
        }



    }

    /**
     * 选择排序方法
     *    从数组找出最小元素，移动到首位，依次循环数组
     * @param arrays
     */
    private static  void selectionSortArrays(int arrays[]) {

        int minIndex = 0;
        for(int i = 0; i <arrays.length ; i++ ){
            //假设数组第一位是最小值
            minIndex = i;
            for(int j = i+1 ; j < arrays.length;j++){
                if(arrays[j] < arrays[minIndex]){
                    int tmp = arrays[j];
                    arrays[j] = arrays[minIndex];
                    arrays[minIndex] = tmp;

                }
            }
        }

    }



}
