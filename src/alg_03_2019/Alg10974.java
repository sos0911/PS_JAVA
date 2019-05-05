package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg10974 {
    // 비트마스크로 해도 되지만 ㅈㄴ 귀찮
    static int[] ans;
    static boolean[] visited;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N]; // 0 -
        visited = new boolean[N+1]; // 1 -
        generator(-1);
        bw.close();
    }
    static void generator(int lastI) throws IOException{
        if(lastI == N-1){
            for(int i : ans)
                bw.write(i + " ");
            bw.newLine();
         return;   
        }
        for(int i = 1; i < N+1; i++)
            if(!visited[i]){
                ans[lastI+1] = i;
                visited[i] = true;
                generator(lastI+1);
                visited[i] = false;
            }
    }
}
