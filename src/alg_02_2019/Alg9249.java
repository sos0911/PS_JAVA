package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg9249 {
    
    public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine(), B = br.readLine();
        int Alen = A.length(), Blen = B.length(), max = 0;
        int[][] LCS = new int[Alen+1][Blen+1];
        for(int i = 1; i <= Alen; i++)
            for(int j = 1; j <= Blen; j++)
                if(A.charAt(i-1) == B.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    if(LCS[i][j] > max)
                 max = LCS[i][j];
                }
                // 같지 않다면 0이 기입됨.
        System.out.println(max);
    }
}
