package com.test.algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class MnArray {

	public static void main(String[] args) {
		String a[] = { "1", "3", "5", "5", "7", "8", "5", "4", "3", "a" }, 
				b[] = {
				"1", "2", "3", "4", "8", "66", "6", "5", "5", "10", "a" };
		
		HashSet<String> sa = new HashSet<String>(Arrays.asList(a));
		
		sa.retainAll(Arrays.asList(b));
		System.out.println(sa);
	}

}
