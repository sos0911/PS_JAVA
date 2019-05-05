package alg_01_2019;
import java.util.*;
public class Alg2455 {
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        int sum = 0, max = -1;
        for(int i = 0; i < 4; i++){
            sum -= sc.nextInt();
            sum += sc.nextInt();
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
