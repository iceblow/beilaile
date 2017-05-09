package com.warehouse;

public class Test {
	
	public  String autoGenericCode(double input, int num1, int num2) {
		String[] ary = String.valueOf(input).split("\\.");//[342,21]
		String result1 = String.format("%0" + num1 + "d", Integer.parseInt(ary[0]));
		String result2 = String.format("%0" + num2 + "d", Integer.parseInt(ary[1]));
		return result1 + result2;
	}

	
	public static void main(String[] args) {
		Test test= new Test();
		System.out.println(test.autoGenericCode(342.2100, 2, 6));
	}

}
