import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static int[][] MAP;

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			MAP = new int[size][size];
			
			int sum = 0;
			
			for(int i = 0; i < size; i++) {
				String line = br.readLine();
				for(int j = 0; j < size; j++) {
					MAP[i][j] = line.charAt(j) - '0';
				}
			}
			
			int corner = size / 2;
			
			boolean flag = true;

			for(int i = 0; i < size; i++) {
				for(int j = 0 + corner; j < size - corner; j++) sum += MAP[i][j];

				if(flag) {
					if(corner == 0) {
						flag = false;
						corner++;
					} else corner--; 
				} else corner++; 
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
		br.close();
	}
}
