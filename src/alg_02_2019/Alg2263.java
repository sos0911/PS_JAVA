package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg2263 {
    static int[] post, in, pos; // postorder, inorder / pos는 각 i의 in[] 내 위치 저장
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        post = new int[N+1];
        in = new int[N+1]; // index 1 - 
        pos = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            in[i] = Integer.parseInt(st.nextToken());
            pos[in[i]] = i;   
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++)
            post[i] = Integer.parseInt(st.nextToken());
        postorder(1, N, 1, N);
        bw.close();
    }
    static void postorder(int inlo, int inhi, int postlo, int posthi) throws IOException{
        if(postlo > posthi)
            return;
        int root = post[posthi]; // root는 post의 끝
        bw.write(root + " ");
        int ls = pos[root]-inlo; 
        postorder(inlo, inlo+ls-1, postlo, postlo+ls-1);
        postorder(inlo+ls+1, inhi, postlo+ls, posthi-1);
    }
}
