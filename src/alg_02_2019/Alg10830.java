package alg_02_2019;
import java.io.*;
import java.util.*;
public class Alg10830 {
    static int N;
    static long B;
    static int[][] input, answer; //행렬 A, 결과 행렬
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        input = new int[N][N];
        for(int i = 0; i < N; i++){ // 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                input[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = Makepow(B);
        for(int[] arr : answer){
            for(int a : arr)
                bw.write(a%1000 + " ");
         bw.newLine();   
        }
        bw.close();
    }
    static int[][] Makepow(long rep){ // A*B 결과를 answer에 저장하여 참조값 return
        int[][] answer, temp;
        if(rep == 1)
         return answer = input;
         temp = Makepow(rep/2); // 이 시점에서 temp에 수행 결과 저장
        if(rep % 2 == 0)
         answer = Makepromul(temp, temp);
        else
            answer = Makepromul(Makepromul(temp, temp), input);
        return answer;
    }
    static int[][] Makepromul(int[][] A, int[][] B){ // A*B 결과행렬 참조값을 return
        int[][] answer = new int[N][N]; 
        for(int i = 0; i < N; i++)
              for(int j = 0; j < N; j++){
                  for(int k = 0; k < N; k++)
                      answer[i][j] += (A[i][k]*B[k][j])%1000;
               answer[i][j] %= 1000;   
              }
        return answer;
    }
    }
