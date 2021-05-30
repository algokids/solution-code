package baekjoon.q3055;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 지승구
 *
 *  * 느낀점
 *  1. 바다가 미리 증가할 곳을 어떻게 알 수 있을까..
 *  2. 바다 먼저 증가 후에 -> 고슴도치 이동
 *  물이 고슴도치의 길을 막아도 Queue에는 이미 경로가 저장되어 있기 때문에 상관없다..
 */

public class main {
	public static Queue<position> ani;
	public static Queue<position> water;
	public static String map[][];
	
	//방향을 잡아 주기 위한 direct
	public static int direct[][] = {{1,0},{0,1},{-1,0},{0,-1}};
		
	static int h;
	static int w;
	
	//Queue에 들어갈 클래스 생성
	static class position{
		int x,y;
		position(int x,int y){
			this.x = x;
			this.y = y;
		}	
	}	
	public static void water_BFS() {
		int size= water.size();
		for(int l=0;l<size;l++)
		{
			position water_place =  water.poll(); 
			for(int i=0;i<4;i++)
			{		
				int water_move_x = water_place.x + direct[i][0];
				int water_move_y = water_place.y + direct[i][1];
				
				if(water_move_x >= 0 && water_move_x < map.length && water_move_y >=0 && water_move_y <map[0].length)
				{	
//					System.out.println("위치"+water_place.x+","+water_place.y);
//					System.out.println("i값"+i);
					if(map[water_move_x][water_move_y].equals(".") || map[water_move_x][water_move_y].equals("S") )
					{	
						map[water_move_x][water_move_y] ="*";
						
						
						for(int N=0;N<h;N++)
							{	
								for(int j=0;j<w;j++)
								{
									System.out.print(map[N][j]+" ");
								}
								System.out.println();
							}	
						water.add(new position(water_move_x, water_move_y));
					}
				}	
			}
		}	
	}		
	public static boolean BFS() {
		int size = ani.size();
		for(int l=0;l<size;l++)
		{
			position hedgehog = ani.poll();
			for(int i=0;i<4;i++)
			{		
				int move_x = hedgehog.x + direct[i][0];
				int move_y = hedgehog.y + direct[i][1];
						
				if(move_x >= 0 && move_x < map.length && move_y >=0 && move_y<map[0].length)
				{	
					if(map[move_x][move_y].equals("D"))
					{
						ani.add(new position(move_x, move_y));
						return true;
					}
					if(map[move_x][move_y].equals("."))
					{
						ani.add(new position(move_x,move_y));
						map[move_x][move_y] = "S";
					}
				}
			}
		}	 
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		main escape = new main();
		ani = new LinkedList<>();
		water = new LinkedList<>(); 
		System.out.println("가로 세로 크기 입력");
		h = scan.nextInt();
		w = scan.nextInt();
			
		map = new String[h][w];
			
		
		
		for(int i=0;i<h;i++)
		{	
			for(int j=0;j<w;j++)
			{
				map[i][j] = scan.next();
			}
			
		}	
		
		
		
		for(int i=0;i<h;i++)
		{	
			for(int j=0;j<w;j++)
			{
				if(map[i][j].equals("S"))
				{
					ani.add(new position(i,j));
				}
				if(map[i][j].equals("*"))
				{
					water.add(new position(i,j));
				}
			}
		}	

		
		
		
		int ans = 0;
		int b = 0;
	    while (true) {
	        ++ans;
	        if (ani.size() == 0) {
	            System.out.println("KAKTUS");
	            return;
	        }
	        
	        water_BFS();
	        if (BFS()) {
	            System.out.println(ans);
	            return;
	        }
	        
	        
	        System.out.println("-------");
			 for(int N=0;N<h;N++)
				{	
					for(int j=0;j<w;j++)
					{
						System.out.print(map[N][j]+" ");
					}
					System.out.println("");
					
				}	
	    }	
	    
	}
}			
