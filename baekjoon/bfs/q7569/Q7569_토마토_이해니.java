package baekjoon.bfs.q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569

class PointXYX{
	int height;
	int row;
	int col;
	
	public PointXYX(int height, int row, int col) {
		super();
		this.height = height;
		this.row = row;
		this.col = col;
	}
}

public class Q7569_토마토_이해니 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int rowArr[] = {-1, 0, 1, 0, 0 , 0};
	static int colArr[] = {0, 1, 0, -1, 0 , 0};
	static int heightArr[] = {0, 0, 0, 0, 1 , -1};
	static int m;
	static int n;
	static int h;
	static int[][][] arr;
	static Queue<PointXYX> queue = new LinkedList<PointXYX>();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new int[h][n][m];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k < m; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					
					// 익은토마토 = 즉, bfs를 시작하는 노드를 큐에 추가
					if(arr[i][j][k] == 1) queue.add(new PointXYX(i, j, k));
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		
		// 다 익을때까지 돌면서 토마토 익히기
		while(!queue.isEmpty()) {
			PointXYX point = queue.poll();
			int height = point.height;
			int row = point.row;
			int col = point.col;
			
			for(int i = 0; i < 6; i++) {
				int moveHeight = height + heightArr[i];
				int moveRow = row + rowArr[i];
                int moveCol = col + colArr[i];
                
                // 6방향 유효한지 체크
                if(checkPoint(moveHeight, moveRow, moveCol)) {
                	// 익은 토마토 좌표를 큐에 추가
                	queue.add(new PointXYX(moveHeight, moveRow, moveCol));
                	// 익은 토마토 값을 +1 로 변경
                	arr[moveHeight][moveRow][moveCol] = arr[height][row][col] + 1;
                }
			}
		}
		
		// 최대값 구하기
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                	// 하나라도 안 익은 토마토 있으면 -1반환
                	if(arr[i][j][k] == 0) return -1;
                	
                	// 토마토가 익는데 걸리는 시간
                	result = Math.max(result, arr[i][j][k]);
                	
                }
			}
		}
		
		// 최대값이 1이라면 원래부터 모두 익어있었음
		if(result == 1) return 0;
		else return (result -1);
		
	}
	
	// 유효 범위 검사
	private static boolean checkPoint(int height, int row, int col) {
		// 범위 밖인지 확인
		if(height < 0 || height >= h || row < 0 || row >= n || col < 0 || col >= m) return false;
		
		// 아직 안 익은 토마토라면 true
		if(arr[height][row][col] == 0) return true;
		
		// 이미 익은 토마토거나 빈자리면 false
		else return false;
	}
	
}
