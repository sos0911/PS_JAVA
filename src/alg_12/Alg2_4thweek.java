package alg_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg2_4thweek {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NofCon = Integer.parseInt(br.readLine());
        int[] HonVofCon = new int[NofCon+1]; // index 1부터
        int[] CheckN = new int[100001]; // index에 해당하는 수가 얼마나 있는가?
        int temp;
        for(int i = 1; i < NofCon+1; i++){
            temp = Integer.parseInt(br.readLine());
            HonVofCon[i] = temp;
            CheckN[temp]++;
        }
        Arrays.sort(HonVofCon); // 오름차순 정렬. 어차피 [0]은 0이다
        int NofH = 0; // 필요한 해커의 수
        int fori = 1; // for문 index
        for(int i = 1; i < NofCon+1; i++)
            if(CheckN[i] == 0){
                while(fori < NofCon+1 && HonVofCon[fori] < i)
                    fori++;
                  if(fori == NofCon+1) // 볼 수 있는 건 다 봄
                    break;
                if(HonVofCon[fori] == i){ // 찾으려 했던 숫자가 존재
                    while(fori < NofCon+1 && HonVofCon[fori] == i)
                        fori++;
                    continue;
                }
                NofH += HonVofCon[fori] - i;
                CheckN[HonVofCon[fori]]--; // 원래 숫자가 i로 내려갔으므로
                fori++;
            }
        System.out.println(NofH);
    }
}


/*
1 1 1 4 8 10 10 15 15 15

1 2 3 4 5 6 7 8 9 10 > 1 2 3 4 3 7 6 5 >> 31
1 1 1 2 3 4 5 6 7 8 > 2 5 6 5 9 8 7 >> 42
*/