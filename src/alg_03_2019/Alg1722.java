package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1722 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] fac = new long[21]; // 1 - 20
		fac[0] = 1; // 편의상 1로 가정
		for(int i = 1; i < 21; i++)
			fac[i] = fac[i-1]*i;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		boolean[] used = new boolean[N+1]; // 1 - N, 방문 배열
		if(Q == 1){ // 1. K번째 순열을 구하라.
			int[] ans = new int[N]; // 0 -
			long K = Long.parseLong(st.nextToken());
			long order;
			for(int i = 0; i < N; i++){ // 한 자리씩 찾는다.
				order = (K%fac[N-1-i] == 0? K/fac[N-1-i] : K/fac[N-1-i] +1);
				int ind = 1, temp = 0;
				while(temp != order) // 상대적 순서 order에 해당하는 수 찾음
					if(!used[ind++])
						temp++;
				// ind-1
				ans[i] = ind-1;
				used[ind-1] = true;
				K -= (order-1)*fac[N-1-i];
			}
			for(int i : ans)
				bw.write(i + " ");
			}
		else{ // 2. 주어지는 수열이 몇 번째인지 찾아낸다.
			// for문마다 오는 수 앞 순서의 visited처리된 거 말고 전부 ++
			int temp; 
			long ans = 1;
			for(int i = 0; i < N; i++){
				temp = Integer.parseInt(st.nextToken());
				for(int j = 1; j < temp; j++)
					if(!used[j])
						ans += fac[N-1-i];
				used[temp] = true;
			}
			bw.write(ans + "\n");
		}
		bw.close();
		}	
	}
