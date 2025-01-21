import java.util.*;
class Node {
	int data;
	Node lt, rt;
	Node(int data){
		this.data = data;
		lt = rt = null;
	}
}

public class Main {
	Node root;
	public int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Node n = Q.poll();
				if(n.lt == null && n.rt == null) {
					return L;
				}
				if(n.lt != null) {
					Q.offer(n.lt);
				}
				if(n.lt != null) {
					Q.offer(n.rt);
				}
			}
			L++;
		}
		
		return L;
	}
	
	public static void main(String[] args) {
		Main T = new Main();	
		Scanner kb = new Scanner(System.in);
		T.root=new Node(1);
		T.root.lt=new Node(2);
		T.root.rt=new Node(3);
		T.root.lt.lt=new Node(4);
		T.root.lt.rt=new Node(5);
		
		System.out.print(T.BFS(T.root));
	}
}
