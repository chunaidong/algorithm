package wangmike.struct.链表;


import wangmike.struct.链表.单向链表.LinkedList;

public class Main {


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        list.remove(1);
        System.out.println(list);
        reverseList(list);
        System.out.println(list);
    }

    public static void reverseList(List<Integer> list){

    }

}
