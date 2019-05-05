package alg_11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Alg1_1stweek {
    static  ArrayList<Boolean> primeList = new ArrayList<Boolean>(10000000); // 0 - 9999999
   // static HashSet<Integer> hs = new HashSet<Integer>(); // 각 input에서 나오는 prime들을 담을 hashset
    static boolean[][]check = new boolean[8][10]; // 몇번째 자리(1-7)에 어떤 숫자(0-9)가 이미 사용되었는가를 기록
    static int answer = 0; // 각 TC마다의 소수 개수
    
    
 public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     int NofTC = Integer.parseInt(br.readLine());
     String [] inputs = new String[NofTC];
     int[] intinputs = new int[NofTC];
     // max 생략
     for(int i = 0; i < NofTC; i++){
         inputs[i] = br.readLine();
        while(inputs[i].charAt(0) == '0')
            inputs[i] = inputs[i].substring(1, inputs[i].length()).concat("0");
         intinputs[i] = Integer.parseInt(inputs[i]);
     }
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
     for(boolean[] i : check) // check배열 초기화
             Arrays.fill(i, false);
     for(int i = 0; i < NofTC; i++){ 
         Backtracking(0, intinputs[i]);
         //bw.write(String.valueOf(hs.size()));
         bw.write(String.valueOf(answer));
         bw.newLine();
         bw.flush();
        // hs.clear(); 
         for(boolean[] j: check) // check배열 초기화
             Arrays.fill(j, false);
                  answer = 0; // answer 초기화
     }
 }
     static void Backtracking(int curS, int candidates){
         if(primeList.get(curS))
            // hs.add(curS);
            answer++;
         if(candidates == 0) // 더 이상 계산할 후보군이 없을 때
             return;
         int curlength = String.valueOf(curS).length();
         int canlength = String.valueOf(candidates).length();
         for(int i = 0; i < canlength; i++){
              int remain = (int)Math.pow(10, canlength-i-1);
             int movingN = (candidates % (remain*10)) / remain; // candidates에서 현재 숫자로 옮겨가는 수
             if(curS == 0){ // 첫 자리에 숫자를 붙일 때
                 if(check[1][movingN])
                     return;
             else
                 check[1][movingN] = true;
             }
             else{ // 첫 자리가 아닌 자리에 숫자를 붙임
             if(check[curlength+1][movingN])
                 return;
             else
                 check[curlength+1][movingN] = true;
             }
             int befcurS = curS;
             int befcandidates = candidates;
             curS = curS*10 + movingN;
             candidates = (candidates / (remain*10))*remain  + (candidates % remain);
             Backtracking(curS, candidates);
             curS = befcurS;
             candidates = befcandidates;
             if(curS == 0)
                  check[1][movingN] = false;
             else
                 check[curlength+1][movingN] = false;
         }
     }
 }
