package project;
import java.io.*;
import java.util.*;

class paper{
    int y, x;
    public paper(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Findimpossi {
    
    public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2643번 scafolding code.
        // 색종이 수는 5개로 제한
        // 변 제한은 1 - 1000
        int Nofp = 3;
        Random r1 = new Random();
        while(true){
        paper[] ori = new paper[Nofp]; // 입력받은 대로
        paper[] input1 = new paper[Nofp]; // 0 - (정답)
        paper[] input2 = new paper[Nofp]; // 0 -  (오답)
        int[] dp1 = new int[Nofp]; // 0 - 
        int[] dp2 = new int[Nofp]; // 0 - 
        for(int i = 0; i < Nofp; i++){
            int y = r1.nextInt(1000)+1; // 1 - 1000
            int x = r1.nextInt(1000)+1;
            ori[i] = new paper(y, x);
            input2[i] = new paper(y, x);
            if(y < x){
                int temp = x;
                x = y;
                y = temp;
            }
            input1[i] = new paper(y, x);
        }
        Arrays.sort(input1, (paper p1, paper p2) -> Integer.compare(p1.y, p2.y) != 0? Integer.compare(p1.y, p2.y) : Integer.compare(p1.x, p2.x));
        for(int i = 0; i < Nofp; i++){
            dp1[i] = 1; // 자기 자신
            for(int j = 0; j < i; j++) // 색종이 i가 색종이 j에 포함되어야 함
                if(input1[i].y >= input1[j].y && input1[i].x >= input1[j].x)
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
        }
        int max1 = -1;
        for(int i = 0; i < Nofp; i++)
            max1 = Math.max(max1, dp1[i]);
     // 오답소스
        // compare가 >0이면 순서 바꾸고 아니면 그대로 둠
           // input2 sort 생략
        for(int i = 0; i < Nofp; i++){
            dp2[i] = 1;
            for(int j = 0; j < i; j++) // 색종이 i가 색종이 j에 포함되어야 함
                if((input2[i].y <= input2[j].y && input2[i].x <= input2[j].x) || (input2[i].y <= input2[j].x && input2[i].x <= input2[j].y))
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
        }
        int max2 = -1;
        for(int i = 0; i < Nofp; i++)
            max2 = Math.max(max2, dp2[i]);
            if(max1 != max2){
                for(int i = 0; i < Nofp; i++)
                    System.out.println(ori[i].y + "/" + ori[i].x + " ");
                for(int i = 0; i < Nofp; i++)
            System.out.print(input1[i].y + "/" + input1[i].x + " ");
        System.out.println("");
                for(int j = 0; j < Nofp; j++)
             System.out.print(" dp/" + j + " :: " + dp1[j]);
            System.out.println("");
                System.out.println("");
                   for(int i = 0; i < Nofp; i++)
            System.out.print(input2[i].y + "/" + input2[i].x + " ");
        System.out.println("");
                   for(int j = 0; j < Nofp; j++)
             System.out.print(" dp/" + j + " :: " + dp2[j]);
            System.out.println("");
              break;
            }
    }
}
}
  
