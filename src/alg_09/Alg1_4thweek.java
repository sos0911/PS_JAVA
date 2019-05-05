package alg_09;
import java.util.Scanner;

public class Alg1_4thweek {
    
   static boolean IStherePPAP(int t, char[] finalanswer){
        if(t < 4)
            return false;
        else{
            if(finalanswer[t-4] == 'P' && finalanswer[t-3] == 'P' && finalanswer[t-2] == 'A' && finalanswer[t-1] == 'P')
                return true;
            else{
                return false;
            }
        }
    }
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();
        char[] finalanswer = new char[1000004];
        String input = sc.nextLine();
        int t = 0;
        for(int i = 0; i < input.length(); i++){
            
            while(IStherePPAP(t, finalanswer)){
            t -= 3;
            // finalanswer[t] = 'P';
            }
              finalanswer[t] = input.charAt(i);
             t++;
        }
        while(IStherePPAP(t, finalanswer)){
            t -= 3;
        }
        
      if(finalanswer[0] == 'P' && t == 1)
          System.out.println("PPAP");
        else{
            System.out.println("NP");
        }
        
    }
}