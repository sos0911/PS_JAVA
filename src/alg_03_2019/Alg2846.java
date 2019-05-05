package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg2846 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b;
        int max = -1, temp = 0;
        for(int i = 0; i < N-1; i++){
            b = Integer.parseInt(st.nextToken());
            if(a < b)
                temp += b-a;
            else{
                max = Math.max(max, temp);
                temp = 0;
            }
            a = b;
        }
        if(max != -1)
        System.out.println(Math.max(max, temp));
        else
            System.out.println(0);
    }
}
