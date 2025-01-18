import java.util.*;

class Person{
	
	int id;
	int priority;
	
	public Person(int id, int priority){
		
		this.id = id;
		this.priority = priority;
	}
	
}

public class Main {

	public int solution(int n, int k, int[] arr) {
		
		Queue<Person> Q = new LinkedList<>();
		int answer = 0;
		for(int i = 0; i < n; i++) {
			Q.offer(new Person(i, arr[i]));
		}
		
		while(!Q.isEmpty()) {
			Person tmp = Q.poll();
			for(Person p : Q) {
				if(tmp.priority < p.priority) {
					Q.offer(tmp);
					tmp = null;
					break;
				}
			}
			if(tmp != null) {
				answer++;
				if(tmp.id == k) {
					return answer;
				}
			}
		}
		
		return answer;
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
		
		System.out.print(T.solution(n, k, arr));
		
	}
}
