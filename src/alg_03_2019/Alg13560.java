package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg13560 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
      int[] input = new int[N]; // index 0 - 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input); // 오름차순 정렬
        int sum = 0; boolean IsE = false;
        for(int i = 0; i < N-1; i++)
            if((sum += input[i]) < (i+1)*i/2){
                IsE = true;
                break;
            }
        if(!IsE && (sum += input[N-1]) == N*(N-1)/2)
            System.out.println(1);
        else
            System.out.println(-1);
    }
}
