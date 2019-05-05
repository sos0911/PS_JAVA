package alg_10;
import java.util.Arrays;
import java.util.Scanner;

public class Alg1_4thweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofinput = Integer.parseInt(sc.nextLine());
        int[] inputs = new int[Nofinput];
      
        for(int i = 0; i < Nofinput; i++)
            inputs[i] = Integer.parseInt(sc.nextLine());
        
        Arrays.sort(inputs);
        for(int i = 0; i < Nofinput; i++)
            inputs[i] *= (Nofinput-i);
        
        int max = -1;
        for(int i = 0; i < Nofinput; i++)
            if(inputs[i] > max)
                max = inputs[i];
        
        System.out.println(max);
    }
}
