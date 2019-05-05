package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg11920 {
	
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> ans = new PriorityQueue<Integer>(K);
		// 우선순위 큐는 그 시점까지 본 수들 중 큰 상위 K개의 수가 있다.
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			ans.add(Integer.parseInt(st.nextToken()));
			if(i >= K)
				bw.write(ans.poll() + " ");
		}
		while(!ans.isEmpty())
			bw.write(ans.poll() + " ");
		bw.close();
	}
}
/*
https://bcp0109.tistory.com/51?category=847904
*/