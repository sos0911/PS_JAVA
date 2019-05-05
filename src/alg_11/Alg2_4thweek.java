package alg_11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg2_4thweek { // 9366번(success!)
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 1; i < NofTC+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] sides = new int[3];
             sides[0] = Integer.parseInt(st.nextToken());
             sides[1] = Integer.parseInt(st.nextToken());
             sides[2] = Integer.parseInt(st.nextToken());
            int max = -1, maxindex = -1;
            for(int j = 0; j < 3; j++) // 가장 긴 변 추출
                if(sides[j] > max){
                    max = sides[j];
                    maxindex = j;
                }
            int leftTwosum = 0;
            for(int j = 0; j < 3; j++){
             if(j == maxindex)   
                continue;
                leftTwosum += sides[j];
            }
            if(leftTwosum <= max){
                System.out.printf("Case #%d: invalid!", i);
                System.out.println(""); // 줄 개행
             continue;   
            }
            // 여길 통과하면 일단 삼각형의 조건은 완성된다.
            if(sides[0] == sides[1] && sides[1] == sides[2]){
                System.out.printf("Case #%d: equilateral", i);
                System.out.println(""); // 줄 개행
                continue;
            }
            else if(sides[0] == sides[1] || sides[1] == sides[2] || sides[2] == sides[0]){
                 System.out.printf("Case #%d: isosceles", i);
                System.out.println(""); // 줄 개행
                continue;
            }
              else{
                   System.out.printf("Case #%d: scalene", i);
                System.out.println(""); // 줄 개행
                continue;
              }  
        }
    }
}


