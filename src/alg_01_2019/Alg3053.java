package alg_01_2019;
import java.util.*;
public class Alg3053 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double PI = 3.14159265358979;
        double R = sc.nextDouble();
        System.out.printf("%.6f\n", R*R*PI);
        System.out.printf("%.6f\n", Math.pow(2*R, 2)/2);
    }
}
