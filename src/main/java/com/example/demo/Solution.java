package com.example.demo;

public class Solution {


	public static void main(String[] args) {

		int a=5,b=2;
		System.out.println(a/b+":"+a%b);
		
	}
	
	public  void  test1() {
		
		synchronized(this) {
			int a=10;
			
		}
	}

}
