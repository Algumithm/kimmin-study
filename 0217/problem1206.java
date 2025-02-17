import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		
//		System.setIn(new FileInputStream("src/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int caseWidth = sc.nextInt();
			int[] buildings = new int[caseWidth];
			int result = 0;
			
			for(int i = 0; i < caseWidth; i++) {
				buildings[i] = sc.nextInt();
			}
			
			for(int i = 2; i < caseWidth-2;) {
				
				int iCanSee = 256;
				
				if(buildings[i] > buildings[i-2] &&
						buildings[i] > buildings[i-1] &&
						buildings[i] > buildings[i+1] &&
						buildings[i] > buildings[i+2]) {
					for(int j = -2; j <= 2; j++) {
						if(j == 0) continue;
						if(buildings[i] - buildings[i+j] <= iCanSee) {
							iCanSee = buildings[i] - buildings[i+j];
						}
					}
					result += iCanSee;
					i += 3;
				} else {
					i++;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
