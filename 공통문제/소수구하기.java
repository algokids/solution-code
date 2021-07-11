package 공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class Sosu {
    int x;
    int y;
    int z;
    int sum;
    public Sosu(int x,int y,int z,int sum){
        this.x=x;
        this.y=y;
        this.z=z;
        this.sum=sum;
    }
}
public class 소수구하기 {
	public static int[] nums;

	public static int solution(int[] nums) {
        int answer = 0;
		System.out.println("호출");
        // 합을 저장할 저장공간 선언
        ArrayList<Sosu> list = new ArrayList<>();
        // for문을 이용하여 배열의 합을 구한다.         
        for(int i = 0; i < nums.length; i++) {
        	if(i + 2 >= nums.length) break;
        	for(int j = i + 1; j < nums.length; j++) {
        		for(int h = j + 1; h < nums.length; h++) {
        			list.add(new Sosu(nums[i],nums[j],nums[h],(nums[i] + nums[j] + nums[h])));
         		}
        	}
        }
        int temp = 0;
        // 저장된 합이 소수인지 판별한다.
        for(Sosu i : list) {
        	int count = 2;
        	answer++;
        	while(count < i.sum) {
			// 저장된 값이 count로 나눴을 때 나머지가 0이라면 소수가 아니기 때문에 answer의 값을 더하지 않는다.
        		if(i.sum % count == 0) {
//        			System.out.println("x ="+i.x+", y="+i.y+", z ="+i.z+", sum ="+i.sum);
//        			System.out.println("index = "+temp);
//        			System.out.println(list.indexOf(i));
//        			list.remove(i);
        			answer--;
        			break;
        		}
        		System.out.println("x ="+i.x+", y="+i.y+", z ="+i.z+", sum ="+i.sum);
        		count++;
        		temp++;
        	}
        }
        System.out.println("list.size" + list.size());
        return answer;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i=0;
//		nums = new int[100];
		int temp[] = new int[100];
		while(st.hasMoreTokens()) {
			temp[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		nums = new int[i];
		System.arraycopy(temp, 0, nums, 0, i);
		System.out.println(Arrays.toString(nums));
		System.out.println(solution(nums));
		
 	}
}
