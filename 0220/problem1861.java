import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ROOM_NUM;
	static int ROOM_MAX;
	
	static int SIZE;
	static int[][] MAP;
	
	final static int[][] XY = {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	
	static void findRoom(int i, int j, int max, int position) {
		int cur = MAP[i][j];
		boolean moved = false;

		for(int[] d:XY) {
			int dx = i + d[0];
			int dy = j + d[1];
			if(dx >= 0 && dx < SIZE &&
				dy >= 0 && dy < SIZE && 
				MAP[dx][dy] == cur+1) {
				findRoom(dx, dy, max+1, position);
				moved = true;
			} 
		} 
		
		if(!moved) {
			if(max > ROOM_MAX) {
				ROOM_MAX = max;
				ROOM_NUM = position;
			} else if(max == ROOM_MAX) {
				if(ROOM_NUM > position) {
					ROOM_MAX = max;
					ROOM_NUM = position;
				}
			}
			return;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			SIZE = Integer.parseInt(br.readLine());
			
			MAP = new int[SIZE][SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					MAP[i][j] =  Integer.parseInt(st.nextToken());
				}
			}
			
			ROOM_NUM = Integer.MAX_VALUE;
			ROOM_MAX = Integer.MIN_VALUE;
			
			for(int i = 0; i < SIZE; i++) {
				for(int j = 0; j < SIZE; j++) {
					findRoom(i, j, 1, MAP[i][j]);
				}
			}
			
			System.out.println("#" + test_case + " " + ROOM_NUM + " " + ROOM_MAX);
		}
		br.close();
	}
}
