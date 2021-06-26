package baekjoon.binarySearch.q2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 지승구
 *
 */
/*
 *  느낀점
 *  1. 문제가 신박하다.
 *  2. 경우의수가 여러개다.
 */ 
public class Main {
	static int[] company;
	static int budget;
	static int gap=0;
	public static void Binary_Search() {
		int first=1;
		int last= budget;
		int middle =(int)(last+first)/2;
		
		while(first<=last)
		{
			System.out.println("first :"+first);
			System.out.println("last  :"+last);
			
			middle =(int)(last+first)/2;
			if(curculate(middle)>budget)
			{
				last = middle-1;
			}
			else 
			{
				gap=middle;
				System.out.println("gap ="+gap);
				first = middle+1;
			}
		}	
		System.out.println("금액 "+gap);
	}		
	
	public static int curculate(int money) {
		int total=0;
		for(int i=0;i<company.length;i++)
		{
			if(money > company[i])
			{
				total+=company[i];
			}
			else 
				total+=money;
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
    
		Scanner scan = new Scanner(System.in);
		
		int amount = scan.nextInt();
		company = new int[amount];
		
		for(int i=0;i<=company.length-1;i++)
		{
			company[i] = scan.nextInt();
		}
		budget = scan.nextInt();
		
		Arrays.sort(company);
		Binary_Search();

	}	
}		
	