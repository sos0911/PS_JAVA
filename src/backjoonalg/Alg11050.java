package backjoonalg;
import java.util.*;

public class Alg11050 { // ncr = n-1cr-1 + n-1cr
    static int N, K;
    static long[][] dp = new long[1001][1001]; // N, K
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        for(long[] arr : dp)
        Arrays.fill(arr, -1);
        System.out.println(Comb(N, K));
    }
    static long Comb(int N, int K){
        if(K == 0 || N == K)
            return 1;
        if(K == 1)
            return N;
        if(dp[N][K] != -1)
            return dp[N][K];
        return dp[N][K] = (Comb(N-1, K-1)+Comb(N-1, K));
    }
}
