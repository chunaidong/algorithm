package wangmike.struct.链表;

public abstract class AbstractList<E> implements List<E> {

    protected int size = 0;
    protected static final int INDEX_NOT_FOUNT = -1;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        this.add(size, element);
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != INDEX_NOT_FOUNT;
    }

    /**
     * 判断传入所引是否合法
     * @param index
     */
    protected void checkIndexIsIllegal(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Invalid index,Size:"+size+",Index:"+index);
        }
    }

}
