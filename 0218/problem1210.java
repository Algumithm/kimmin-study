import java.io.FileInputStream;
import java.util.Scanner;

public class poblem1210 {
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = sc.nextInt();
			int[][] grid = new int[100][100];
			
			int startIndex = 0;
			int finalIndex = 0;
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					grid[i][j] = sc.nextInt();
					if (grid[i][j] == 2) {
						startIndex = j;
					}
				}
			}
			int index = startIndex;
			
			for(int i = 99; i >= 0;) {
				if(index == 0) {
					if(grid[i][index+1] == 1) {
						for(int temp = 0; temp < 100; temp++) {
							if(index == 99) {
								break;
							} else if(grid[i][index+1] == 1) {
								index++;
							} else {
								break;
							}
						}
					}
				} else if(index == 99) {
					if(grid[i][index-1] == 1) {
						for(int temp = 99; temp >= 0; temp--) {
							if(index == 0) {
								break;
							} else if(grid[i][index-1] == 1) {
								index--;
							} else {
								break;
							}
						}
					}
				} else {
					if(grid[i][index+1] == 1) {
						for(int temp = 0; temp < 100; temp++) {
							if(index == 99) {
								break;
							} else if(grid[i][index+1] == 1) {
								index++;
							} else {
								break;
							}
						}
					} else if(grid[i][index-1] == 1) {
						for(int temp = 99; temp >= 0; temp--) {
							if(index == 0) {
								break;
							} else if(grid[i][index-1] == 1) {
								index--;
							} else {
								break;
							}
						}
					}
				}

				i--;
				if(i == 0) {
					finalIndex = index;
					break;
				}
			}
			
			System.out.println("#" + test + " " + finalIndex);
		}
		sc.close();
	}
}
