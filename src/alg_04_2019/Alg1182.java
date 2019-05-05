package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1182 {
	static int[] input;
	static int N, S, ans = 0;
	static final int stn = 3000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N]; // 0-
		for(int i =0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		FindSet(-1, stn);
		System.out.println(ans);
	}
	static void FindSet(int lastI, int sum){
		// lastI까지 볼 때 쌓인 sum
		if(lastI == N-1){
			if(sum == S) // 볼 수 있는 끝까지 보고 sum이 조건 충족
			ans++;
			return;
		}
		// 지금 수를 선택하느냐 선택을 안하느냐
		FindSet(lastI+1, sum);
		if(sum == stn)
			FindSet(lastI+1, input[lastI+1]);
		else
		FindSet(lastI+1, sum+input[lastI+1]);	
	}
}
