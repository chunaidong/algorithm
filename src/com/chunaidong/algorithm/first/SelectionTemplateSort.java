package com.chunaidong.algorithm.first;


/**
 * 模板排序算法
 */
public class SelectionTemplateSort {


    public static void main(String[] args) {

        Integer arrays[] = new Integer[]{11,10,9,8,7,6,5,4,3,2,1};
        selectionSortArrays(arrays);
        for(int i = 0 ; i < arrays.length ; i++){
            System.out.print(arrays[i]+" ");
        }

        Float floats[] = new Float[]{4.4f,4.5f,6.7f,3.3f};
        selectionSortArrays(floats);
        for(int i = 0 ; i < floats.length ; i++){
            System.out.print(" "+floats[i]);
        }

        Student[] students = new Student[4];
        students[0] = new Student("C", 95);
        students[1] = new Student("B", 95);
        students[2] = new Student("D", 88);
        students[3] = new Student("A", 100);
        selectionSortArrays(students);
        for (int i = 0 ; i< students.length ; i++){
            System.out.println("【name】：" + students[i].getName() + "【score】:" + students[i].getScore());
        }



    }

    /**
     * 选择排序方法
     *    从数组找出最小元素，移动到首位，依次循环数组
     * @param arrays
     */
    private static  void selectionSortArrays(Comparable arrays[]) {

        int minIndex = 0;
        for(int i = 0; i <arrays.length ; i++ ){
            //假设数组第一位是最小值
            minIndex = i;
            for(int j = i+1 ; j < arrays.length;j++){
                if(arrays[j].compareTo(arrays[minIndex]) < 0){
                    //数据交换
                    swap(arrays,minIndex,j);
                }
            }
        }

    }

    /**
     * 交换数组中的数据
     * @param arrays
     * @param minIndex
     * @param j
     */
    private static void swap(Comparable[] arrays, int minIndex, int j) {
        //数据交换
        Comparable tmp = arrays[minIndex];
        arrays[minIndex] = arrays[j];
        arrays[j] = tmp;
    }

}
