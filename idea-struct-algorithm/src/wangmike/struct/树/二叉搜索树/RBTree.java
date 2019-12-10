package wangmike.struct.树.二叉搜索树;

import java.util.Comparator;

/**
 * 红黑树
 */
public class RBTree<E> extends BinarySearchTree<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree(Comparator<E> comparator){
        super(comparator);
    }
    public RBTree(){
        this(null);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        //平衡红黑树
        Node<E> parent = node.parent;
        //如果父节点为空，则说明此节点为根节点
        if(parent == null){
            black(node);
            return;
        }
        //如果父节点是黑节点 则不会失衡
        if(isBlack(parent)){
            return;
        }
        Node<E> grand = parent.parent;
        Node<E> uncle = parent.sibling();
        //区分叔父节点是否为红色
        if(colorOf(uncle) == RED){
            //将node节点和祖父节点染成黑色，将父节点染红，然后重复此步骤
            black(parent);
            black(uncle);
            afterAdd(red(grand));
        }else{
            if(parent.isLeftChild()){//L
                if(node.isLeftChild()){
                    //LL
                    black(parent);
                    red(grand);
                    //grand右旋
                    rotateRight(grand);
                }else{
                    //LR
                    black(node);
                    red(grand);
                    //左旋parend
                    rotateLeft(parent);
                    //右旋grand
                    rotateRight(grand);
                }
            }else{
                if(node.isLeftChild()){
                    //RL
                    black(node);
                    red(grand);
                    //右旋父节点
                    rotateRight(parent);
                    //左旋祖父节点
                    rotateLeft(grand);
                }else{
                    //RR
                    black(parent);
                    red(grand);
                    //左旋grand
                    rotateLeft(grand);
                }
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

    }


    private Node<E> color(Node<E> node, boolean color){
        if(node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node, RED);
    }

    private Node<E> black(Node<E> node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    private static class RBNode<E> extends Node<E>{
        boolean color = RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }

}
