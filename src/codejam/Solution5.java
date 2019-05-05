package codejam;
import java.io.*;
import java.util.*;
public class Solution5 {
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int noft=Integer.parseInt(br.readLine());
		 for(int i=1;i<=noft;i++){
			 int nofr=Integer.parseInt(br.readLine());
			 StringBuilder[] input=new StringBuilder[nofr]; //0-
			 for(int j=0;j<nofr;j++){
				 input[j]=new StringBuilder(br.readLine());
			 	if(input[j].length()<500)
					while(input[j].length()<500)
						input[j].append(input[j]);
			 }
			 char[]a={'R','S','P'};
			 char[]b={'P','R','S'};
			 StringBuilder ans=new StringBuilder();
			 boolean impossi=false;
			 boolean possi=false;
			 boolean[] ok=new boolean[nofr]; //0-
			 for(int k=0;k<500;k++){
				 boolean[] visited=new boolean[26]; // R,S,P
			 for(int j=0;j<nofr;j++){
			     if(!ok[j]) // not yet win
				 visited[input[j].charAt(k)-'A']=true;
			 }
				 int cnt=0;
				for(int j=0;j<3;j++)
					if(visited[a[j]-'A'])
						cnt++;
				 if(cnt==3){
					 impossi=true;
					 break;
				 }
				 else if(cnt==2){
				     char tar='?';
					 for(int j=0;j<3;j++)
						 if(!visited[b[j]-'A']){
					 		ans.append(a[j]);
					 		tar=a[j];
						 }
					char tar2='?';
					 for(int j=0;j<3;j++)
					    if(b[j]==tar)
					        tar2=a[j];
					 for(int j=0;j<nofr;j++)
					    if(input[j].charAt(k)==tar2)
					        ok[j]=true; // already win for that
				 }
				 else{
					for(int j=0;j<3;j++)
						if(visited[a[j]-'A'])
							ans.append(b[j]);
					possi=true;
					 break;
				 }
			 }
				 if(impossi || !possi)
					 System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			 	else
					System.out.println("Case #"+i+": "+ans.toString());
		 }
	 }
}
