package backjoonalg;
import java.util.Scanner;
import java.lang.*;
public class Alg1252 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder(90);
        String[] ab = sc.nextLine().split(" ");
        String a = ab[0].replaceAll("^0+", "");
        String b = ab[1].replaceAll("^0+", "");
        int alen = a.length(), blen = b.length();
        if(alen == 0 && blen == 0){
            System.out.println("0");
         return;   
        }
        int diff = alen - blen, maxL;
            if(diff > 0){ // b가 짧음
                maxL = a.length();
                for(int i = 0; i < Math.abs(diff); i++)
                    b = "0".concat(b);
            }
            else{
                maxL = b.length();
                 for(int i = 0; i < Math.abs(diff); i++)
                    a = "0".concat(a);
            } // 자리 맞추기 완료
        int carry = 0, tempsum; // 자리올림수
        for(int i = maxL-1; i >= 0; i--){
            tempsum = carry + (a.charAt(i) - '0') + (b.charAt(i) - '0');
            if(tempsum < 2){
                answer.insert(0, tempsum);
                 carry = 0;   
            }
            else{
                answer.insert(0, tempsum % 2);
                carry = 1;
            }
        }
        if(carry == 1)
            answer.insert(0, 1);
     System.out.println(answer.toString());   
    }
}
