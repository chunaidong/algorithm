package wangmike.algorithm.二叉搜索树;

import wangmike.algorithm.二叉搜索树.printer.BinaryTreeInfo;
import wangmike.algorithm.二叉搜索树.printer.BinaryTrees;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        int[] arr = new int[]{7,4,9,2,5,8,11,3,1,12};
        for (int value : arr) {
            binarySearchTree.add(value);
        }
        BinaryTrees.print(binarySearchTree);
    }

}
