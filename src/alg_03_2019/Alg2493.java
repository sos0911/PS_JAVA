package alg_03_2019;
import java.io.*;
import java.util.*;
class Info2493{
	int idx, val; // 번호 (1 - N)
	public Info2493(int idx, int val){
		this.idx = idx;
		this.val = val;
	}
}
public class Alg2493 {
	
	public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Info2493> s1 = new Stack<Info2493>(); // input
		Stack<Info2493> s2 = new Stack<Info2493>(); // 수신탑 못 찾은 감시탑들
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N+1]; // 정답 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++)
			s1.push(new Info2493(i, Integer.parseInt(st.nextToken())));
		s2.push(s1.pop()); // initiate
		Info2493 temp, temp2;
		while(!s1.isEmpty()){
			temp = s1.pop();
				while(!s2.isEmpty() && temp.val >= s2.peek().val)
					ans[s2.pop().idx] = temp.idx;	
			s2.push(temp);	
		}
		// s2에 남은 것들은 수신탑을 못 찾은 것이다.
		while(!s2.isEmpty())
			ans[s2.pop().idx] = 0;
		for(int i = 1; i <= N; i++)
			bw.write(ans[i] + " ");
		bw.close();
	}
}
/*
반례 ::
5

5 3 2 1 4
*/