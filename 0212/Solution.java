

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

    static int N;
    static int M;
    static int K;
    static int BORDER;

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
        }

		@Override
		public String toString() {
			return "Micro [y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + "]";
		}
    }
    
    static int changeDir(Micro micro) {
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
    	if(micro.x == 0 ||  micro.x == BORDER
    			|| micro.y == 0 ||  micro.y == BORDER) {
    		micro.num /= 2;
            micro.dir = changeDir(micro);
    	}
    }
    
    static void moveMicro(Micro micro) {
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
            
            int total = 0;

            List<Micro> microList = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                int num = sc.nextInt();
                int dir = sc.nextInt();
                microList.add(new Micro(y, x, num, dir));
//                System.out.println(microList.get(k));
            }
            
            microList.sort(Comparator.comparingInt((Micro m) -> m.num).reversed());
            
            for (int m = 0; m < M; m++) {
            	for (int k = 0; k < microList.size(); k++) {
            		moveMicro(microList.get(k));
            	}
            	
            	int size = microList.size();
            	
	            for (int k = 0; k < size - 1; k++) {
	            	for(int l = k; l < size; l++) {
	            		Micro first = microList.get(k);
	            		Micro second = microList.get(l);
	            		
	            		if (microList.get(k).equals(microList.get(l)))
	            			continue;
	            		
	            		if(first.y == second.y
	            				&& first.x == second.x) {
	            			if (first.num > second.num) {
	            				first.num += second.num;
	            				microList.remove(l);
	            				l--;
	            			} else {
	            				second.num += first.num;
	            				microList.remove(k);
	            				l = k;
	            			}
	        				size--;
	            		}
	            	}
	        	}
	            for (int k = 0; k < microList.size(); k++) {
            		if (microList.get(k).num == 0) {
            			microList.remove(k);
            			k--;
            		}
	            }
            }
            
            
            for (int k = 0; k < microList.size(); k++) {
            	total += microList.get(k).num;
            }
            
            System.out.println("#" + t + " " + total);
        }
        sc.close();
    }
}