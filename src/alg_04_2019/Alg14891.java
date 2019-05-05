package alg_04_2019;
import java.util.*;
import java.io.*;
public class Alg14891 {
	
	  public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// using bitmask
		  StringBuilder[] input = new StringBuilder[4]; // 그때마다의 톱니상태 저장
		  for(int i = 0; i < 4; i++)
			  input[i] = new StringBuilder(br.readLine());
		  int nofrot = Integer.parseInt(br.readLine());
		  StringTokenizer st;
		  int[] dir = new int[4]; // for문마다 각 톱니바퀴가 회전할 방향(움직x면 0)
		   // 1 : 시계 -1 : 반시계
		  for(int i = 0; i< nofrot; i++){
			  Arrays.fill(dir, 0);
			  st = new StringTokenizer(br.readLine());
			  int tar = Integer.parseInt(st.nextToken());
			  tar--;
			  int tdir = Integer.parseInt(st.nextToken());
			  dir[tar] = tdir;
			  for(int j=tar-1; j>=0; j--)
				  if(input[j].charAt(2) != input[j+1].charAt(6))
					  dir[j] = -dir[j+1];
			  for(int j=tar+1; j<4; j++)
				   if(input[j-1].charAt(2) != input[j].charAt(6))
					  dir[j] = -dir[j-1];
			  // 톱니를 돌림
			  for(int j=0; j<4; j++)
				  if(dir[j] == 1){ // 시계
					  char temp = input[j].charAt(7);
					  input[j].deleteCharAt(7);
					  input[j].insert(0, temp);
				  }
			  else if(dir[j] == -1){
				    char temp = input[j].charAt(0);
					  input[j].deleteCharAt(0);
					  input[j].append(temp);
			  }
		  }
		  int ans = 0;
		  for(int i=0;i<4;i++)
			  if(input[i].charAt(0) == '1')
				  ans += (1<<i);
		  System.out.println(ans);
	  }
}