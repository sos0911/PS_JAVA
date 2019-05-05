package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg16719 {
    static StringBuilder sb = new StringBuilder(); // 출력 문자열
    static String input;
    static boolean[] visited;
    static int len = -1;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        len = input.length();
        visited = new boolean[len]; // 0 - len-1
        findC(-1, 0);
        bw.close();
    }
    static void findC(int lastI, int insI) throws IOException{ // lastI 이후에서 가장 사전순으로 빠른 알파벳을 찾아 insI에 추가시킴 
        while(true){ // 뒤로 다 방문할 때까지 돌림
             char tar = 'a'; int tarI = -1;
            for(int i = lastI+1; i < len; i++)
            if(!visited[i] && input.charAt(i) < tar){ // 아직 안써먹었고 가장 사전순으로 빠르면 추가
            tar = input.charAt(i);
            tarI = i;
        }
        if(tarI != -1){ // 추가할 알파벳을 찾은 경우
        sb.insert(insI, tar);
        bw.write(sb.toString() + "\n");
        visited[tarI] = true;
        findC(tarI, insI+1);
        }
        else
            break;
    }
    }
}
