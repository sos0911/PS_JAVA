package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg2294 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1]; // 1 - k
		// dp[i] : 가치 i를 만들 때 쓴 동전의 최소 개수
		boolean[] check = new boolean[100001]; // 어떤 동전들이 있나?
		ArrayList<Integer> coin = new ArrayList<Integer>(100);
		Arrays.fill(dp, 20000);
		for(int i = 0; i < n; i++){
			int input =  Integer.parseInt(br.readLine());
			if(!check[input]){
				coin.add(input);
			check[input] = true;	
			}
			if(input <= k)
			dp[input] = 1;
		}
		 Collections.sort(coin); // 오름차순 정렬
		int len = coin.size();
		for(int i = 1; i <= k; i++){
			int aidx = 0, temp;
			while(aidx < len && (temp = coin.get(aidx++)) < i)
					dp[i] = Math.min(dp[i], dp[i-temp]+1);
		}
		System.out.println(dp[k] == 20000? -1 : dp[k]);
	}
}
/*
동전들 겹치지 않게 오름차순 sort해서 arrylist에 집어넣고
for문 돌리면 tc 줄어듦
*/