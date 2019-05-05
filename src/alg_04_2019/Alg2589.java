package alg_04_2019;
import java.util.*;
import java.io.*;
class Alg2589{
  public static String solution(int n){
      int[] stn = new int[34]; // 3^i
      stn[0] = 1;
      for(int i=1;i<34;i++)
          stn[i] = stn[i-1]*3;
      // judge digits of n
      int rep = 0, ind = 1, nofd = 0;
      while(rep<n){
          nofd++;
          rep += stn[ind++];
      }
      if(nofd != 1)
      n -= rep-stn[--ind];
      int[] conv = {1, 2, 4};
      StringBuilder answer = new StringBuilder();
      while(nofd != 1){
		  if(n%stn[--nofd] == 0){
          answer.append(conv[n/stn[nofd]-1]);
			n -= stn[nofd]*(n/stn[nofd]-1);
		  }
		  else{
		answer.append(conv[n/stn[nofd]]);
			n -= stn[nofd]*(n/stn[nofd]);
		  }
      }
      answer.append(conv[n-1]);
      return answer.toString();
  }
	public static void main(String[] args){
		for(int i=1;i<100;i++){
			System.out.println("i : " + i);
		System.out.println(solution(i));	
		}
	}
}