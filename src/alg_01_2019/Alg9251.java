package alg_01_2019;
import java.util.*;

public class Alg9251 {
    static String A, B;
    static int lenA, lenB;
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.nextLine(); B = sc.nextLine();
        lenA = A.length(); lenB = B.length();
        dp = new int[lenA+1][lenB+1]; // index 0 - N
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
         System.out.println(dfsdp(0, 0));
    }
    static int dfsdp(int startA, int startB){ // 가용 가능한 범위에서 글자 하나씩을 비교
        if(startA == lenA || startB == lenB) // 어느 문자열이 끝까지 탐색됨
            return 0;
        if(dp[startA][startB] != -1)
            return dp[startA][startB];
        int sum;
        if(A.charAt(startA) == B.charAt(startB)) // 단어 일치
            sum = dfsdp(startA+1, startB+1) + 1;
        else
            sum = Math.max(dfsdp(startA, startB+1), dfsdp(startA+1, startB));
        return dp[startA][startB] = sum;
    }
}
