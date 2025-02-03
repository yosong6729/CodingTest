import java.util.*;

class Body implements Comparable<Body>{
	int x;
	int y;
	
	Body(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Body o) {
		if(o.x != this.x) {
			return o.x - this.x;
		}else {
			return o.y - this.y;
		}
	}
}

public class Main {
	
	public void solution(int n, ArrayList<Body> list) {
		
		Collections.sort(list);
		int y = list.get(0).y;
		int result = list.size();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).y < y) {
				result--;
			}else {
				y = list.get(i).y;
			}
		}
		
		System.out.print(result);
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		
		int n  = kb.nextInt();
		ArrayList<Body> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			list.add(new Body(x, y));
		}
		
		T.solution(n, list);
	}
}
