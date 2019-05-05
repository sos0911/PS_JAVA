package alg_03_2019;
import java.io.*;
import java.util.*;

public class Alg2484 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nofp = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = -1;
        for(int i = 0; i < Nofp; i++){
            int[] occur = new int[7]; // 1 - 6
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++)
                occur[Integer.parseInt(st.nextToken())]++;
            for(int j = 1; j < 7; j++)
               if(occur[j] < 2){
                   if(occur[j] == 1)
                       ans = j*100;
                   continue;
               }
                else{
                    if(occur[j] == 2){
                    boolean check = false;
                    for(int k = j+1; k < 7; k++)
                        if(occur[k] == 2){
                            ans = 2000 + j*500 + k*500;
                            check = true;
                         break;   
                        }
                    if(!check)
                        ans = 1000 + j*100;
                }
                else if(occur[j] == 3)
                    ans = 10000 + j*1000;
                else
                    ans = 50000 + j*5000;
                    break;
                    }
            max = Math.max(max, ans);
        }
        System.out.println(max);
    }
}
