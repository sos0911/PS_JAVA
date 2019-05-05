package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder(); // 답 문자열 저장
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String st;
        for(int i = 0; i < N; i++){
        st = br.readLine();
         for(int j = 0; j < N; j++)
             map[i][j] = st.charAt(j) - '0';
        }
        div(0, 0, N);
        System.out.println(sb.toString());
    }
    static void div(int y, int x, int len){ // (y,x)부터 시작해서 아래, 오른쪽 len크기만큼 검사
    int stN = map[y][x]; boolean Isunited = true; // 해당 면적이 모두 통일되었는가?
        outerloop:
    for(int i = y; i < y+len; i++)
        for(int j = x; j < x+len; j++)
            if(map[i][j] != stN){
                Isunited = false;
                sb.append("(");
                div(y, x, len/2);
                div(y, x+len/2, len/2);
                div(y+len/2, x, len/2);
                div(y+len/2, x+len/2, len/2);
                sb.append(")");
                break outerloop;
            }
        if(Isunited)
            sb.append(stN);
    }
}
