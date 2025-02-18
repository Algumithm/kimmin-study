import java.io.FileInputStream;
import java.util.Scanner;

public class problem1209 {
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = sc.nextInt();
			int[][] grid = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0;
			
			for(int i = 0; i < 100; i++) {
				int tempIJ = 0;
				int tempJI = 0;
				for(int j = 0; j < 100; j++) {
					tempIJ += grid[i][j];
					tempJI += grid[j][i];
				}
				sum = Math.max(sum, Math.max(tempIJ, tempJI));
			}
			
			int temp = 0;
			int temp2 = 0;
			
			for(int i = 0; i < 100; i++) {
				temp += grid[i][i];
				temp2 += grid[i][99-i];
			}

			sum = Math.max(sum, Math.max(temp, temp2));
						
			System.out.println("#" + test + " " + sum);
		}
		sc.close();
	}
}
