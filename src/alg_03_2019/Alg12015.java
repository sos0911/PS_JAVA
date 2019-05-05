package alg_03_2019;
import java.io.*;
import java.util.*;
class node12015{
    int val;
    node12015 parent;
    public node12015(int val, node12015 parent){
        this.val = val;
        this.parent = parent;
    }
}
public class Alg12015 {
    // NlogN 해결방법 = 2천만정도
    // reverse tracking을 위한 tree 만들기
    static node12015[] lcs;
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        lcs = new node12015[N]; // LCS 최대 길이는 백만
        // index 0부터 사용
        // LCS 길이는 index
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp, index = 0;
        lcs[0] = new node12015(Integer.parseInt(st.nextToken()), null); // 초기값 세팅 null 가능?
        for(int i = 1; i < N; i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp > lcs[index].val)
               lcs[++index] = new node12015(temp, lcs[index-1]); // 되려나?
            else{
                int next = bins(index, temp);
                lcs[next] = new node12015(temp, lcs[next].parent); // 되려나?
            }
        }
        node12015 rep = lcs[index]; // 가장 마지막에 추가된 원소
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(" " + rep.val);
        }
        while(rep.parent != null);
        bw.write(sb.reverse().toString());
        bw.close();
    }
    static int bins(int hi, int tar){ // tar 찾으면 index 반환 or 못 찾으면 lo반환
        // lcs[]는 순증가 수열
        int lo = 0, mid;
        while(lo <= hi){
            mid = (lo+hi)/2;
            if(tar == lcs[mid].val)
                return mid;
            if(tar > lcs[mid].val)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}
