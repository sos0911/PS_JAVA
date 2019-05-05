package backjoonalg;
import java.util.*;

public class Alg2309 {
    static int[] answer = new int[7]; // 일곱 난쟁이의 키
    static int[] heights;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        heights = new int[9];
        for(int i = 0; i < 9; i++)
            heights[i] = sc.nextInt();
        Arrays.sort(heights);
        FindSet(0, -1);
    }
    static int FindSet(int Nofp, int lastI){ // 지금까지 찾은 사람 수 / 오름차순으로 조합 세팅
        if(Nofp == 7){
            int tempsum = 0;
            for(int i : answer)
                tempsum += i;
            if(tempsum == 100){
                for(int i : answer)
                    System.out.println(i);
             return 0; // 정답 발견   
            }
         return -1;   
        }
        for(int i = lastI+1; i < 9; i++){
            answer[Nofp] = heights[i];
            if(FindSet(Nofp+1, i) == 0)
                return 0;
        }
        return -1;
    }
}
