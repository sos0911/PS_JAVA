package alg_12;
import java.util.Scanner;

public class Alg1_4thweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] Nof2018 = new int[10]; // 0 - 9
        int[] S2018 = {2, 0, 1, 8};
        String input = sc.nextLine();
        for(int i = 0; i < input.length(); i++)
            Nof2018[input.charAt(i) - '0']++;
        boolean outIsrel = true;
       for(int i = 0; i < 10; i++){
            boolean Isrel = false;
           if(Nof2018[i] != 0){
               for(int j = 0; j < 4; j++)
                   if(i == S2018[j])
                   Isrel = true;    
                   }
           if(!Isrel && Nof2018[i] != 0){
               outIsrel = false;
               break;
           }
       }
        if(!outIsrel){
            System.out.println("0");
         return;   
        }
       for(int j : S2018)
           if(Nof2018[j] == 0){
               System.out.println("1");
            return;   
           }
        int NofN = Nof2018[2];
        for(int j = 1; j < 4; j++)
            if(Nof2018[S2018[j]] != NofN){
                System.out.println("2");
             return;   
            }
        System.out.println("8");
    }
}
