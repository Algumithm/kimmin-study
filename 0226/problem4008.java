import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int MIN;
	static int MAX;
	
	static int[] NUMBER;
	
	static void solve(int[] op, int index, int result) {
		if(index == NUMBER.length-1) {
			if(result > MAX) MAX = result;
			if(MIN > result) MIN = result;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) solve(op, index+1, result+NUMBER[index+1]);
				if(i == 1) solve(op, index+1, result-NUMBER[index+1]);
				if(i == 2) solve(op, index+1, result*NUMBER[index+1]);
				if(i == 3) solve(op, index+1, result/NUMBER[index+1]);
				op[i]++;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = Integer.parseInt(br.readLine());
			
			MIN = Integer.MAX_VALUE;
			MAX = Integer.MIN_VALUE;
			NUMBER = new int[length];
			int op[] = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < length; i++) NUMBER[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < 4; i++) if(op[i] > 0) solve(op, 0, NUMBER[0]);
			
			System.out.println("#" + test_case + " " + (MAX - MIN));
		}
		br.close();
	}
}
