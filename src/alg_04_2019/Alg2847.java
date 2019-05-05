package alg_04_2019;
import java.io.*;
import java.util.*;
public class Alg2847 {
	
	public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N]; //0-
		for(int i=0;i<N;i++)
			input[i] = Integer.parseInt(br.readLine());
		int stN, ans = 0;
		// 답이 유효한 경우만 주어진다.
		for(int i=N-1;i>0;i--){
			stN = input[i];
			if(input[i-1] >= stN-1){
				ans += input[i-1]-(stN-1);
				input[i-1] = stN-1;	
			}
			// 작을 때에는 그대로 놔두고 진행
			stN = input[i-1];
		}
		System.out.println(ans);
	}
}
