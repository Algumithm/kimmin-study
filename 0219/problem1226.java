import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	final static char ROAD = '0';
	final static char WALL = '1';
	final static char START = '2';
	final static char GOAL = '3';
	
	static int[] startPoint;
	static int[] goalPoint;
	
	final static int[][] xy = {
			{1, 0},
			{0, -1},
			{-1, 0},
			{0, 1}
	};
	
	static char[][] MAP = new char[16][16];
	
	static int whereIGo(int xPosition, int yPosition) {
		if(MAP[xPosition][yPosition] == GOAL) return 1;
		
		MAP[xPosition][yPosition] = WALL;
		
		for(int[] d:xy) {
			if(xPosition+d[0] >= 0 && xPosition+d[0] < 16 &&
					yPosition+d[1] >= 0 && yPosition+d[1] < 16 &&
					MAP[xPosition+d[0]][yPosition+d[1]] != WALL &&
					whereIGo(xPosition+d[0], yPosition+d[1]) == 1) return 1;
		}
		
		MAP[xPosition][yPosition] = ROAD;
		
		return 0;
	}
	
	static int[] findStart() {
		int[] start = {-1, -1};
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				if(MAP[i][j] == START) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		return start;
	}
	
	static int[] findGoal() {
		int[] goal = {-1, -1};
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				if(MAP[i][j] == GOAL) {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
		return goal;
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
						
			int able = 0;
			
			for(int i = 0; i < 16; i++) {
				MAP[i] = br.readLine().toCharArray();
			}
			startPoint = findStart();
			goalPoint = findGoal();
			
			able = whereIGo(startPoint[0], startPoint[1]);
			
			System.out.println("#" + test_case + " " + able);
		}
		br.close();
	}
}
