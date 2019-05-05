package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg10972 {
    
    public static void main(String[] args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N]; // 0 -
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dstI = -1, astI = -1; // 마지막 내림차순 구간 시작 , 오름차순 구간 시작점
        boolean dcheck = false; // 내림차순 구간 진행 중?
        // 1은 따로 처리
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
         if(N == 1){
            bw.write("-1");
            bw.close();
            return;
        }
        for(int i = 0; i < N-1; i++)
            if(input[i] > input[i+1] && !dcheck){
                dstI = i;
             dcheck = true;
            }
            else if(input[i] < input[i+1]){
                astI = i;
             dcheck = false;   
            }
        if(dstI > astI){ // 마지막 일정 구간은 모두 내림차순
            if(dstI == 0){ // 모두 내림차순
                bw.write("-1");
                bw.close();
                return;
            }
            for(int i = 0; i < dstI-1; i++)
                bw.write(input[i] + " ");
         // 내림차순 정렬하고 결과에서 바로 앞 수보다 큰 수 찾아서 반환
        // 위치 서로 바꾸고 출력
            int stN = input[dstI-1];
            Arrays.sort(input, dstI, N);
            int lo = dstI, hi = N-1;
            while(lo <= hi){
                int mid = (lo+hi)/2;
                if(stN > input[mid])
                    lo = mid+1;
                else if(stN < input[mid])
                    hi = mid-1;
            }
            int temp = input[lo];
            input[lo] = input[dstI-1];
            input[dstI-1] = temp; 
            for(int i = dstI-1; i < N; i++)
                bw.write(input[i] + " ");
        }
        else{ // 마지막 내림차순 구간 뒤 오름차순이 1개라도 있음 
            int temp = input[N-2];
            input[N-2] = input[N-1];
            input[N-1] = temp;
            for(int i = 0; i < N; i++)
                bw.write(input[i] + " ");
        }
            bw.close();
    }
}
/*
제일 마지막에 나오는 부분 내림차순을 보자구요!
만약 마지막 부분 내림차순이 시작하는 부분 뒤에 오름차순이 하나라도 있으면
구성이 어떻든 간에 제일 뒷 두 수를 바꿔주기만 하면 됨

만약 마지막 부분 내림차순 시작 이후로 오름차순이 1개도 안나오면
마지막 부분 내림차순 구역을 찾아서 바로 앞 숫자가 바뀌어야 함
(바로 앞 숫자의 앞 구역은 바뀌면 안돼요)

바로 앞 숫자와 그 뒷숫자들을 정렬해서 그 중 바로 앞 숫자였던 숫자 바로 뒤 순서를
바로 앞 숫자 자리에 넣고 나머지를 정렬된 순서대로 출력하자


내림차순 구역이 없으면 바로 앞 숫자를 제일 끝숫자로 잡으면되고
내림차순 구역만 있으면 -1
*/