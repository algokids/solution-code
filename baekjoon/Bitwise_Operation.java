package baekjoon;

import java.util.Scanner;

public class Bitwise_Operation {

	private static String bit ="01";
	
	public static String reverse() {
		String temp ="";
		for(int i=0; i<=bit.length()-1  ; i++) {
			if(bit.charAt(i) == '0') temp +="1";
			if(bit.charAt(i) == '1') temp +="0";
		}
		
		bit += temp+" ";
		return bit;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		System.out.println("횟수 입력");
		int count= scan.nextInt();
		System.out.println("1: 01");
		
		int i=2;
		while(count>0) {
			
			System.out.println(i+": "+reverse());
			i++;
			count--;
		}
	}
}
