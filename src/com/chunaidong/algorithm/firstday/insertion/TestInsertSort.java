package com.chunaidong.algorithm.firstday.insertion;

import com.chunaidong.algorithm.firstday.selection.SelectionBasicSort;
import com.chunaidong.algorithm.util.ArrayBuilderFactory;

import java.util.Arrays;
import java.util.Collections;

/**
 * 插入算法
 */
public class TestInsertSort {
    public static void main(String[] args) {
      /*  int[] arrays = ArrayBuilderFactory.buildIntArray(30, 0, 30);
        BasicInsertSort.insertSort(arrays);
        assert ArrayBuilderFactory.isSorted(arrays);
        ArrayBuilderFactory.printlnArray(arrays);*/
      // test insertSort time
        int[] arrayA = ArrayBuilderFactory.buildIntArray(100000, 0, 10000);
        int[] arrayB = Arrays.copyOf(arrayA, arrayA.length);
        long sortStartTime = System.currentTimeMillis();
        BasicInsertSort.insertSort(arrayA);
        long sortEndTime = System.currentTimeMillis();
        long selectStartTime = System.currentTimeMillis();
        SelectionBasicSort.selectionSortArrays(arrayB);
        long selectEndTime = System.currentTimeMillis();
        System.out.println("sort hosttime is " + (sortEndTime - sortStartTime));
        System.out.println("select hosttime is " + (selectEndTime - selectStartTime));

    }
}
