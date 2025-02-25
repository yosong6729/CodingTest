import java.util.*;


class Main {
	
	static ArrayList<Integer> result;
	static int[] plus = {1, 2, 3};
	static int total = 0;
	public void DFS(int n, int sum) {
		if(n == sum) {
			total++;
		}
		if(sum > n) {
			return;
		}else {
			for(int i = 0; i < 3; i++) {
				DFS(n, sum + plus[i]);
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int t  = kb.nextInt();
		int[] n = new int[t];
		result = new ArrayList<>();
		
		for(int i = 0; i < t; i++) {
			T.DFS(kb.nextInt(), 0);
			result.add(total);
			total = 0;
		}	
		
		for(int x : result) {
			System.out.println(x);
		}
		
	}
}