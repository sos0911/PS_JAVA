package backjoonalg;
import java.util.Scanner;
import java.lang.*;
public class Alg2998 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder answer = new StringBuilder(35);
        String[] standS = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int[] standI = {0, 1, 2, 3, 4, 5, 6, 7};
        int len = input.length();
        if(len % 3 == 1)
            input = "00".concat(input);
        else if(len % 3 == 2)
            input = "0".concat(input);
        String temp;
        len = input.length(); // 갱신
        for(int i = 0; i < len; i += 3){
            temp = input.substring(i, i+3);
            for(int j = 0; j < 8; j++)
                if(temp.equals(standS[j])){
                    answer.append(standI[j]);
                    break;
                }
        }
        System.out.println(answer.toString());
    }
}
