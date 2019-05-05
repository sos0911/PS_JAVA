package SecondTry;
import java.io.*;
import java.util.*;
public class Alg1107 { 
    static int[] malf;
    static int BigN = 1500000;
    public static void main(String[] args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int des = Integer.parseInt(br.readLine());
        int Nofmal = Integer.parseInt(br.readLine());
        if(Nofmal == 0){ 
            System.out.println(Math.min(String.valueOf(des).length(),  Math.abs(des - 100)));
         return;   
        }
        if(Nofmal == 10){
            System.out.println(Math.abs(des - 100));
            return;
        }
        malf = new int[Nofmal];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < Nofmal; i++)
            malf[i] = Integer.parseInt(temp[i]);
       int answer = Math.abs(des - 100);
        for(int i = 0; i <= 1000000; i++)
                answer = Math.min(answer, Ispossi(i) + Math.abs(des - i));
        System.out.println(answer);
    }
    static int Ispossi(int tar){ // tar번 채널까지 숫자패드로 가기 가능?
        // 불가능하다면 매우 큰 수 출력, 가능하다면 채널 길이 출력
        int tarlen = String.valueOf(tar).length();
        int quo = (int)Math.pow(10, tarlen-1), digit;
        while(quo != 0){
        digit = tar / quo;
            for(int i : malf)
                if(digit == i)
                    return BigN;
            tar %= quo;
            quo /= 10;
        }
        return tarlen;
    }
}
