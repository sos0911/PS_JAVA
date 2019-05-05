package alg_03_2019;
import java.io.*;
import java.util.*;
class pair{
    int idx, val; // lcs[] 내 위치했거나 위치한 index와 val 저장
    public pair(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}
public class Alg14002 {
    // NlogN 해결방법 = 2천만정도
    // ㅅㅂ 스택에다 넣을거야
    static int[] lcs;
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        lcs = new int[N]; // LCS 최대 길이는 백만
        // index 0부터 사용
        // LCS 길이는 index
        StringTokenizer st = new StringTokenizer(br.readLine());
        pair[] trail = new pair[N]; // 0 - N-1
        int temp, index = 0;
        lcs[0] = Integer.parseInt(st.nextToken()); // 초기값 세팅
        trail[0] = new pair(0, lcs[0]);
        for(int i = 1; i < N; i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp > lcs[index]){
               lcs[++index] = temp;
             trail[i] = new pair(index, temp);   
            }
            else{
                int next = bins(index, temp);
                lcs[next] = temp;
                trail[i] = new pair(next, temp);   
            }
        }
        // lcs 길이는 index+1
        Stack<Integer> ans = new Stack<Integer>();
        int ind = index;
        bw.write((index+1) + "\n");
        while(ind >= 0)
        for(int i = N-1; i >= 0; i--)
            if(trail[i].idx == ind){
                ans.push(trail[i].val);
                ind--;
            }
        while(!ans.isEmpty())
            bw.write(ans.pop() + " ");
        bw.close();
    }
    static int bins(int hi, int tar){ // tar 찾으면 index 반환 or 못 찾으면 lo반환
        // lcs[]는 순증가 수열
        int lo = 0, mid;
        while(lo <= hi){
            mid = (lo+hi)/2;
            if(tar == lcs[mid])
                return mid;
            if(tar > lcs[mid])
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}
