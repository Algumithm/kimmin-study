import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int C = sc.nextInt();
			int[] student = new int[101];
			int max = 0;
			int maxScore = 0;
			
			for(int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				student[score]++;
			}
			for(int i = 1; i < 101; i++) {
				if(student[i] == 0) continue;
				if(student[i] >= max) {
					max = student[i];
					maxScore = i;
				}
			}
			System.out.println("#" + C + " " + maxScore);
		}
		sc.close();
	}
}
