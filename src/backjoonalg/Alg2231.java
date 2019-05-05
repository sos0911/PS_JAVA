package backjoonalg;
import java.util.*;
import java.lang.*;

public class Alg2231 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length(), N = Integer.parseInt(input);
        //StringBuilder stand = new StringBuilder(String.valueOf(N-9*len)); // 요놈을 1씩 증가시켜 갈거임 (~N)
        boolean Findans = false;
       for(int i = N-9*(len); i < N; i++){
           int tempsum = i;
           String temp = String.valueOf(i);
           for(int j = 0; j < temp.length(); j++)
               tempsum += temp.charAt(j) - '0';
           if(tempsum == N){
               System.out.println(i);
               Findans = true;
               break;
           }
       }
        if(!Findans)
            System.out.println("0");
    }
}
