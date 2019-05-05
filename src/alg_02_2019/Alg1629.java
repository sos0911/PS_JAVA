package alg_02_2019;
import java.util.*;
public class Alg1629 {
    static int A, B, C;
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.println(Makepow(B));
    }
    static long Makepow(int rep){
        if(rep == 1)
            return A%C;
        long temp = Makepow(rep/2);
        if(rep % 2 != 0)
            return (((temp*temp)%C)*(A%C))%C;
        else
            return (temp*temp)%C;
    }
}
