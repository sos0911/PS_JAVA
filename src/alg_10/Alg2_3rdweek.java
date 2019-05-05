package alg_10;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class segmenttree{
    private int[] Tree;
    
    public segmenttree(int N){
         int temp = N;
        int temp2 = 1;
        while(temp > 1){
            temp = temp >> 1;
            temp2 = temp2 << 1;
        }
        Tree = new int[temp2 << 2]; // tree[] 크기 배정 
    }
    
    int init(int val, int node, int start, int end){ // initiaion segment tree
        if(start == end)
            return Tree[node] = val;
        else
            return Tree[node] = init(val, node*2, start, (start+end)/2) + init(val, node*2+1, (start+end)/2 + 1, end);
    }
    
    void update(int node, int start, int end, int index, int diff){ // start-end는 그 node가 담당하는 구역
        if(index < start || index > end)
            return;
        Tree[node] += diff;
        if(start != end){
            update(node*2, start, (start+end)/2, index, diff);
             update(node*2+1, (start+end)/2 + 1, end, index, diff);
        }
    }
    
    int sum(int node, int start, int end, int left, int right){ // left-right는 찾아야 할 부분합의 구역
        if(left > end || right < start) // 찾는 구역이 이 노드 범위 내에 없음
            return 0;
        if(left <= start && right >= end) // 찾는 구역이 이 노드 범위를 완전히 포함함
            return Tree[node];
            
        return sum(node*2, start, (start+end)/2, left, right) +  sum(node*2+1, (start+end)/2 + 1, end, left, right); // 찾는 구역이 이 노드의 범위에 완전히 포함되거나 걸치는 경우
    }
    
    int query(int val, int node, int start, int end){
        if(start == end)
            return start;
        if(Tree[node*2] >= val)
            return query(val, node*2, start, (start+end)/2);
        else
            return query(val-Tree[node*2], node*2+1, (start+end)/2 + 1, end);
    }
}

public class Alg2_3rdweek {
    
    public static void main(String[] args)throws IOException{
         Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] answer = new int[N+1]; // 1 - n까지 저장

        segmenttree st = new segmenttree(N);
        st.init(1, 1, 1, N); // segment tree의 leap node의 값을 모두 1로 조정(아직 거쳐가지 않았다는 의미의 1)
        int mod = N-1;
        int temp = M; // 각 단계마다의 답을 저장하는 변수
        answer[1] = temp;
        st.update(1, 1, N, M, -1); // 1을 0으로
        for(int i = 2; i < N+1; i++){
            int x = (st.sum(1, 1, N, 1, temp) + M) % mod;
            if(x == 0)
                x = mod;
            temp = st.query(x, 1, 1, N);
        answer[i] = temp;
            st.update(1, 1, N, temp, -1);
            mod--;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        bw.flush();
        for(int i = 1; i < N+1; i++){
            if(i == 1)
                bw.write("" + answer[i]);
            else
            bw.write(", " + answer[i]);
        bw.flush();
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
