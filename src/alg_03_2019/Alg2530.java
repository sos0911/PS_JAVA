package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg2530 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int add = Integer.parseInt(br.readLine());
        b += (c+add)/60; c = (c+add)%60;
        a += b/60; b %= 60;
        a %= 24;
        System.out.println(a + " " + b + " " + c);
    }
}
