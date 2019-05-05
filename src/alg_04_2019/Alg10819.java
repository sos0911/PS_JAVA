package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg10819 {
	static int[] input;
	static int answer = -1, N;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N]; // 0-
		visited = new boolean[N]; // 0-
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		// 그냥 다 세보자..
		FindSet(-1, 3000, 0);
		System.out.println(answer);
	}
	static void FindSet(int lastI, int sum, int cnt){ // 조합을 만들어서 가장 큰 최댓값 출력
		// lastI : 조합에서 가장 마지막에 쓴 index
		if(cnt == N){
			answer = Math.max(answer, sum);
		return;	
		}
		for(int i = 0; i < N; i++)
			if(!visited[i]){ // 쓰이지 않음
				visited[i] = true;
				if(sum == 3000)
				FindSet(i, 0, cnt+1);
				else
			FindSet(i, sum + Math.abs(input[lastI] - input[i]), cnt+1);
				visited[i] = false;
			}
	}
}
