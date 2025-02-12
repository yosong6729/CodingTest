import java.util.*;

class B implements Comparable<B>{
	int s;
	int h;
	int w;
	
	B(int s, int h, int w){
		this.s = s;
		this.h = h;
		this.w = w;
	}
	
	@Override
	public int compareTo(B o) {
		return o.s - this.s;
	}
}


class Main {
	
	static int n;
	static int[] dy;
	public void solution(ArrayList<B> list) {
		
		dy[0] = list.get(0).h;
		
		for(int i = 1; i < n; i++) {
			int max = 0;
			for(int j = i; j >= 0; j--) {
				if(list.get(j).w > list.get(i).w) {
					int a = dy[j] + list.get(i).h;
					max = Math.max(max, a);
				}
			}
			if(max == 0) {
				dy[i] = list.get(i).h;
			}else {
				dy[i] = max;
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		dy = new int[n];
		ArrayList<B> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			list.add(new B(a, b, c));
		}
		
		Collections.sort(list);
		
		T.solution(list);
		
		int result = 0;
		for(int i = 0; i < dy.length; i++) {
			result = Math.max(result, dy[i]);
		}
		
		System.out.print(result);
		
	}
}