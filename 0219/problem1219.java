import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	final static int START = 0;
	final static int FINAL = 99;
	
	static int[][] stack = new int[100][2];
	
	static int whereIGo(int[] nowPosition) {
		if(nowPosition[0] == 100) return 1;
		
		else if(nowPosition[0] == 0 && nowPosition[1] == 0) return 0;
		
		else {
			if(nowPosition[0] != 0 && whereIGo(stack[nowPosition[0]]) == 1) return 1;
			
			if(nowPosition[1] != 0 && whereIGo(stack[nowPosition[1]]) == 1) return 1;
			
			return 0;
		}
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
			int size = Integer.parseInt(st.nextToken());
						
			int able = 0;
			
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
			    stack[i][0] = 0;
			    stack[i][1] = 0;
			}
			
			for(int i = 0; i < size; i++) {
				int cur = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				if(stack[cur][0] != 0) stack[cur][1] = next;
				else stack[cur][0] = next;
			}
			
			stack[FINAL][0] = 100;
			
			able = whereIGo(stack[START]);
			
			System.out.println("#" + test_case + " " + able);
		}
		br.close();
	}
}
