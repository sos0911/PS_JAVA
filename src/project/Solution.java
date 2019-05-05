package project;
import java.io.*;
import java.util.*;

class Solution{
	static boolean[][] used;
	static int[][] ans; 
    static int R,C;
    public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Noftc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=1;i<=Noftc;i++){
            st = new StringTokenizer(br.readLine());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
			if((R==2 && C==2)||(R==2 && C==3)||(R==3 && C==2)||(R==2 && C==4)||(R==4 && C==2)||(R==3 && C==3)){
				bw.write("Case #"+i+": "+"IMPOSSIBLE\n");
				continue;
			}
			used=new boolean[R+1][C+1];
			ans=new int[R*C+1][2];
			Randfs(0, -1, 500); // initiate
			bw.write("Case #"+i+": "+"POSSIBLE\n");
			for(int j=1;j<=R*C;j++){
				for(int k=0;k<2;k++)
					bw.write(ans[j][k] + " ");
			bw.newLine();	
			}
		}
			bw.close();
	}
    static boolean Randfs(int cnt, int y, int x){
        if(cnt == R*C)
            return true; // end
		boolean[][] check = new boolean[R+1][C+1]; // Is it checked?
		int rem = R*C-cnt; // Nofcandidate
      	while(rem>0){
			  int nexty = (int)(Math.random()*R)+1;
        int nextx = (int)(Math.random()*C)+1;
			if(!check[nexty][nextx] && !used[nexty][nextx]){
				if(y != nexty && x != nextx && y-x != nexty-nextx && y+x != nexty+nextx){
					used[nexty][nextx] = true;
					ans[cnt+1][0]=nexty;
					ans[cnt+1][1]=nextx;
				if(Randfs(cnt+1, nexty, nextx))
					return true;
					used[nexty][nextx] = false;
			}
			check[nexty][nextx] = true;
			rem--;
			}
		}
		return false; // can't find ans
    }
}