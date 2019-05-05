package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1296 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26]; // a - z
        int[] inalpha = new int[26];
        String alp = br.readLine();
        for(int i = 0; i < alp.length(); i++)
            alpha[alp.charAt(i) - 'A']++;
        int al = alpha['L' - 'A'], ao = alpha['O' - 'A'], av = alpha['V' - 'A'], ae = alpha['E' - 'A'];
        int ansI = -1;
        int ans = -1, tempa;
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for(int i = 0; i < N; i++)
            input[i] = br.readLine();
        Arrays.sort(input); // string 사전순 정렬
        for(int i = 0; i < N; i++){
           String temp = input[i];
            for(int j = 0; j < temp.length(); j++)
                inalpha[temp.charAt(j) - 'A']++;
             int ial = inalpha['L' - 'A'] + al, iao = inalpha['O' - 'A'] + ao, iav = inalpha['V' - 'A'] + av, iae = inalpha['E' - 'A'] + ae;
            if((tempa = ((ial+iao)*(ial+iav)*(ial+iae)*(iao+iav)*(iao+iae)*(iav+iae))%100) > ans){
                ans = tempa;
                ansI = i;
            }
            Arrays.fill(inalpha, 0); // 초기화
        }
        System.out.println(input[ansI]);
    }
}
