package SecondTry;
import java.io.*;
import java.util.*;
public class Alg1920 {
    static int N, M;
    static int[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        input = new int[N]; // index 0-
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++)
            bw.write(binaryS(Integer.parseInt(st.nextToken())) + "\n");
        bw.close();
    }
    static int binaryS(int tar){
        int lo = 0, hi = N-1, mid;
        while(hi >= lo){
            mid = (lo + hi)/2;
            if(tar == input[mid])
                return 1;
            if(tar > input[mid])
                lo = mid+1;
            else
                hi = mid-1;
        }
        return 0;
    }
}
