package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg15482 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine(), B = br.readLine();
        int Alen = A.length(), Blen = B.length();
        int[][] LCS = new int[Alen+1][Blen+1]; // index 0 - 길이 끝까지 사용
        for(int i = 1; i <= Alen; i++)
            for(int j = 1; j <= Blen; j++){
                if(A.charAt(i-1) == B.charAt(j-1))
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
        System.out.println(LCS[Alen][Blen]);
    }
}
