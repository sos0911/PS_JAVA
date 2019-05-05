package alg_01_2019;
import java.util.Scanner;

public class Alg1958 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A,B,C; int lenA, lenB, lenC;
        A = sc.nextLine(); B = sc.nextLine(); C = sc.nextLine();
        lenA = A.length(); lenB = B.length(); lenC = C.length();
        int[][][] lcs = new int[lenA+1][lenB+1][lenC+1]; // 가장자리 0
        for(int i = 1; i <= lenA; i++)
            for(int j = 1; j <= lenB; j++)
                for(int k = 1; k <= lenC; k++){
                    if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1))
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                    else
                        lcs[i][j][k] = Math.max(Math.max(lcs[i-1][j][k], lcs[i][j-1][k]), lcs[i][j][k-1]);
                }
        System.out.println(lcs[lenA][lenB][lenC]);
    }
}
