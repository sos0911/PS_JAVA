package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg5525 {
    // 시간 복잡도 : O(nsize + hsize)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder N = new StringBuilder("I");
        int nsize = 1;
        for(int i = 0; i < n; i++){
            N.append("OI"); // 가장 뒤에 붙임
            nsize += 2;
        }
        int hsize = Integer.parseInt(br.readLine());
        String H = br.readLine();
        int[] pi = new int[nsize]; // 0부터 사용
        // pi[0] = 0
        int begin = 1, matched = 0; // ㅇ
        while(begin + matched < nsize){
            // matched : 지금까지 일치한 글자 수
            if(N.charAt(begin + matched) == N.charAt(matched)){
                matched++;
                pi[begin + matched - 1] = matched;
            }
            else{
                if(matched == 0)
                    begin++;
                else{
                    begin += matched - pi[matched-1]; // 일치한 자리수에서 pi만큼 뺀 수치만큼 시작 위치를 이동시킴
                    // matched = m이 출현한 경우 pi[m-1]까지는 적어도 계산이 이미 되어 있음
                    matched = pi[matched-1]; // 이동 후에도 앞 자리에서 pi만큼 이미 겹침
                }
            }
        }
        // 이제 kmp 시행
        int answer = 0;
        begin = 0; matched = 0; // 이제 자기 자신을 찾아도 무방
        while(begin < hsize - nsize){
            if(matched < nsize && H.charAt(begin + matched) == N.charAt(matched)){
                matched++;
             if(matched == nsize) // 답 출현
                 answer++;
            }
            else{
                if(matched == 0)
                    begin++;
                else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        System.out.println(answer);
    }
}
