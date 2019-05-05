package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg1208 {
	static int[][] input;
	static int N, S;
	static long ans = 0;
	static final int stn = 8000000; // -4백만 - 4백만
	static int[] size = new int[2];
	static int[] Asize = new int[2];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		if(N == 1){
			System.out.println(S == Integer.parseInt(st.nextToken())? 1 : 0);
			return;
		}
		input = new int[2][]; // 두 개로 쪼갬
		Asize[0] = N/2; Asize[1] = N-N/2;
		input[0] = new int[N/2]; // 0-
		input[1] = new int[N-N/2]; // 0-
		for(int i = 0; i < N/2; i++)
			input[0][i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N-N/2; i++)
			input[1][i] = Integer.parseInt(st.nextToken());
		// 각 배열에서 가능한 합들을 저장
		for(int i = 0; i < 2; i++)
		list.add(new ArrayList<Integer>(1<<((N/2)+1))); // 가능한 합 저장
		FindSet(-1, stn, 0);
		FindSet(-1, stn, 1);
		for(int i = 0; i < 2; i++)
		Collections.sort(list.get(i));
		// 두 list의 결과를 합친다.
		// list(0)에 있는 a를 S에서 뺀 S-a를 B에서 찾는다.(이분탐색)
		// list(0)에서 인접한 a가 같은 경우 바로 전 a 답을 가져옴
		int temp = upper_bound(S - list.get(0).get(0)) - lower_bound(S - list.get(0).get(0));
		ans += temp;
		for(int i = 1; i < size[0]; i++){
			if(list.get(0).get(i) == list.get(0).get(i-1))
				ans += temp;
			else{
				temp = upper_bound(S - list.get(0).get(i)) - lower_bound(S - list.get(0).get(i));
			ans += temp;
			}
		}
		System.out.println(ans);
	}
	static int lower_bound(int k){
		// a[m-1] < k <= a[m]인 m을 list(1)에서 찾는다.
		int lo = 0;
		int hi = size[1];
		while(hi-lo > 0){
			int mid = (hi+lo)/2;
			if(k > list.get(1).get(mid))
				lo = mid+1;
			else // key가 mid값보다 작거나 같다!
				hi = mid; // key보다 큰 값도 범위에 넣음
		}
		return hi; 
	}
	static int upper_bound(int k){
		// a[m-1] <= k < a[m]인 m을 찾는다.
		int lo = 0;
		int hi = size[1];
		while(hi-lo > 0){
			int mid = (hi+lo)/2;
			if(k >= list.get(1).get(mid))
				lo = mid+1; // 어차피 같은 건 보지 않을 거니
			else // key가 mid값보다 작음
				hi = mid;
		}
		return hi;
	}
	static void FindSet(int lastI, int sum, int num){ // 각 범위에서 답 구하고 가능한 조합 출력
		// lastI까지 볼 때 쌓인 sum
		if(lastI == Asize[num]-1){
			if(sum != stn){
			list.get(num).add(sum);	
			size[num]++;	
			}
			if(sum == S)
				ans++;
			return;
		}
		// 지금 수를 선택하느냐 선택을 안하느냐
		FindSet(lastI+1, sum, num);
		if(sum == stn)
			FindSet(lastI+1, input[num][lastI+1], num);
		else
		FindSet(lastI+1, sum+input[num][lastI+1], num);	
	}
}
