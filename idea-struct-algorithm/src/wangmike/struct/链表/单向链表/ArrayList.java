package wangmike.struct.链表.单向链表;

import wangmike.struct.链表.AbstractList;

/**
 * 动态数组也是 ArrayList
 * 动态数组 查询是O(1)级别，index级别为内存地址，查询时，拿到数组0的地址+index*(8||4)
 *         修改也是O(1)级别，直接elements[index] = element
 *         新增/删除都是O(n)级别，也存在内存空间浪费问题
 */
public class ArrayList<E> extends AbstractList<E> {

    private E elements[];
    private static final int DEFAULT_CAPACITY = 10;
    public ArrayList(){
        this(0);
    }

    public ArrayList(int size){
        int capacity = Math.max(DEFAULT_CAPACITY, size);
        elements = (E[]) new Object[capacity];
    }

    /**
     * 获取index位置的元素
     * @param index 索引
     * @return 数据
     */
    public E get(int index){
        checkIndexIsIllegal(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index 索引位置
     * @param element 新的数据
     * @return 当前位置的旧数据
     */
    public E set(int index,E element){
        checkIndexIsIllegal(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 向某个位置添加元素
     * @param index 位置索引
     * @param element 数据
     */
    public void add(int index,E element){
        checkIndexIsIllegal(index);
        ensureCapacity(size + 1);
        for(int i = size; i > index ; i --){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size ++;
    }

    /**
     * 确保容量够用和扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity > capacity) return;
        //扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0 ; i< elements.length ;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("扩容OldCapacity:"+oldCapacity+"::: NewCapacity:" + newCapacity);
    }
    /**
     * 删除某个位置的数据
     * @param index 位置
     * @return 删除的数据
     */
    public E remove(int index){
        checkIndexIsIllegal(index);
        //将最后一个元素滞空，从index+1位置一直到size位置均往前移动
        trimSize();
        E element = elements[index];
        for(int i = index + 1; i < size; i++){
            elements[i - 1] = elements [i];
        }
        elements[--size] = null;
        return element;
    }

    /**
     * 缩容
     */
    private void trimSize(){
        int capacity = elements.length;
        int newCapacity = capacity >> 1;
        //当数组长度 大于 容量时，不需要缩容。数组长度小于默认容量时，也不需要缩容
        if(size > newCapacity || size <= DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0 ; i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 返回当前元素所在数组的位置
     * @param element 元素
     * @return 位置
     */
    public int indexOf(E element){
        if(element == null){
            for(int i = 0 ; i < size; i++){
                if(elements[i] == element){
                    return i;
                }
            }
        }else{
            for(int i = 0 ; i < size; i++){
                if(element.equals(elements[i])){
                    return i;
                }
            }
        }

        return INDEX_NOT_FOUNT;
    }

    /**
     * 删除所有元素
     */
    public void clear(){

        for(int i = 0 ; i < size;i++){
            elements[i] = null;
        }
        if(size <= (elements.length >>1) && elements.length > DEFAULT_CAPACITY ){
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
        size = 0;
    }



}
