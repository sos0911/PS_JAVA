package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg10448 {
    // 시도는 좋은 시도에요. 앞에 두 개 조합 + bins인데
    // 어차피 시간 제한이 1초여서 3중for문도 되었는데 너무 깊게 생각했어요.
    static int[] st; // t1 - t45 저장
    static int[] selected = new int[2]; // 선택된 두 삼각수
    static int lim; // 상한수
    public static void main(String[] args) throws IOException{
    // 이분 탐색?
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Noft = Integer.parseInt(br.readLine());
        st = new int[46]; // 1 - 45(T[45] > 1000)
        st[1] = 1;
        for(int i = 2; i <= 45; i++)
            st[i] = st[i-1] + i;
        for(int i = 0; i < Noft; i++){
            int N = Integer.parseInt(br.readLine());
            lim = binsearch(N);
            if(Ispossi(N, 0, 1))
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.close();
    }
    static boolean Ispossi(int n, int sel, int stI){ // n이 3개 삼각수 합으로 표현되는지 판단
        // sel : 지금까지 고른 삼각수 수 , stI : 고를 수 있는 삼각수의 시작 i
        if(sel == 2){
            if(st[binsearch(n - selected[0] - selected[1])] == n - selected[0] - selected[1])
                return true;
         return false;   
        }
        for(int i = stI; i <= lim; i++){
            selected[sel] = st[i];
         if(Ispossi(n, sel+1, stI))
             return true;
        }
        return false;
    }
    static int binsearch(int n){ // n이 tn[]에서 있으면 index를, 아니면 +- index 반환
        int mid;
        int lo = 1, hi = 45;
        while(hi >= lo){
            mid = (lo+hi)/2;
            if(n == st[mid])
                return mid;
            if(n > st[mid])
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}
