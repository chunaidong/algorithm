package wangmike.struct.链表.双向链表;

import wangmike.struct.链表.AbstractList;

/**
 * 单向链表 dumyHead
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

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
        checkIndexIsIllegal(index);
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
        //双向链表的增加分为最后位置和非最后位置
        if(index == size){
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            //如果链表是个新的，oldLast则是空。此时整个双向链表中则只有一个元素。因此first和last都得同时指向该节点
            if(oldLast == null){
                first = last;
            }else{
                oldLast.next = last;
            }
        }else{
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            //如果是向0这个位置添加元素，则prev 节点是空的
            if(prev == null){
                //如果进入此处，则说明该节点是第一个节点，因此要将first指向当前节点
                first = node;
            }else{
                prev.next = node;
            }
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
        //删除节点时，需要注意零节点的位置
        checkIndexIsIllegal(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        //如果删除的当前节点是开始节点，则prev为空
        if(prev == null){
            //如果删除的是开始节点，开始节点下一个的节点就会变为开始节点，则需要将原先的first节点指向next节点
            first = next;
        }else{
            prev.next = next;
        }
        //如果删除的节点为最后一个节点，则next为空
        if(next == null){
            //删除最后节点之后，原先节点的前一个位置的节点，就会变成最后的节点
            last = prev;
        }else{
            next.prev = prev;
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
        //当为双向链表时，可以根据对半查找，节约时间
        int position = (size >> 1) - index;
        Node<E> node = null;
        if(position > 0){
            //从first开始找
            node = first;
            for(int i = 0; i < index;i++){
                node = node.next;
            }
        }else{
            //从last开始找
            node = last;
            for(int i = size - 1 ; i > index ; i--){
                node = node.prev;
            }
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
        last = null;
        size = 0;
    }


    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev,E element,Node<E> next){
            this.prev = prev;
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
