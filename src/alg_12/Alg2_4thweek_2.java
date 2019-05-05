package alg_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg2_4thweek_2 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NofCon = Integer.parseInt(br.readLine());
        int[] HonVofCon = new int[NofCon]; 
        for(int i = 0; i < NofCon; i++)
         HonVofCon[i] = Integer.parseInt(br.readLine());
        Arrays.sort(HonVofCon); // 오름차순 정렬. 어차피 [0]은 0이다
        long NofH = 0; // 필요한 해커의 수
        int fori = 1; // for문 index
        int i = 0;
          while(i < NofCon){
              if(HonVofCon[i] > fori)
                  NofH += HonVofCon[i] - fori; // 이제 fori가 생겼다.  
              else{
                while(i < NofCon-1 && HonVofCon[i] == HonVofCon[i+1])
                     i++;
                  if(i == NofCon-1)
                      break;
              }
              i++;
              fori++;
          }
        System.out.println(NofH);
    }
}
