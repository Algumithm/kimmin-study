import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] PRICE;
	static int[] MONTH;
	static int[] R_MONTH;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			PRICE = new int[4];
			MONTH = new int[13];
			R_MONTH = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				PRICE[i] = Integer.parseInt(st.nextToken());
			}
			
			// 값 입력 및 일간 비용 계산
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				MONTH[i] = Integer.parseInt(st.nextToken()) * PRICE[0];
				R_MONTH[13-i] = MONTH[i];
			}
			
			// 월간 값 비교 및 비용 계산
			for(int i = 1; i <= 12; i++) {
				if(MONTH[i] > PRICE[1]) MONTH[i] = PRICE[1];
				if(R_MONTH[i] > PRICE[1]) R_MONTH[i] = PRICE[1];
			}
			
			// 3개월 값 비교 및 비용 계산
			for(int i = 1; i <= 12;) {
				if(i <= 10) {
					if(MONTH[i] + MONTH[i+1] + MONTH[i+2] > PRICE[2]) {
						MONTH[i] = PRICE[2];
						MONTH[i+1] = 0;
						MONTH[i+2] = 0;
						i+=3;
					} else i++;
				} else if(i == 11) {
					if(MONTH[i] + MONTH[i+1] > PRICE[2]) {
						MONTH[i] = PRICE[2];
						MONTH[i+1] = 0;
						i+=2;
					} else i++;
				} else if(i == 12) {
					if(MONTH[i] > PRICE[2]) {
						MONTH[i] = PRICE[2];
						i++;
					} else i++;
				}
			}
			
			for(int i = 1; i <= 12;) {
				if(i <= 10) {
					if(R_MONTH[i] + R_MONTH[i+1] + R_MONTH[i+2] > PRICE[2]) {
						R_MONTH[i] = PRICE[2];
						R_MONTH[i+1] = 0;
						R_MONTH[i+2] = 0;
						i+=3;
					} else i++;
				} else if(i == 11) {
					if(R_MONTH[i] + R_MONTH[i+1] > PRICE[2]) {
						R_MONTH[i] = PRICE[2];
						R_MONTH[i+1] = 0;
						i+=2;
					} else i++;
				} else if(i == 12) {
					if(R_MONTH[i] > PRICE[2]) {
						R_MONTH[i] = PRICE[2];
						i++;
					} else i++;
				}
			}
			
			// 연간 값 비교 및 결과 출력
			int result = 0;
			int r_result = 0;
			for(int i = 1; i <= 12; i++) {
				result += MONTH[i];
			}
			for(int i = 1; i <= 12; i++) {
				r_result += R_MONTH[i];
			}
			result = Math.min(PRICE[3], Math.min(result, r_result));
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}
}

