import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result = 0;
			
			int[] boxes = new int[100];
			
			int dump = sc.nextInt();
			
			for(int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			
			for(int i = 0; i < dump; i++) {
				Arrays.sort(boxes);
				if(boxes[99] - boxes[0] >= 2) {
					boxes[99]--;
					boxes[0]++;
					result = boxes[99] - boxes[0];
				} else {
					break;
				}
			}

			Arrays.sort(boxes);
			result = boxes[99] - boxes[0];
			
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
