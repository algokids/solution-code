package leetcode.stack.q682;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// 문제링크 : https://leetcode.com/problems/baseball-game/
/*
 *  참고 : 컬렉션 정리
 *  https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=jang_delay&logNo=220700885090
 */


public class Q682_BaseballGame {

	public static void main(String[] args) {
//		String[] ops = {"5","2","C","D","+"};  
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		
		int result = calPoints(ops);
		System.out.println(result);
	}
	
	public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> score = new Stack<Integer>();
        
        // 숫자 : 새로운 기록
        // + : 이전 두 개의 점수 합산
        // D : 직전 기록 두 배
        // C : 이전 기록 삭제해버림 (무조건 3개 존재)
        
        
        for(String s : ops) {
        	
        	switch(s) {
        	case "+":
        		int second = score.pop();
        		int first = score.pop();
        		int third = first + second;
        		
        		score.push(first);
        		score.push(second);
        		score.push(third);
        		
        		break;
        	case "D":
        		score.push(score.peek() * 2);
        		break;
        	case "C":
        		score.pop();
        		break;
        	default :
        		score.push(Integer.parseInt(s));
        		/*
        		 *  Integer.paserInt  vs Integer.valueOf
        		 *  
        		 *  parseInt() : 원시데이터인 int 타입을 반환
        		 *  valueOf(): Integer 래퍼(wrapper)객체를 반환
        		 *  
        		 */
        		break;
        	}
        	
        }
        
        while(!score.isEmpty()) {
        	result += score.pop();
        }
        
        return result;
    }

}
