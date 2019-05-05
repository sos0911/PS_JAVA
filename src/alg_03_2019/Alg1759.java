package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1759 {
    static char[] input; // input 배열
    static char[] answer; // 답 배열
    static int L, C;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        // 이거 백트래킹 사용 가능??
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C]; // 0부터 
        answer = new char[L];
           String temp = br.readLine();
        for(int i = 0; i < C; i++)
            input[i] = temp.charAt(i*2);
        Arrays.sort(input);
        back(0, 0, 0, 0);
        bw.close();
    }
    static void back(int ist, int ast, int Nofv, int Nofc) throws IOException{ // input 시작 / answer 시작, 자음, 모음
        if(ast == L){
            if(Nofc >= 1 && Nofv >= 2){ // 조건 만족할 경우 출력
            for(char c : answer)
                bw.write(c); // char형 p 가능?
         bw.newLine();
            }
            return;
        }
        for(int i = ist; i < C; i++){
            answer[ast] = input[i];
            if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u')
            back(i+1, ast+1, Nofv, Nofc+1);
            else
                back(i+1, ast+1, Nofv+1, Nofc);
        }
    }
}
