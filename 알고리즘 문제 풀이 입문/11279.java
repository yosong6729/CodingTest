import java.util.*;


class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < n ; i++) {
			int x = kb.nextInt();
			if(x == 0) {
				if(PQ.size() == 0) {
					result.add(0);
				}else {
					result.add(PQ.poll());
				}
			}else {
				PQ.offer(x);
			}
		}
		
		for(int x : result) {
			System.out.println(x);
		}
		
	}
}