package backjoonalg;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Alg2448 { // 2448번
    static StringBuilder[] line; // 앞 공백 제외한 나머지 '부분' 저장
    static int Nofl;
    public static void main(String[] args) throws IOException{
       Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Nofl = sc.nextInt();
        line = new StringBuilder[Nofl+1]; // index 1부터
        for(int i = 4; i < Nofl+1; i++)
            line[i] = new StringBuilder((Nofl/3)*6-1); // 초기화
        PrintLine(Nofl);
        StringBuilder STS = new StringBuilder("");
        for(int j = 0; j < Nofl-1; j++)
          STS.append(" ");  
        for(int i = 1; i < Nofl+1; i++){
        bw.write(STS.substring(i-1, Nofl-1));
        bw.write(line[i].toString());
        bw.write(STS.substring(i-1, Nofl-1));
         bw.newLine();   
        }
        bw.close();
    }
    static void PrintLine(int Nofl){
        if(Nofl == 3){
            line[1] = new StringBuilder("*");
            line[2] = new StringBuilder("* *");
            line[3] = new StringBuilder("*****");
            return;
        }
        PrintLine(Nofl/2);
        for(int i = (Nofl/2)+1; i <= Nofl; i++){
            line[i].append(line[i-(Nofl/2)]);
            PrintBlank(i, 2*(Nofl-i)+1);
            line[i].append(line[i-(Nofl/2)]);
        }
    }
    static void PrintBlank(int wline, int Nofr){
        for(int i = 0; i < Nofr; i++)
            line[wline].append(" ");
    }
    }

