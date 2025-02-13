

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

	static int N;  // 공간 n 상수선언
	static int M;  // 시간 m 상수선언
	static int K;  // 군집 수 k 상수선언
	static int BORDER;  // 약품 처리 영역 중 n - 1 을 border로 상수선언

	static class Micro {
		int y;
		int x;
		int num;
		int dir;

		Micro(int y, int x, int num, int dir) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
		}  // 입력받은 y, x, num, dir 순서대로 객체 생성

	// @Override
	// 	public String toString() {
	// 		return "Micro [y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + "]";
	// 	}
	}
	
	static int changeDir(Micro micro) {
		// micro 객체의 방향 전환을 위한 switch-case문
			switch (micro.dir) {
			case 1:
				return 2;
			case 2:
				return 1;
			case 3:
				return 4;
			case 4:
				return 3;
			default:
				return -1;
		}
	}
	
	static void checkBorder(Micro micro) {
		// micro 객체가 약품 영역에 도달할 시 반감 후 방향 전환 함수 호출
		if(micro.x == 0 ||  micro.x == BORDER || micro.y == 0 ||  micro.y == BORDER) {
			micro.num /= 2;
			micro.dir = changeDir(micro);
		}
	}
	
	static void moveMicro(Micro micro) {
		// micro 객체 이동 후 약품 영역 위치 확인 함수 호출
		switch (micro.dir) {
			case 1: {
				micro.y--;
				checkBorder(micro);
				break;
			}
			case 2: {
				micro.y++;
				checkBorder(micro);
				break;
			}
			case 3: {
				micro.x--;
				checkBorder(micro);
				break;
			}
			case 4: {
				micro.x++;
				checkBorder(micro);
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int t = 1; t <= T; t++) {
				
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			BORDER = N - 1;
			
			// 케이스 별 선 입력 값을 상수에 대입
			
			int total = 0;

			List<Micro> microList = new ArrayList<>();
			for (int k = 0; k < K; k++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int num = sc.nextInt();
				int dir = sc.nextInt();
				microList.add(new Micro(y, x, num, dir));
                // System.out.println(microList.get(k));
			} // 해당 케이스의 군집 수 만큼 micro 객체 생성 후 ArrayList에 삽입
			
			microList.sort(Comparator.comparingInt((Micro m) -> m.num).reversed());
			// microList의 num값을 기준으로 내림차순 정렬
			
			for (int m = 0; m < M; m++) {
				for (int k = 0; k < microList.size(); k++) {
					moveMicro(microList.get(k));
				} // 군집 전체 이동 작업 수행
				
				int size = microList.size();
				
				for (int k = 0; k < size - 1; k++) {
					for(int l = k; l < size; l++) {
						// k와 k ~ BORDER 사이에 존재하는 micro 객체 비교
						Micro first = microList.get(k);
						Micro second = microList.get(l);
						
						if (microList.get(k).equals(microList.get(l)))
							continue;
						// 만약 같은 객체를 비교할 시 continue
						
						if(first.y == second.y && first.x == second.x) {
							// 군집들이 같은 위치에 존재할 시
							if (first.num > second.num) {
								// k쪽이 클 경우 k쪽으로 군집 흡수
								first.num += second.num;
								microList.remove(l);
								l--;
								// 삭제당한 객체만큼 l감소
							} else {
								// l쪽이 클 경우 l쪽으로 군집 흡수
								second.num += first.num;
								microList.remove(k);
								l = k;
								// k가 삭제당했으므로 k for루프 재수행
							}
						size--;
						// 군집이 삭제됐으므로 전체 사이즈 축소
						}
					}
			}
				for (int k = 0; k < microList.size(); k++) {
					if (microList.get(k).num == 0) {
						microList.remove(k);
						k--;
					}
				} // 잔존 군집 중 0인 객체가 존재 시 삭제
			}
			
			
			for (int k = 0; k < microList.size(); k++) {
				total += microList.get(k).num;
			} // 잔존 군집들의 크기 합
			
			System.out.println("#" + t + " " + total);
		}
		sc.close();
	}
}