package wangmike.struct.树.二叉搜索树;

import wangmike.struct.树.二叉搜索树.BinarySearchTree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {

    public AVLTree(){
        this(null);
    }
    public AVLTree(Comparator comparator){
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        //说明当前节点有父节点
        while ((node = node.parent) !=null){
            //判断是否平衡
            if(isBalance(node)){
                //更新高度
                updateHeight(node);
            }else{
                //恢复平衡
                reBalance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        //说明当前节点有父节点
        while ((node = node.parent) !=null){
            //判断是否平衡
            if(isBalance(node)){
                //更新高度
                updateHeight(node);
            }else{
                //恢复平衡
                reBalance(node);
            }
        }
    }

    private void reBalance(Node<E> grant){
        Node<E> parent = ((AVLNode<E>)grant).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if(parent.isLeftChild()){
            if(node.isLeftChild()){
                //LL
                rotateRight(grant);
            }else{
                //LR
                rotateLeft(parent);
                rotateRight(grant);
            }
        }else{
            if(node.isRightChild()){
                //RR
                rotateLeft(grant);
            }else{
                //RL
                rotateRight(parent);
                rotateLeft(grant);
            }
        }
    }
    //左旋
    private void rotateLeft(Node<E> grand){
        Node<E> parent = grand.right;
        Node<E> childNode = parent.right;

        grand.right = parent.left;
        parent.left = grand;
        rotateAfter(grand,parent,childNode);

    }
    //右旋
    private void rotateRight(Node<E> grand){
        Node<E> parent = grand.left;
        Node<E> childNode = parent.left;

        grand.left = parent.right;
        parent.right = grand;

        rotateAfter(grand,parent,childNode);
    }

    private void rotateAfter(Node<E> grand,Node<E> parent,Node<E> childNode){
        if(grand.parent == null){
            //表名grand为根节点
            root = parent;
        }else{
            parent.parent = grand.parent;
        }

        grand.parent = parent;

        if(childNode != null){
            childNode.parent = grand;
        }

        updateHeight(grand);
        updateHeight(parent);
    }



    private void updateHeight(Node<E> node){
        //父节点的高度 = 左右子树高度最大值 + 1 ;
        AVLNode<E> avlNode = (AVLNode<E>) node;
        avlNode.updateHeight();
    }
    /**
     * 判断是否为平衡树
     * @param node
     * @return
     */
    private boolean isBalance(Node<E> node){
        AVLNode<E> avlNode = ((AVLNode<E>) node);
        return Math.abs(avlNode.isBalance()) <= 1;
    }

    private static class AVLNode<E> extends Node<E>{
        int height = 1 ;
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int isBalance(){
            int leftHeight = ((AVLNode<E>)this.left).height;
            int rightHeight = ((AVLNode<E>)this.right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight(){
            int leftHeight = this.left ==null? 0 :((AVLNode<E>)this.left).height;
            int rightHeight = this.right == null ?0:((AVLNode<E>)this.right).height;
            this.height = 1 +  Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild(){
            int leftHeight = this.left ==null? 0 :((AVLNode<E>)this.left).height;
            int rightHeight = this.right == null ?0:((AVLNode<E>)this.right).height;
            if(leftHeight > 0 ) return  this.left;
            if(rightHeight > 0 ) return  this.right;
            return this.isLeftChild() ?this.left:this.right;
        }


    }

}
