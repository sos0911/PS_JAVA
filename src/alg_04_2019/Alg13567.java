package alg_04_2019;
import java.io.*;
import java.util.*;

public class Alg13567 {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // dir(동북서남)
	// (y, x) 기준
	public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ansy = 0, ansx = 0, cdir = 0; // 동쪽
		StringTokenizer st = new StringTokenizer(br.readLine());
		int stN = Integer.parseInt(st.nextToken());
		int Nofs = Integer.parseInt(st.nextToken());
		for(int i = 0; i < Nofs; i++){
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("MOVE")){
				int ins = Integer.parseInt(st.nextToken());
				ansy += dir[cdir][0]*ins;
				ansx += dir[cdir][1]*ins;
			}
			else{
				if(st.nextToken().equals("0")) // 왼90
					cdir = (cdir+1)%4;
				else
					cdir = ((cdir-1) == -1? 3 : cdir-1);
			}
			if(ansy < 0 || ansy > stN || ansx < 0 || ansx > stN){
				System.out.println("-1");
			return;	
			}
		}
		System.out.println(ansx + " " + ansy);
	}
}
