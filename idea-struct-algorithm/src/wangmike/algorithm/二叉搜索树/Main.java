package wangmike.algorithm.二叉搜索树;

import wangmike.algorithm.二叉搜索树.printer.BinaryTreeInfo;
import wangmike.algorithm.二叉搜索树.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        int[] arr = new int[]{7,4,9,2,5,8};
        for (int value : arr) {
            binarySearchTree.add(value);
        }
        List<Integer> list  = new ArrayList<>();
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.levelTravelSal(value -> {
            list.add(value);
        });
        System.out.println(list);
    }

}
