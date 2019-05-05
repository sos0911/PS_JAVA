package alg_03_2019;
import java.util.*;
import java.io.*;

public class Alg10769 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String H = br.readLine();
        String[] imo = {":-)", ":-("};
        int hsize = H.length(), nsize = 3;
        // pi[]는 모두 0이므로 선언x
        // 이 경우 시간복잡도는..?
        int[] answer = new int[2]; // 답 저장 배열
        for(int i = 0; i < 2; i++){ // 각 이모티콘에 대해 수행
            String N = imo[i];
            int begin = 0, matched = 0;
        while(begin < hsize - nsize){
            if(matched < nsize && H.charAt(begin + matched) == N.charAt(matched)){
                matched++;
                if(matched == nsize)
                    answer[i]++;
            }
            else{
                if(matched == 0)
                    begin++;
                else{
                    begin += matched;
                    matched = 0;
                }
            }   
        }
        }
        if(answer[0] == 0 && answer[1] == 0)
            System.out.println("none");
        else if(answer[0] > answer[1])
            System.out.println("happy");
        else if(answer[0] < answer[1])
            System.out.println("sad");
        else
            System.out.println("unsure");
    }
}
