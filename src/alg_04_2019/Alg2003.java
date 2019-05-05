package alg_04_2019;
import java.util.*;
import java.io.*;
public class Alg2003 {
	static int[] psum;
	static int N, M;
	 public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 psum = new int[N+1]; // psum[0] = 0;
		 psum[1] = Integer.parseInt(st.nextToken());
		 for(int i=2;i<=N;i++)
			 psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
		 // 이분 탐색, low, high
		 int ans = 0;
		 for(int i=0;i<N;i++)
			 ans += upper_bound(i) - lower_bound(i);
		 System.out.println(ans);
	 }
	static int lower_bound(int i){ // psum[(j-1)-i] < M && psum[j-i] >= M인 j
		int lo = i+1, hi = N+1, mid;
		while(hi-lo > 0){
			mid = (lo+hi)/2;
			if(psum[mid]-psum[i] < M)
				lo = mid+1;
			else
				hi = mid;
		}
		return hi;
	}
	static int upper_bound(int i){ // psum[(j-1)-i] <= M && psum[j-i] > M인 j
		int lo = i+1, hi = N+1, mid;
		while(hi-lo > 0){
			mid = (lo+hi)/2;
			if(psum[mid]-psum[i] <= M)
				lo = mid+1;
			else
				hi = mid;
		}
		return hi;
	}
}
