import java.util.Arrays;
import java.util.Scanner;

public class dijkstra1238 {
	static int number = 4;
	final static int INF = 1000000000;
	
	static int[][] a = {
			{0, 4, 2, 7},
			{1, 0, 5, INF},
			{1, INF, 0, 4},
			{INF, 3, INF, 0}
		};
	static boolean v[] =new boolean[4]; //방문한 노드
	static int d[] = new int[4]; //거리
	
	public static int getSmallIndex() {
		int min = INF;
		int index = 0;
		for(int i=0; i<number; i++) {
			if(d[i] <min && !v[i]) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		for(int i= 0; i< number ;i++) {	//  여기서 for문은  해당 노드에서  
			d[i] = a[start][i];			//	모든 노드로 가는 간선들의 합을 
		}								//  d[] 배열에 저장하기 위한 소스코드
		
		v[start] = true;	// 해당 노드는 방문이 되었으므로 true
		
		for(int i = 0; i < number-2 ; i++ ){
			int current = getSmallIndex();
			v[current] = true;
			
			for(int j = 0; j < 4; j++)
			if(!v[j]) {
				if(d[current] + a[current][j] < d[j] ) {
					d[j] = d[current] + a[current][j];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("파티를 시작하는 마을 번호를 입력해주세요 :");
		
		int party = scan.nextInt();
		int distance[] = new int[4];
		for(int i=0; i < number ; i++) {
			dijkstra(i);
			Arrays.fill(v,false);
			
			for(int j=0; j<number;j++) {
				System.out.print(d[j]+" ");
			}
			
			distance[i] += d[1];
			
			if( i == party-1) {
				distance[0]+=d[0];
				distance[1]+=d[1];
				distance[2]+=d[2];
				distance[3]+=d[3];
			}
			
			System.out.println();
		}
		System.out.println(Arrays.toString(distance));
	}
}
