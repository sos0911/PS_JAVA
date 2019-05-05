package alg_02_2019;
import java.util.*;
public class Alg1057 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofp = sc.nextInt();
        int An = sc.nextInt(), Bn = sc.nextInt(), round = 1; // 라운드 수
        while(true){
            if(Math.abs(An-Bn) == 1){
                if(An > Bn && Bn%2 == 1)
                    break;
                else if(An < Bn && An%2 == 1)
                    break;
            }
            An = (An%2 == 0? An/2 : An/2 + 1);
            Bn = (Bn%2 == 0? Bn/2 : Bn/2 + 1);
            Nofp = (Nofp%2 == 0? Nofp/2 : Nofp/2 + 1);
            round++;
        }
        System.out.println(round);
    }
}
