package backjoonalg;
import java.util.Scanner;

public class Alg11401 { // 주세걸-방데르몽드 정리 사용
    static int[] dp; // N/2개 중 x개를 고르는 값을 저장
    static int N, K;
    static int answer; // N C K 저장
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        dp = new int[K+1]; // 0 - K
        dp[0] = 1; // 초기화
        long temp;
        for(int i = 1; i <= K; i++){
            if(i > N/2) // N/2CN/2를 넘으면 0으로 세팅 위함
                break;
            temp = (long)dp[i-1]*(N/2-i+1)/i;
            dp[i] = (int)(temp % 1000000007);
        }
            if(N % 2 == 1)
                for(int i = 0; i <= K; i++){
                    temp = (K-i-1 >= 0? answer + (long)dp[i]*(dp[K-i-1]+dp[K-i]) : answer + dp[i]);
                    answer = (int)(temp % 1000000007);
                    
                }
            else
                for(int i = 0; i <= K; i++){
                    temp = answer + (long)dp[i]*dp[K-i];
                    answer = (int)(temp % 1000000007);
                }
    System.out.println(answer);
    }
}
