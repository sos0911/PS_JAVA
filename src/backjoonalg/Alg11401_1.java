package backjoonalg;
import java.util.*;

public class Alg11401_1 {
    static final int P = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt(); K = sc.nextInt();
        long t1 = 1, t2 = 1;// N!, (K!)(N-K)!
        for(int i = 2; i <= N; i++){
            t1 *= i;
            t1 %= P;   
        }
        for(int i = 2; i <= K; i++){
            t2 *= i;
            t2 %= P;
        }
        for(int i = 2; i <= N-K; i++){
            t2 *= i;
            t2 %= P;
        }
        long t3 = mul(t2, P-2); // B^(P-2)
        t3 %= P;
        long answer = t1*t3; // 답 변수 (t1*t2^(P-2))mod P
        answer %= P;
        System.out.println(answer);
    }
    static long mul(long B, long Pde2){
        long tempA = 1;
        while(Pde2 > 0){
            if(Pde2%2 != 0){
                tempA *= B;
                tempA %= P;
            }
            B *= B;
            B %= P;
            Pde2 /= 2;
        }
        return tempA;
    }
}
