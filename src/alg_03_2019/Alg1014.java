package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1014 {
    // 만약 Integer.bitcount >> 시간초과 :: cache 사용
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[11][1024]; // 1 - 10 / 0 - 1023
        int[] bit = new int[1024]; // 0 - 1023 // 비트 수 저장
        for(int i = 0; i < 1024; i++)
            bit[i] = Integer.bitCount(i);
        // dp[0]은 모두 0
        int Noftc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < Noftc; i++){
         st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int widthc = 1 << M; // 한 줄당 자리 수 + 1
            for(int j = 1; j <= N; j++){
                String temp = br.readLine();
                int eachst = 0; // 각 줄마다의 부서짐 상태
                for(int s = M-1; s >= 0; s--)
                    if(temp.charAt(s) != '.')
                      eachst += 1 << (M-1)-s;
                for(int k = 0; k < widthc; k++){
                    if((k & eachst) != 0 || (k & (k*2)) != 0) // x자리에 앉거나 옆자리가 컨닝 가능한 경우 넘어감
                        continue;
                    for(int m = 0; m < widthc; m++)
                        if(((k*2) & m) == 0 && ((m*2) & k) == 0) // 앞 줄 상태가 컨닝 불가일때 갱신
                            dp[j][k] = Math.max(dp[j][k], dp[j-1][m] + bit[k]);
                }
            }
            int ans = -1;
            for(int j = 0; j < widthc; j++)
                ans = Math.max(ans, dp[N][j]);
            bw.write(ans + "\n");
            for(int[] arr : dp)
                Arrays.fill(arr, 0); // 초기화
        }
        bw.close();
    }
}

/*
....x.....
..........
..........
..x.......
..........
x...x.x...
.........x
...x......
........x.
.x...x....

dp[n][2^10] 

10*10*1024*1024

dp[n][m] = n번째 행까지 볼 때
n번째 행이 상태가 m일때
앉을 수 있는 학생 수 최대값

dp[1][0] = 0
dp[1][1] = 1
dp[1][2] = 1
..
dp[1] 초기값 세팅

for(int j = 0; j < 1024; j++)
for(int i = 0; i < 1024; i++)
dp[2][j] = if(dp[1][i] = 조건맞으면)
dp[1][i] + 비트 수 세서 2행에
앉을 수 있는 학생수

TC : 10*1024*1024

match 판별 : m%(n*2) > 0 || m%(n/2) > 0
이면 두 행 안의 학생들은
컨닝이 가능한 학생이 있다는거임
*/