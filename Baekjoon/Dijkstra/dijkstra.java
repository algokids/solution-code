import java.util.Scanner;

public class dijkstra {
	static int number = 5;
	final static int INF = 1000000000;
	
	static int[][] a = {
			{0, INF, 6, 3, INF},
			{3, 0, INF, INF, INF},
			{INF, INF, 0, 1, INF},
			{INF, 7, 2, 0, 2},
			{INF, 4, INF, INF, 0}			
		};
	static boolean v[] =new boolean[5]; //방문한 노드
	static int d[] = new int[5]; //거리
	
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
			
			for(int j = 0; j < 5; j++)
			if(!v[j]) {
				if(d[current] + a[current][j] < d[j] ) {
					d[j] = d[current] + a[current][j];
				}
			}
		}
	}
	public static void main(String[] args) {
		dijkstra(0);
		 for(int i=0; i<number;i++) {
			 System.out.print(d[i]+" ");
		 }
		
	}
}
