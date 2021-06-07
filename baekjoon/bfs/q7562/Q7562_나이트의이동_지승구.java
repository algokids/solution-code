package baekjoon.bfs.q7562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 알고리즘 7562번 
// 문제 링크 : https://www.acmicpc.net/problem/7562
// 문제 유형 : BFS

public class Q7562_나이트의이동_지승구 {
	public static int map[][];
	public static boolean visit[][];
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//방향을 잡아 주기 위한 direct  위에서 부터 시계방향
	public static int direct[][] = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
	public static int size=0;
	public static int temp=0;
	//Queue에 들어갈 클래스 생성
	static class Box{
		int x,y,count;
		Box(int x,int y,int count){
			this.x = x;
			this.y = y;
			this.count=count;
		}
	}
	public static Queue<Box> q = new LinkedList<>();		
	public static void BFS() throws InterruptedException
	{			
		int num=0;
		while(!q.isEmpty())
		{
			Box b = q.poll();
			visit[b.x][b.y]= true;
			for(int i=0;i<8;i++)
			{		
				int move_x = b.x+direct[i][0];
				int move_y = b.y+direct[i][1];
				// 범위를 벗어 나지 않는 조건문 ( map 배열을 초과하지않는지 -값이 나오지 않는지 검사)
				if(move_x >= 0 && move_x <map.length && move_y >= 0 && move_y <map[0].length)
				{	
					// 0이면 체스말이 움직일 수 있는 경로 false이면 이미 갔던 곳이니까 안가도됨 시간절약 의미?
					if(map[move_x][move_y]==0 && visit[move_x][move_y]==false)
					{
						//각 가지고 있는 움직임의 횟수를  움직이고 난 후 자리의 값을 증가 시키기 위해서
						// temp 에 담아서 값을 증가 시켜준다
						// b.count를 증가시키면 움직이기전의 이동값도 변하기 때문에
						temp= b.count;
						q.offer(new Box(move_x,move_y,++temp));
						System.out.println("b.count :"+b.count);
						map[b.x][b.y]=0;
						map[move_x][move_y]=1;
					}
					if(map[move_x][move_y]==2) {
						map[move_x][move_y]=3;
						//마지막으로 목적지를 찾았을때도  움직였으니 이동값을 ++시켜준다.
						System.out.println("횟수 :"+(++b.count));
						q.clear();
						break;
					}
				}
			}
			System.out.println("==========================");
	    	for(int l=0;l<size;l++) {
	    		for(int j=0;j<size;j++) {
	    			System.out.print(map[l][j]+"      ");
	    		}
	    		System.out.println();
	    	}
	    	Thread.sleep(100);
//			break;
		}	
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int test_case = Integer.parseInt(br.readLine());
	    
	    while(test_case!=0) {
	    	size = Integer.parseInt(br.readLine());
	    	map = new int[size][size];
	    	visit= new boolean[size][size];
	    	for(int i=0;i<size;i++) {
	    		for(int j=0;j<size;j++) {
	    			map[i][j]=0;
	    			visit[i][j]=false;
	    		}
	    	}
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken());
	    	int y = Integer.parseInt(st.nextToken());
	    	map[x][y]=1;
	    	q.offer(new Box(x,y,0));
	    	st = new StringTokenizer(br.readLine());
	    	map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=2;
	    	
	    	BFS();
	    	test_case--;
	    }
	}
}
