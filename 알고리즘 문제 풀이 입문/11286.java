import java.util.*;
import java.io.*;

class Value implements Comparable<Value>{
	int x;
	int ax;
	Value(int x, int ax){
		this.x = x;
		this.ax = ax;
	}
	
	@Override
	public int compareTo(Value o) {
		if(o.ax == this.ax) {
			return this.x - o.x;
		}else {
			return this.ax - o.ax;
		}
	}
}

class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		PriorityQueue<Value> PQ = new PriorityQueue<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int ax = Math.abs(x);
			
			if(x != 0) {
				PQ.offer(new Value(x, ax));
			}else {
				if(PQ.isEmpty()) {
					result.add(0);
				}else {
					result.add(PQ.poll().x);
				}
			}
		}
		
		for(int x : result) {
			System.out.println(x);
		}
	}
}