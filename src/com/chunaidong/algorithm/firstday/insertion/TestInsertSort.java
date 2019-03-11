package com.chunaidong.algorithm.firstday.insertion;

import com.chunaidong.algorithm.util.ArrayBuilderFactory;

/**
 * 插入算法
 */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] arrays = ArrayBuilderFactory.buildIntArray(30, 0, 30);
        BasicInsertSort.insertSort(arrays);
        assert ArrayBuilderFactory.isSorted(arrays);
        ArrayBuilderFactory.printlnArray(arrays);
    }
}
