package project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Backjoon2 {
      static  ArrayList<Boolean> primeList = new ArrayList<Boolean>(10000000); // 0 - 9999999
    static boolean[][]check = new boolean[8][10]; // 몇번째 자리(1-7)에 어떤 숫자(0-9)가 이미 사용되었는가를 기록
    static int answer = 0; // 각 TC마다의 소수 개수
    static boolean[] chknum = new boolean[10000000]; // 어떤 숫자가 나왔는지를 기록(중복 방지)
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     int NofTC = Integer.parseInt(br.readLine());
    for(int i = 0; i < 10000000; i++)
         primeList.add(true);
     primeList.set(0, false);
     primeList.set(1, false);
     int itr = (int)Math.sqrt(9999999);
     for(int i = 2; i <= itr; i++){
         if(primeList.get(i))
             for(int k = i*2; k <= 9999999; k += i)
                 primeList.set(k, false);
     }
        for(boolean[] j: check) // check배열 초기화
             Arrays.fill(j, false);
      Arrays.fill(chknum, false);
     for(int i = 0; i < NofTC; i++){
         String input =  br.readLine();
         Backtracking("", input);
         bw.write(String.valueOf(answer));
         bw.newLine();
         bw.flush();
         for(boolean[] j: check) // check배열 초기화
             Arrays.fill(j, false);
      Arrays.fill(chknum, false);
                  answer = 0; // answer 초기화
     }
     }
    
    static void Backtracking(String curS, String candidates){
        if(curS.equals("0")) // 현재 문자열의 첫 부분이 0일떄 종료
            return;
        if(!curS.equals(""))
         if(!chknum[Integer.parseInt(curS)] && primeList.get(Integer.parseInt(curS))){
            answer++;
          chknum[Integer.parseInt(curS)] = true;
         }
         if(candidates.equals("")) // 더 이상 계산할 후보군이 없을 때 종료
             return;
         int curlength = curS.length();
         int canlength = candidates.length();
        boolean[] forcheck = new boolean[10]; // 0 - 9까지 canlength + 1 자리에 쓰였는지를 나타냄
        Arrays.fill(forcheck, false);
         for(int i = 0; i < canlength; i++){
              String movingNum = candidates.substring(i, i+1);
             if(forcheck[Integer.parseInt(movingNum)]) // 이 자릿수에 이 숫자가 이미 출현하여 순회했는지를 검사
                 continue;
             else
                 forcheck[Integer.parseInt(movingNum)] = true;
             
            String befcurS = new String(curS);
             String befcandidates = new String(candidates);
             curS = curS.concat(movingNum);
             if(i == 0)
                 candidates = candidates.substring(1, canlength);
             else
                  candidates = candidates.substring(0, i).concat(candidates.substring(i+1, canlength));
             Backtracking(curS, candidates);
             curS = befcurS;
             candidates = befcandidates;
         }
    }   
    }
