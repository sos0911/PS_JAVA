package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg10973 {
    
    public static void main(String[] args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N]; // 0 -
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1은 따로 처리
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
         if(N == 1){
            bw.write("-1");
            bw.close();
            return;
        }
		int dstI = -1, astI = -1; // 마지막 내림차순 구간 시작 , 오름차순 구간 시작점
		boolean dcheck;
		if(input[0] > input[1]){
			dcheck = true;
			dstI = 0;
		}
		else{
			dcheck = false;
			astI = 0;
		}
        for(int i = 1; i < N-1; i++)
            if(input[i] > input[i+1] && !dcheck){
                dstI = i;
             dcheck = true;
            }
            else if(input[i] < input[i+1] && dcheck){
                astI = i;
             dcheck = false;   
            }
        if(dstI < astI){ // 마지막 일정 구간은 모두 오름차순
            if(astI == 0){ // 모두 오름차순
                bw.write("-1");
                bw.close();
                return;
            }
            for(int i = 0; i < astI-1; i++)
                bw.write(input[i] + " ");
         // 오름차순 구간에서 x보다 작은 수 찾아 위치 바꾸고 역순 출력
            int stN = input[astI-1];
            int lo = astI, hi = N-1;
            while(lo <= hi){
                int mid = (lo+hi)/2;
                if(stN > input[mid])
                    lo = mid+1;
                else if(stN < input[mid])
                    hi = mid-1;
            }
            int temp = input[hi];
            input[hi] = input[astI-1];
            input[astI-1] = temp; 
			bw.write(input[astI-1] + " ");
            for(int i = N-1; i >= astI; i--)
                bw.write(input[i] + " ");
        }
        else{ // 마지막 오름차순 구간 뒤 내림차순 구간이 존재
            int temp = input[N-2];
            input[N-2] = input[N-1];
            input[N-1] = temp;
            for(int i = 0; i < N; i++)
                bw.write(input[i] + " ");
        }
            bw.close();
    }
}