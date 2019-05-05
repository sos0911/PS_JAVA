package alg_02_2019;
import java.util.*;
public class Alg1094 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), sum = 64, min = 64, Nofs = 1;// x, 소유한 막대 길이의 총합, 가장 짧은 막대기 길이, 막대기 개수
        while(sum != x){
            if((sum -= min/2) < x){ // 막대기 수 1 증가
                 sum += min/2; 
                 Nofs++;   
            }
            // x보다 크면 sum은 min/2만큼 줄어듦
            min /= 2;
        }
        System.out.println(Nofs);
    }
}
