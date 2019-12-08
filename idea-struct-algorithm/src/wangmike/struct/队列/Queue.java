package wangmike.struct.队列;

import wangmike.struct.链表.双向链表.LinkedList;

/**
 * 队列是一种特殊的线性表，只能在头尾两端进行操作
 * 队尾，只能从队尾添加元素，一般叫enQueue,入队
 * 队头，只能从对头移除元素，一般叫deQueue,出队
 */
public class Queue<E>{
    private LinkedList<E> linkedList = new LinkedList<>();
    public int size(){
        return linkedList.size();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void clear(){
        linkedList.clear();
    }

    public void enQueue(E element){
        linkedList.add(element);
    }

    public E deQueue(){
        return linkedList.remove(0);
    }

    public E front(){
        return linkedList.get(0);
    }


}
