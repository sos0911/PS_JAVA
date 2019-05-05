package project; // 미완
import java.util.Arrays;
import java.util.Scanner;

class Cal{
    private int NofPart, Nofline;
    private int[][][] cache;
    private boolean[][] visited;
    private short[] dx = {0, 1, -1, 0};
    private short[] dy = {1, 0, 0, -1};
     
        
    public Cal(int NofPart, int Nofline){
         this.NofPart = NofPart;
        this.Nofline = Nofline;
        cache = new int[NofPart + 1][Nofline + 1][6]; // 혼란을 방지하기 위해 높이 Nofline/ 너비 NofPart의 (x,y)에서 길이 n만큼 형성 가능한 단어의 가짓수를 cache[x][y][n]에 저장할 것임 
        visited = new boolean[NofPart + 1][Nofline + 1];
          for(int i = 0; i < NofPart + 1; i++)
              for(int j = 0; j < Nofline + 1; j++)
                  for(int k = 0; k < 6; k++)
                      cache[i][j][k] = -1;
        
          for(int i = 0; i < NofPart + 1; i++)
              for(int j = 0; j < Nofline + 1; j++)
                  visited[i][j] = false;
    }
  
    int Isthereword(int x, int y, String word){ // 이 메소드가 동작하는 범위는 (NofPart, Nofline)의 범위의 직사각형이다.
        int kindofC = ((y-1)*NofPart + x) % 5; // 글자의 종류
        int whatisthisC;
        int sum = 0;
        if(kindofC == 1 || kindofC == 4)
            whatisthisC = 1; // 뚜
        else{
            whatisthisC = 0; // 루
        }
        if(x < 1 || x > NofPart || y < 1 || y > Nofline)
             return 0; // 기저 사례 1 : 범위를 벗어난 경우 
        if(visited[x][y])
            return 0; // 기저 사례 1-2 : 이미 방문했던 글자임
        if(whatisthisC != word.charAt(0) - '0') 
            return 0; // 기저 사례 2 : 글자가 찾고 싶은 첫 글자와 mismatch
        if(word.length() == 1)
            return 1; // 기저 사례 3 : 찾고 싶은 글자였는데 마지막 글자여서 종료 가능한 경우
       
        if(cache[x][y][word.length()] != -1) // 저장해 놓은 값이 있다면
            return cache[x][y][word.length()]; // memorization 활용 
  
        visited[x][y] = true;
        for(int i = 0; i < 4; i++)
           sum += Isthereword(x + dx[i], y + dy[i], word.substring(1));
        
        visited[x][y] = false;
        cache[x][y][word.length()] = sum;
            return cache[x][y][word.length()]; 
    }
}

public class NoendBackjoonAlg {
    
    public static void main(String[] args){
        String word = "10010"; // 뚜루루뚜루 (10010)
        Scanner sc = new Scanner(System.in);
        int Nofline = sc.nextInt();
        int NofPart = sc.nextInt();
        int Rec5answer = 0, Rec10answer = 0, finalanswer = 0;
        int RestRecanswer = 0; // height가 5를 넘어갈 시 잘라내고 남은 찌꺼기 직사각형의 가짓수를 저장
        int NofExtendedW = 0; // 걸치는 단어들의 개수
        long start = System.currentTimeMillis();
        if(Nofline <=  10){ // input rec의 height가 10 이하이다. 그대로 계산
            Cal c = new Cal(NofPart, Nofline); // 높이 Nofline인 직사각형
        for(int i = 1; i < NofPart + 1; i++)
            for(int j = 1; j < Nofline + 1; j++)
                finalanswer += c.Isthereword(i, j, word);
        }
        else{
            Cal c = new Cal(NofPart, 5); // 높이 5인 직사각형
        for(int i = 1; i < NofPart + 1; i++)
            for(int j = 1; j < 6; j++){
                Rec5answer += c.Isthereword(i, j, word); // Rec5answer에는 (5,C) 직사각형 내에서 생성 가능한 word의 갯수를 저장
            }
        
            Cal c2 = new Cal(NofPart, (Nofline % 5) + 5); // 높이 ((Nofline) % 5 + 5)인 직사각형 
          for(int i = 1; i < NofPart + 1; i++)
            for(int j = 1; j < (Nofline % 5) + 6; j++)
                RestRecanswer += c2.Isthereword(i, j, word);
            
            
             Cal c3 = new Cal(NofPart, 10); // 높이 10인 직사각형
        for(int i = 1; i < NofPart + 1; i++)
            for(int j = 1; j < 11; j++)
                Rec10answer += c3.Isthereword(i, j, word); // Rec10answer에는 (10,C) 직사각형 내에서 생성 가능한 word의 갯수를 저장 
            
        NofExtendedW = Rec10answer - Rec5answer*2;
            finalanswer = Rec5answer*((Nofline -((Nofline) % 5 + 5))/5)+ NofExtendedW*((Nofline -((Nofline) % 5 + 5))/5)  + RestRecanswer;
            
        }
        // NofExtendedW에는 (5,C) 직사각형과 (5,C) 직사각형 사이에 걸치는 word들의 개수가 저장되어 있음
        // {((Nofline) % 5 + 5) 높이의 직사각형 내 전체 가짓수} + {Nofline - ((Nofline) % 5 + 5) 높이의 직사각형 내 전체 가짓수} + NofExtendedW가 답이다.
        System.out.println(finalanswer);
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);
    }
}
