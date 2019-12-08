package wangmike.struct.链表;

public interface List<E> {

    /**
     *
     * @return 数组容量
     */
    public int size();

    /**
     *
     * @return 是否为空
     */
    public boolean isEmpty();

    /**
     *
     * @param element 传入数据
     * @return 当前数组中是否包含此数据
     */
    public boolean contains(E element);

    /**
     * 新增元素
     * @param element 添加元素
     */
    public void add(E element);

    /**
     * 获取index位置的元素
     * @param index 索引
     * @return 数据
     */
    public E get(int index);

    /**
     * 设置index位置的元素
     * @param index 索引位置
     * @param element 新的数据
     * @return 当前位置的旧数据
     */
    public E set(int index,E element);

    /**
     * 向某个位置添加元素
     * @param index 位置索引
     * @param element 数据
     */
    public void add(int index,E element);
    /**
     * 删除某个位置的数据
     * @param index 位置
     * @return 删除的数据
     */
    public E remove(int index);

    /**
     * 返回当前元素所在数组的位置
     * @param element 元素
     * @return 位置
     */
    public int indexOf(E element);

    /**
     * 删除所有元素
     */
    public void clear();


}
