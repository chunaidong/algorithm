package wangmike.algorithm.二叉搜索树;

import wangmike.algorithm.二叉搜索树.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @param <E>
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(){
        this(null);
    }
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    private void checkElement(E element){
        if(element == null)
            throw new IllegalArgumentException("element must not be null");
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){

    }

    public void add (E element){
        checkElement(element);
        //判断是否为第一个元素
        if(root == null){
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while (node != null){
            cmp = compare(element, node.element);
            parent = node;
            if(cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else{
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if(cmp > 0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        size++;

    }

    /**
     * 前序遍历
     */
    public void preorderTravelSal(){
        this.preorderTravelSal(root);
    }

    private void preorderTravelSal(Node<E> node){
        if(node == null) return;
        System.out.println(node.element);
        preorderTravelSal(node.left);
        preorderTravelSal(node.right);
    }

    /**
     * 中序
     */
    public void inorderTravelSal(){
        this.inorderTravelSal(root);
    }
    private void inorderTravelSal(Node<E> node){
        if(node == null) return;
        inorderTravelSal(node.left);
        System.out.println(node);
        inorderTravelSal(node.right);
    }

    /**
     * 中序
     */
    public void postorderTravelSal(){
        this.postorderTravelSal(root);
    }
    private void postorderTravelSal(Node<E> node){
        if(node == null) return;
        inorderTravelSal(node.left);
        inorderTravelSal(node.right);
        System.out.println(node);
    }

    /**
     * 层序遍历
     */
    public void levelTravelSal(){
        if(root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    /**
     * 层序遍历
     */
    public void levelTravelSal(Visitor<E> visitor){
        if(root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }


    private int compare(E e1,E e2){
        if(null != comparator){
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public void remove(E element){
        checkElement(element);
    }

    public boolean contains(E element){
        checkElement(element);
        return false;
    }

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return root;
    }
    public static interface  Visitor<E>{
        void visit(E element);
    }
    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    private static class Node<E>{
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        public Node(E element,Node<E> parent){
            this.element = element;
            this.parent = parent;
        }
    }

}
