package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg11004 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]); 
        int K = Integer.parseInt(temp[1]); 
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        System.out.println(input[K-1]);
    }
}
