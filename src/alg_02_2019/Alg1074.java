package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg1074 {
    static int R, C; // 목표지점
    static int[] pow; // 거듭제곱
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pow = new int[N+1]; // index 1 -
        pow[0] = 1;
        for(int i = 1; i < N+1; i++)
            pow[i] = pow[i-1]*2;
        System.out.println(find(N, 0, 0));
    }
    static int find(int N, int sr, int sc){ // 현재 탐색 공간 너비가 2^N, (sr,sc)부터 탐색 시작
        if(N == 0) // 기저 사례 : 한 칸
            return 0;
        int answer = 0;
        if(R < sr + pow[N-1]){
            if(C < sc + pow[N-1])
                answer += find(N-1, sr, sc);
            else
                answer += pow[N-1]*pow[N-1] + find(N-1, sr, sc + pow[N-1]);
        }
        else{
            if(C < sc + pow[N-1])
                answer += pow[N-1]*pow[N-1]*2 + find(N-1, sr + pow[N-1], sc);
            else
               answer += pow[N-1]*pow[N-1]*3 + find(N-1, sr + pow[N-1], sc + pow[N-1]);
        }
        return answer;
    }
}
