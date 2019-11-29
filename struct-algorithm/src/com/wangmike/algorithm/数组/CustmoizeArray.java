package com.wangmike.algorithm.数组;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * 自定义数组
 * 
 * @author wangchun
 *
 */
@SuppressWarnings("unchecked")
public class CustmoizeArray<E> {

	private int size = 0;

	private E[] elements;
	// 数组默认大小
	private static final int DEFAULT_SIZE = 10;

	private static final int OUT_OF_INDEX = -1;

	public CustmoizeArray() {
		this(DEFAULT_SIZE);
	}

	
	public CustmoizeArray(int size) {
		size = size < DEFAULT_SIZE ? DEFAULT_SIZE : size;
		elements = (E[]) new Object[size];
	}

	/**
	 * 
	 * @return 数组长度
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return 判断数组是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 判断数组是否包含此元素
	 * 
	 * @param element 传入参数
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) >=0;
	}

	/**
	 * 新增元素
	 * 
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}

	/**
	 * 获取该位置下的元素
	 * 
	 * @param index 位置
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		return elements[index];
	}

	/**
	 * 为当前位置设置新的元素
	 * 
	 * @param index   位置
	 * @param element 新的元素
	 * @return 旧的元素
	 */
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 在指定位置，添加相应元素
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		enableCapasity();
		if (index == size) {
			elements[size++] = element;
		} else {
			for (int i = size - 1; i >= index; i--) {
				elements[i + 1] = elements[i];
			}
			elements[index] = element;
			size++;
		}
	}
	/**
	 * 确保数组容量以及相应的扩容
	 */
    private void enableCapasity() {
    	int oldCapasity = elements.length;
    	if(oldCapasity > size ) {
    		return;
    	}
    	//扩容1.5倍
    	int newCapsity = oldCapasity + (oldCapasity >> 1);
    	E[] newArray = (E[]) new Object[newCapsity];
    	for (int i = 0; i < oldCapasity; i++) {
    		newArray[i] = elements[i];
		}
    	elements = newArray;
    	System.out.println(oldCapasity +"扩容为："+newCapsity);
    }
	/**
	 * 删除指定位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
		}
		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		return old;
	}

	/**
	 * 判断当前数组是否拥有当前元素
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if(element == null) {
			for (int i = 0; i < elements.length; i++) {
				if(element == elements[i]) {
					return i ;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}		
		return OUT_OF_INDEX;
	}

	/**
	 * 清空数组
	 */
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append(elements[i]);
		}
		sb.append("]");
		return sb.toString();
	}

}
