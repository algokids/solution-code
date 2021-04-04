package Baekjoon;

import java.util.*;
public class Q13163_changeToGod {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt(); // 닉네임 개수

		String[] name = new String[num];

		scan.nextLine(); //공백을 입력으로 인식하지 않기 위해 사용, next() => 공백을 입력으로 인식

		for(int i=0; i<num; i++){
			name[i] = scan.nextLine();    //닉네임 입력
		}

		String temp = "";    //첫음절을 저장할 변수

		for(int i=0; i<num; i++){    //닉네임 하나씩 읽으면서
			for(int j=0; j<name[i].length(); j++){
				if(name[i].charAt(j) == ' '){     //닉네임에 공백이 나오면
					int x = j;
					j = 0;
					for(int l=j; l<x; l++){
						temp += name[i].charAt(l);    //공백 전 문자들을 저장
					}

					name[i] = name[i].replace(temp,"god");    //공백전 문자들을 god으로 바꿈
					name[i] = name[i].replaceAll(" ", "");    //나머지 공백 없애기

					temp = "";    //다음 닉네임을 위해 temp 초기화

					break;
				}
			}
		}

		//출력
		for(int i=0; i<num; i++){
			System.out.println(name[i]);
		}

	}

}

