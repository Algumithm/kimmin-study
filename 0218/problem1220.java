import java.io.FileInputStream;
import java.util.Scanner;

public class problem1220 {
	final static int N = 1;
	final static int S = 2;
	
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = sc.nextInt();
			int[][] grid = new int[size][size];
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			boolean flag = false;
			
			int conflict = 0;
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(grid[j][i] == N) {
						flag = true;
					} else if(grid[j][i] == S && flag) {
						conflict++;
						flag = false;
					}
				}
				flag = false;
			}
			
			System.out.println("#" + test_case + " " + conflict);
		}
		sc.close();
	}
}
