package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg1786 {
    
    public static void main(String[] args) throws IOException{
        // 시간 복잡도 : O(H.size)
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String H = br.readLine(); // haystack
        String N = br.readLine(); // needle
        int hsize = H.length(), nsize = N.length();
        // 일단 pi[]를 구현할 것임
        int[] pi = new int[nsize];
        // pi : N[..index i]까지 볼 때 접두사와 접미사가 동시에 가능한 문자열의 최대 길이
        // pi[0]은 무조건 0
        int begin = 1, matched = 0;
        // begin = 0으로 시작하면 pi[]가 등차수열이 되어버림(자기 자신밖에 못찾음)
        // kmp로 자기 자신 N을 N에서 찾음
        while(begin + matched < nsize){ // 비교 대상은 범위 내에 있어야 하니까
            if(N.charAt(begin + matched) == N.charAt(matched)){
                matched++;
                pi[begin+matched-1] = matched;
            }
            else{
                if(matched == 0)
                    begin++;
                else{
                    // matched = 1일때 요기 들어오면 상황이 0인 것과 동일
                    begin += matched - pi[matched-1]; // 가능한 첫 위치로 begin을 옮김
                    matched = pi[matched-1]; // 겹쳤던 부분만큼 이미 일치하므로 
                }
            }
        }
        // 전처리가 다 되었으므로 kmp를 시행한다.
        int answer = 0; // 출현 빈도수
        ArrayList<Integer> pos = new ArrayList<Integer>(hsize); // 답 위치들
        begin = 0; matched = 0;
        while(begin <= hsize-nsize){
            // matched == nsize가 될 떄까지만 찾아야 하므로 if문에 조건문 추가
            if(matched < nsize && H.charAt(begin + matched) == N.charAt(matched)){
                matched++;
                if(matched == nsize){ // 답이 나옴
                    answer++;
                    pos.add(begin+1);
                }
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
        for(int i : pos)
            bw.write(i + " ");
        bw.close();
    }
}
