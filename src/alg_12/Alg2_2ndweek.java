package alg_12;
import java.util.Scanner;

public class Alg2_2ndweek { 
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofsticks = sc.nextInt();
        int Wofbox = sc.nextInt();
         int Hofbox = sc.nextInt();
        for(int i = 0; i < Nofsticks; i++){
            sc.nextLine();
            if((double)sc.nextInt() <= Math.sqrt((double)(Wofbox*Wofbox) + (Hofbox*Hofbox)))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}
