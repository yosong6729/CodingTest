import java.util.*;

public class Main {
	
	public int solution(int n, int k,int[] arr) {
		ArrayList<Integer> kArray = new ArrayList<>();
		int kSum = 0;
		int lt = 0; 
		int max = 0;
		
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				kSum++;
				kArray.add(rt);
				if(kSum == k + 1) {
					max = Math.max(max, rt - lt);
					arr[rt] = 1;
					lt = kArray.get(0);
					arr[lt] = 0;
					lt++;
					kSum--;
					kArray.remove(0);
				}
				arr[rt] = 1;
			}
			
			
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, k,arr));
	}
}
