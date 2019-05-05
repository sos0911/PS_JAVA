package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg3047 {
    
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        String order = br.readLine();
        for(int i = 0; i < 3; i++)
            System.out.print(input[order.charAt(i) - 'A'] + " ");
    }
}
