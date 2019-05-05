package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg11728 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arrn = new int[N]; // 0 - 
        int[] arrm = new int[M]; // 0 - 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arrn[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            arrm[i] = Integer.parseInt(st.nextToken());
        int in = 0, im = 0; // index
        while(in < N && im < M){
            if(arrn[in] > arrm[im])
                bw.write(arrm[im++] + " ");
            else // arrn[in] <= arrm[im]
                bw.write(arrn[in++] + " ");
        }
       if(in < N)
           for(int i = in; i < N; i++)
               bw.write(arrn[i] + " ");
        if(im < M)
             for(int i = im; i < M; i++)
               bw.write(arrm[i] + " ");
        bw.close();
    }
}
