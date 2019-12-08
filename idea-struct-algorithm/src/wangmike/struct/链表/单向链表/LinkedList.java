package wangmike.struct.链表.单向链表;

import wangmike.struct.链表.AbstractList;

/**
 * 单向链表
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    /**
     * 获取index位置的元素
     *
     * @param index 索引
     * @return 数据
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     *
     * @param index   索引位置
     * @param element 新的数据
     * @return 当前位置的旧数据
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement =node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 向某个位置添加元素
     *
     * @param index   位置索引
     * @param element 数据
     */
    @Override
    public void add(int index, E element) {
        if(index == 0){
            first = new Node<>(element, first);
        }else{
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size ++;
    }

    /**
     * 删除某个位置的数据
     *
     * @param index 位置
     * @return 删除的数据
     */
    @Override
    public E remove(int index) {
        Node<E> node = first;
        if(index == 0){
            first = first.next;
        }else{
            Node<E> prev = node(index -1);
            node = prev.next;
            prev.next = node.next;
        }
        size --;
        return node.element;
    }

    /**
     * 根据索引获取node
     * @param index
     * @return
     */
    private Node<E> node(int index){
        checkIndexIsIllegal(index);
        Node<E> node = first;
        for(int i = 0; i < index;i++){
            node = node.next;
        }
        return node;
    }

    /**
     * 返回当前元素所在数组的位置
     *
     * @param element 元素
     * @return 位置
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if(element == null){
            for(int i = 0 ; i < size; i++){
                if(node.element == element){
                    return i;
                }
                node = node.next;
            }
        }else{
            for(int i = 0 ; i < size; i++){
                if(element.equals(node.element)){
                    return i;
                }
                node = node.next;
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 删除所有元素
     */
    @Override
    public void clear() {
        if(size == 0) return;
        first = null;
        size = 0;
    }


    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element,Node<E>next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node<E> cur = first;
        while(cur != null){
            res.append(cur.element).append("->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
