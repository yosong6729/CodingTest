import java.util.*;

class Main {

    public int BFS(int n){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        int answer = 0;
        int L = 0;
        boolean flag = true;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                if(x == 1){
                    answer = L;
                    flag = false;
                    break;
                }
                if(x % 3 == 0 && x / 3 >= 1){
                    Q.offer(x / 3);
                }
                if(x % 2 == 0 && x / 2 >= 1){
                    Q.offer(x / 2);
                }
                
                if(x -1 >= 1){
                    Q.offer(x - 1);
                }
            }
            if(!flag){
                break;
            }
            L++;
        }
        
        return answer;
    }
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
        
        System.out.print(T.BFS(n));
	}
}