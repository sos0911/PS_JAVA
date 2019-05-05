package alg_10;
import java.util.Scanner;

public class Alg1_1stweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        int Nofpieces = 0, Nofnotendsticks = 0;
        int i;
        for(i = 1; i < input.length(); i++){ // 첫 입력은 무조건 (
            if(i == 1){
                if(input.charAt(i) == ')'){ // ()
                    i++;
                    continue;
                }
            else{ // ((
               Nofnotendsticks++;
                continue;
            }
            }
               
            if(input.charAt(i-1) == '('){ // i != 1 / charAt[i-1]을 매 단계마다 검사
                if(input.charAt(i) == ')'){
                    Nofpieces += Nofnotendsticks;
                    i++;
                }
                else// ((
                   Nofnotendsticks++;
            }
            else{ // )
                Nofnotendsticks--; // ))이든 )(이든 charAt[i-1]시점에서 1개가 끝남
                Nofpieces++;
            }
        }
        
        if(i == input.length())
            Nofpieces++;
        
        System.out.println(Nofpieces); 
    }
}
