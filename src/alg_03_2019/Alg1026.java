package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1026 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N]; 
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            b[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        Arrays.sort(b);
        int answer = 0;
        for(int i = 0; i < N; i++)
            answer += a[i]*b[N-1-i];
        System.out.println(answer);
    }
}
