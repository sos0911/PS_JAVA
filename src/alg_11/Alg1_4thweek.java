package alg_11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Alg1_4thweek { // 3908번 : 서로 다른 소수의 합(success!)
    
    static int[][][] dp = new int[1121][15][1121]; // (0-1120)(0-14)(0-1120) :: x를 z를 포함한 이후의 소수 y개를 사용하여 나타내는 가짓수를 저장
    static boolean[] Isthatprime = new boolean[1121]; // 0 - 1120
    
    public static void main(String[] args) throws IOException{
        Arrays.fill(Isthatprime, true);
        Isthatprime[0] = false;
          Isthatprime[1] = false;
        int iterator = (int)Math.sqrt((double)1120);
        for(int i = 2; i <= iterator; i++)
            for(int j = i*i; j <= 1120; j += i)
                Isthatprime[j] = false;
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int[][] arr1 : dp)
        for(int[] arr2 : arr1)
        Arrays.fill(arr2, -1); // 초깃값 : -1
        
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 0; i < NofTC; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(findpossiP(n, k, 1)));
             bw.newLine();
        }
        br.close();
        bw.close();
    }
    
    static int findpossiP(int n, int k, int overN){ // (5,3) , (3,5) 구분 안해야 함
        if(n == 0 && k != 0) // 남은 수가 없는데 남은 소수는 있음
            return 0;
        if(n != 0 && k == 0) // 남은 수가 있는데 남은 소수가 없음
            return 0;
        if(n == 0 && k == 0) // 남은 수도 없고 남은 소수도 없음
            return 1;
        
        int answer = 0;
        for(int i = overN + 1; i <= n; i++){ // overN 이후의 숫자만 추가하도록 설정(final :: 오름차순)
            // 문제점 :: dp를 저장할 시 <10, 2> = (3,7)인데 앞에서 이미 3이 쓰인 경우 중복됨
            // dp 3차원 배열?
            if(Isthatprime[i]){ // 그 수가 소수일 떄 통과
                if(dp[n-i][k-1][i] != -1)
                    answer += dp[n-i][k-1][i]; // i를 포함한 이후의 숫자들로 구성
                else{
                    dp[n-i][k-1][i] = findpossiP(n-i, k-1, i);
                answer += dp[n-i][k-1][i];
                }
            }
        }
        return answer;
    }
}
