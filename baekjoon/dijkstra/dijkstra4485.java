package baekjoon.dijkstra;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


class Point implements Comparable<Point> {
	int x;
	int y;
	int weightSum;
	Point(int x, int y,int weightSum) {
		this.x = x;
		this.y = y;
		this.weightSum = weightSum;
	}
	@Override
	public int compareTo(Point o) {
		if(this.weightSum < o.weightSum) {
			return -1;
		}
		else return 1;
	}
}
public class dijkstra4485 {
	
	public static int map[][];
	public static boolean visit[][];
	
	//방향을 잡아 주기 위한 direct
	public static int direct[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static int size;
	public static int day=0;
//	public static PriorityQueue<Point> queue = new PriorityQueue<Point>();
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 100_000_000;
	static List<Point>[] list;
	static int[][] dist; // 각 노드의 거리들
    static boolean[] check = new boolean[size];
	
	 private static int dijkstra(){
	       PriorityQueue<Point> queue = new PriorityQueue<Point>();
//	       System.out.println("dist[0][0] :"+dist[0][0]);
//	       System.out.println("map[0][0] :"+map[0][0]);
	       dist[0][0] = map[0][0];
	       queue.offer(new Point(0,0,map[0][0]));
	       
	       while(!queue.isEmpty()){
	    	   Point point = queue.poll();
	    	   int x = point.x;
	    	   int y = point.y;
	    	   System.out.println("x :"+ x+", y:"+y );
	    	   for(int i=0;i<4;i++) {
	    		   int move_x = x + direct[i][0];
	    		   int move_y = y + direct[i][1];
	    		   System.out.println("move_x :"+move_x+", move_y : "+move_y);
	    		   if(move_x>=0 && move_x< map.length && move_y>=0 && move_y< map[0].length)
					{
	    			   if(dist[move_x][move_y] > dist[x][y] + map[move_x][move_y]) {
	    				   System.out.println("dist[move_x][move_y] :"+dist[move_x][move_y]);
	    				   System.out.println("dist[x][y] :"+dist[x][y]);
	    				   System.out.println("map[move_x][move_y] :"+ map[move_x][move_y]);
	    				   dist[move_x][move_y] = dist[x][y] + map[move_x][move_y];
	    				   System.out.println("=====================================");
	    				   for(int k=0;k<size;k++) {
	    					   for(int n=0;n<size;n++) {
	    						   System.out.print(dist[k][n]+" ");
	    					   }
	    					   System.out.println();
	    				   }
	    				   System.out.println("=====================================");
	    				   queue.offer(new Point(move_x,move_y,dist[move_x][move_y]));	
	    				   System.out.println("사이즈 "+queue.size());
	    			   }
					}
	    	   }
	       }
	       System.out.println("size-1 :"+(size-1));
	       return dist[size-1][size-1];
	 }
	 
	public static void main(String[] args) throws IOException {
		StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
//		size = Integer.parseInt(st.nextToken());
		

		
		//입력이 0이 나올때까지 반복
		while(true) {
			size = Integer.parseInt(br.readLine());
			
			if(size==0)break;

			map = new int[size][size];
			visit = new boolean[size][size];
			dist = new int[size][size];
		
        for(int i = 0 ; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< size; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            	dist[i][j] = INF;
            }
        }

 
        // 다익스트라 알고리즘
        // 출력 부분
        sb.append("Problem :"+dijkstra()+" \n");
		}
		System.out.println(sb); // 출력
	}
	
}
