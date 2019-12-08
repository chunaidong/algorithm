package wangmike.struct.动态数组;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Object> persons  = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(null);
		persons.add(new Person(15, "Rose"));
		persons.add(null);
		persons.add(new Person(12, "James"));
		persons.add(null);

		System.out.println(persons.indexOf(null));

    }

    public static void test2(){
        DynamicArray<Object> list  = new DynamicArray<>();
        list.add(10);
        list.add(new Person(10, "Jack"));
        list.add(22);

        System.out.println(list.indexOf(new Person(10, "Jack")));
    }

    public static void test1(){
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(4);
        dynamicArray.add(8);
        dynamicArray.add(9);
        dynamicArray.add(99);
        dynamicArray.add(4);
        dynamicArray.add(8);
        dynamicArray.add(9);
        dynamicArray.add(99);
        dynamicArray.remove(1);
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.isEmpty());
        dynamicArray.set(0, 10);
        System.out.println(dynamicArray.indexOf(9));
        System.out.println(dynamicArray.indexOf(8));
        dynamicArray.add(4, 888);
        System.out.println("hello");
        dynamicArray.add(4);
        dynamicArray.add(8);
        dynamicArray.add(9);
        dynamicArray.add(99);
    }

}
