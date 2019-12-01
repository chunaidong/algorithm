package com.wangmike.algorithm.数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

	public static void main(String[] args) {
	
//		CustmoizeArray<Integer> custmoizeArray = new CustmoizeArray<>();
//		custmoizeArray.add(1);
//		custmoizeArray.add(2);
//		custmoizeArray.add(3);
//		custmoizeArray.add(4);
//		custmoizeArray.add(5);
//		custmoizeArray.add(null);
//		custmoizeArray.add(4, 8);
//		custmoizeArray.add(0, 9);
//		System.out.println(custmoizeArray);
		
//		System.out.println( 24>>3);
		
		String msgString = "AA";
		System.out.println(calucate(msgString));
		
		
	}
	
	public static int calucate(String msg) {
		if(msg.length() == 1) {
			return "A".equals(msg)?1:0;
		}		
		return calucate(msg.substring(0, 1)) + calucate(msg.substring(1));
	}

}
