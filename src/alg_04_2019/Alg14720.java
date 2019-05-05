package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg14720 {
	
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] dp = new int[N];
		// dp[i] = input[i]까지 볼 때 마시는 최대 우유 갯수(input[i] 포함)
		Arrays.fill(dp, -1); // default
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			if((input[i] = Integer.parseInt(st.nextToken())) == 0)
				dp[i] = 1; // 여기서부터 시작 가능
		for(int i = 0; i < N; i++)
			for(int j = 0; j < i; j++)
				if(dp[j] != -1 && (input[j]+1)%3 == input[i])
				dp[i] = Math.max(dp[i], dp[j] + 1);
		int ans = 0;
		for(int i = 0; i < N; i++)
			ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}
