package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11319 {
    
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26]; // a - z
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            int len = temp.length();
            char temp2;
            for(int j = 0; j < len; j++)
                if((temp2 = temp.charAt(j)) >= 'A'){
                if((temp2 = temp.charAt(j)) >= 'a')
                    alpha[temp2 - 'a']++;
                else
                    alpha[temp2 - 'A']++;
                }
            int con = 0, vow = 0;
            for(int j = 0; j < 26; j++)
                if(j == 'a' - 'a' || j == 'e' - 'a' || j == 'i' - 'a' || j == 'o' - 'a' || j == 'u' - 'a')
                    vow += alpha[j];
                else
                    con += alpha[j];
            bw.write(con + " " + vow + "\n");
            Arrays.fill(alpha, 0);
        }
        bw.close();
    }
}
