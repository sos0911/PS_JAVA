package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1062 {
    static String[] input; 
    static int reK, Tanswer = 0, N, K; // rek : 배울 수 있는 알파벳 수(접미접두 빼고)
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K < 5){
            System.out.println(0);
            return;
        }
        reK = K - 5;
        input = new String[N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            temp = temp.replaceAll("a", "");
             temp = temp.replaceAll("n", "");
             temp = temp.replaceAll("t", "");
             temp = temp.replaceAll("i", "");
             temp = temp.replaceAll("c", "");
            input[i] = temp;
        }
        comb(0, 0, 0);
        System.out.println(Tanswer);
    }
    static void comb(int cnt, int learn, int stI){
        // stI : 지금 써먹을 알파벳 index
        if(stI > 26)
            return;
        if(cnt == reK){ // 정해진 갯수를 채웠거나 사용 가능한 알파벳 수에 도달
        int answer = 0;
            for(int i = 0; i < N; i++){
                boolean check = true;
                for(int j = 0; j < input[i].length(); j++) // string이 비어도 성립
                    if((learn & (1 << (input[i].charAt(j) - 'a'))) == 0){
                        check = false;
                        break;
                    }
                if(check)
                    answer++;
                    }
         Tanswer = Math.max(Tanswer, answer);  
            return;
        }
        if(stI == 'a' - 'a' || stI == 'n' - 'a' || stI == 't' - 'a' || stI == 'i' - 'a' || stI == 'c' - 'a')
            comb(cnt, learn, stI+1); // 안 써먹어야 함
        else{
            comb(cnt+1, learn + (1 << (stI)), stI+1); // 써먹음
                comb(cnt, learn, stI+1); // 안써먹음
        }
    }
}