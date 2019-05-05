package alg_04_2019;
import java.io.*;
import java.util.*;
class Info1517{
	int ind, val;
	public Info1517(int ind, int val){
		this.ind = ind;
		this.val = val;
	}
}
public class Alg1517 {
	static long[] tree;
	static int N;
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// fanweek tree 사용
		N = Integer.parseInt(br.readLine());
		Info1517[] input = new Info1517[N+1]; // 1-N
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			input[i] = new Info1517(i, Integer.parseInt(st.nextToken()));
		tree = new long[N+1]; // 1-N
		Arrays.sort(input, 1, N+1, (i1, i2) -> -Integer.compare(i1.val, i2.val)); // 내림차순 정렬
		/*
		for(int i=1;i<=N;i++)
			System.out.println(input[i].ind + " :: " + input[i].val);
			*/
		long ans = 0, temp = Long.MAX_VALUE; input[0] = new Info1517(-1, Integer.MAX_VALUE);
		for(int i=1;i<=N;i++){
			if(input[i-1].val != input[i].val) // 앞의 경우와 값 동일x
			temp = sum(input[i].ind-1);
			ans += temp;
			// 먼저 나온 것들 중 자신보다 작은 index들을 +
			update(input[i].ind); // 해당 index update
		}
		System.out.println(ans);
	}
	static long sum(int i){
		long suma = 0;
		while(i > 0){
			suma += tree[i];
			i -= (i&-i);
		}
		return suma;
	}
	static void update(int i){
		while(i <= N){
			tree[i]++;
			i += (i&-i);
		}	
	}
}
