package com.wangmike.algorithm.数组;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
		CustmoizeArray<Integer> custmoizeArray = new CustmoizeArray<>();
		custmoizeArray.add(1);
		custmoizeArray.add(2);
		custmoizeArray.add(3);
		custmoizeArray.add(4);
		custmoizeArray.add(5);
		custmoizeArray.add(null);
		custmoizeArray.add(4, 8);
		custmoizeArray.add(0, 9);
		System.out.println(custmoizeArray);
		
	}

}
