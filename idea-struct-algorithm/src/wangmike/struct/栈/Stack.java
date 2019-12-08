package wangmike.struct.栈;

import wangmike.struct.链表.双向链表.LinkedList;

/**
 * 栈也是一种特殊的线性表，只能在一端进行操作，
 *  往栈中添加元素的操作，一般叫做push，入栈
 *  从栈中移除元素的操作，一般叫做pop,出栈，只能移除栈顶元素
 */
public class Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    public int size(){
        return linkedList.size();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    /**
     * 入栈
     * @param element
     */
    public void push(E element){
        linkedList.add(element);
    }

    /**
     * 移除栈顶元素
     * @return
     */
    public E pop(){
        return linkedList.remove(linkedList.size());
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public E top(){
        return linkedList.get(linkedList.size());
    }

    /**
     * 清空栈内元素
     */
    public void clear(){
        linkedList.clear();
    }
}
