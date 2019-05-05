package alg_10;
import java.util.Scanner;

public class Alg3_3rdweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 1;
        for(int i = 2; i < N+1; i++){
            answer = (answer + M) % i;
         if(answer == 0)
             answer = i;
        }
        
        System.out.println(answer);
    }
}
