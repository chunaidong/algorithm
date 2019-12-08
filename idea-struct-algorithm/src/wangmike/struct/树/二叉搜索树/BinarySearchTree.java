package wangmike.struct.树.二叉搜索树;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 * @param <E>
 */
public class BinarySearchTree<E> extends BinaryTree<E> {

    private Comparator<E> comparator;
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    public BinarySearchTree(){
        this(null);
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
        checkElement(element);
        //如果跟节点为空，则是第一个添加的元素
        if(root == null){
            root = new Node<E>(element, null);
            size ++;
            return;
        }
        //根节点不为空
        Node<E> node  = root;
        //新节点的父节点
        Node<E> parent = null;
        int cmp = 0;
        if(node != null){
            //比较两个元素的大小
            cmp = compare(element, node.element);
            parent = node;
            //如果比根节点小则往左找，
            if(cmp < 0){
                node = node.left;
            }else if(cmp > 0){
                //如果比根节点大则往右找
                node = node.right;
            }else{
                node.element = element;
                return;
            }
        }
        //创建新节点
        Node<E> newNode = new Node<E>(element,parent);
        //判断放父节点的左侧还是右侧
        if(cmp < 0 ){
            parent.left = newNode;
        }else if(cmp > 0){
            parent.right = newNode;
        }
        size ++;
    }



    /**
     * 判断是否为完全二叉树
     * @return
     */
    public boolean isComplete(){
        //根据完全二叉树的性质判断是否为完全二叉树，
        if(root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(isLeaf && !node.isLeaf()) return false;
            if(node.left != null){
                queue.offer(node.left);
            }else if(node.right != null){
                return false;
            }
            if(node.right != null){
                queue.offer(node.right);
            }else{
                isLeaf = true;
            }
        }
        return true;
    }



    private int compare(E e1,E e2){
        //如果传入比较器，则使用比较器，如果不传入，则将E转化为可以比较的数据
        if(null != this.comparator){
            return this.comparator.compare(e1, e2);
        }
        return ((Comparable)e1).compareTo(e2);
    }



    /**
     * 删除元素
     * @param
     */
    public void remove(Node<E> node){
        if(node == null) return;
        size --;
        //判断当前节点是否是度为2
        if(node.hasTwoChildren()){
            //找到前序或者后续节点
            Node<E> pre = successor(node);
            //数据覆盖
            node.element = pre.element;
            //后续删除前序节点
            node = pre;
        }
        //判断要删除的节点是度为1 还是度为2
        Node<E> replaceNode = node.left == null? node.left : node.right;
        if(replaceNode !=null){
            //度为1
            //更改parent
            replaceNode.parent = node.parent;
            //更改parent的left、right指向
            if(node.parent == null){
                //度为1的根节点
                root = replaceNode;
            }else if(node == node.parent.left){
                node.parent.left = replaceNode;
            }else{
                node.parent.right = replaceNode;
            }
        }else if(node.parent == null){
            //表示node是叶子节点 并且是根节点
            root = null;
        }else{
            //度为0
            //判断当前节点是在父节点的左还是右
            if(node == node.parent.left){
                node.parent.left = null;
            }else{
                node.parent.right = null;
            }
        }
    }

    /**
     * 是否包含此元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return node(element) != null;
    }

    private Node<E> node(E element){
        checkElement(element);
        Node<E> node = root;
        int cmp = 0;
        while (node !=null){
            cmp = compare(element, node.element);
            if(cmp == 0){
                return node;
            }else if(cmp < 0 ){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return node;
    }


    private void checkElement(E element){
        if(element == null)
            throw new IllegalArgumentException("element must not be null");
    }

}
