package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg16938 {
    static int answer = 0;
    static int[] input;
    static int min = -1, max = 1000001;
    static int N, L, R, X;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        findcom(0, max, min, 0, 0);
        System.out.println(answer);
    } // 정렬해서 하는 건 다음에.
    static void findcom(int cnt, int lo, int hi, int sum, int tarI){
        if(tarI == N){ // 다 썼음
            if(cnt >= 2 && sum >= L && sum <= R && hi-lo >= X)
                answer++;
         return;   
        }
        // tarI를 선택하거나 안하거나
        findcom(cnt, lo, hi, sum, tarI+1);
         if(sum + input[tarI] <= R){
        lo = Math.min(lo, input[tarI]);
        hi = Math.max(hi, input[tarI]);
        findcom(cnt+1, lo, hi, sum + input[tarI], tarI+1);
         }
    }
}
/*
브루트 or dp

1000000000 <= int

난이도 순서대로 정렬ㄱ

4 40 50 10
10 20 30 25

>> 10 20 25 30

난이도 합은 40 - 50
난이도 차이는 10 이하

>>

재귀로 구할건데 어차피 한 집합이 난이도 합을 넘는데 거기에 뭘 추가하는게 안됨
한 집합의 난이도 차이가 10인데 그 뒤로 뭘 추가할 수가 없음
findcom(int first, int sum, int tar) : first가 첫 수일때 지금까지 쌓은 sum

*/