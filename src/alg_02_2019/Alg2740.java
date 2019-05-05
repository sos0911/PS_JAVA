package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg2740 {
    static int[][] A, B, C;
    static int N, M, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for(int i = 0; i < N; i++){ // A 받음
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
         M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
          for(int i = 0; i < M; i++){ // B 받음
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }
        C = new int[N][K]; // 정답 배열
        for(int i = 0; i < N; i++)
            for(int j = 0; j < K; j++)
                makeres(i, j); // C의 (i,j)를 만듦
        for(int[] arr : C){
            for(int i : arr)
                bw.write(i + " ");
            bw.newLine();
        }
        bw.close();
    }
    static void makeres(int y, int x){
        for(int i = 0; i < M; i++)
            C[y][x] += A[y][i]*B[i][x]; 
    }
}
