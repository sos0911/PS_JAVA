/* NWERC 2006
 * Sample solution to Bookcase
 * By Mikael Goldmann
 *
 * idea:
 * Try all possible combination of shelf heights (O(N^2) possible)
 * And for each combination, find minimum width using dynamic programming.
 *  ....But is it fast enough??
 *  The problem is that the dynamic programming solution may be be O(N^2)  
 *  as well.
 *  Some pruning is used to remove useless cases.
 *     Stop the DP if you discover that you will do worse than "best so far"
 *     Initial greedy solution gives good first "best so far"
 *     Before DP, compute maxw (max allowable width to achieve better area) and
 *     check that the highest shelf or the second highest won't get too wide. 
 */


import java.util.Scanner;
import java.util.Arrays;

class Book implements Comparable
{
    int t,h;
    public int  compareTo(Object b) 
    { return ((Book)b).h-h; }
}


/*
  class Triple  implements Comparable
  {
  int a,b,c;
  Triple(int a1=0, int b1=0, int c1=0) : a(a1), b(b1), c(c1) {  }
  
  int compareTo(Triple)
  {    
  if (a != t.a) return a-t.a;
  if (b != t.b) return b-t.b;
  return c-t.c;
  }
  
  int width() const
  { return max(a,Math.max(b,c));  }
  }
  
*/

class bookcase_mg{

    static Scanner in = new Scanner(System.in);
    int smallest(Book[] b, int[] sh, int totwidth, int bound) 
    {
	int height = sh[0]+sh[1]+sh[2];  
	
	if ((height*totwidth)>3*bound) return bound;
	int maxw = Math.min(totwidth,bound/height);
	int N = b.length;  
	
	// count total width of books that must be in shelf 2 / on shelf 1 or 2
	int wd2=0, wd12=0; 
	for (int i=0; i<N; ++i)
	    if (b[i].h>sh[0]) {
		wd12+=b[i].t;
		if (b[i].h>sh[1])
		    wd2+=b[i].t;
	    }
	if (wd2>maxw || wd12 >2*maxw) return bound;
	
	
	int[][] tab=new int[2][];
	int[][] ext=new int[2][];
	
	tab[0]=   new int [(maxw+1)*(maxw+1)];
	tab[1]=   new int [(maxw+1)*(maxw+1)];
	ext[0]=   new int [(maxw+1)];
	ext[1]=   new int [(maxw+1)];
	
	Arrays.fill(tab[0], 0);
	Arrays.fill(tab[1], 0);
	tab[0][0] = 1;
	ext[0][0] = 1;
	
	int cookie=1;  
	int wd=0;  
	for (int i=0; i<N; ++i, ++cookie) {
	    int cur=i&1;
	    int nxt=1-cur;    
	    int wcur = b[i].t;    
	    for (int w0=0; w0 <= maxw; ++w0)
		if (ext[cur][w0]==cookie)
		    for (int w1=Math.max(0,wd-maxw-w0); w1 <= maxw; ++w1) {
			int pos=w0*(maxw+1)+w1;	
			int w2 = wd-w0-w1;
			if (tab[cur][pos]==cookie) {
			    if (b[i].h <= sh[1] && w1+wcur<=maxw) 	    
				ext[nxt][w0] = tab[nxt][pos+wcur]=1+cookie;
			    if (b[i].h <= sh[0] && w0+wcur<=maxw) 
				ext[nxt][w0+wcur] = tab[nxt][pos+wcur*(maxw+1)]=1+cookie;	  
			    if (/*b[i].h <= sh[2] && */w2+wcur<=maxw) 
				ext[nxt][w0] = tab[nxt][pos]=1+cookie;
			}
		    }
	    wd += wcur;
	}
	
	for (int w0=0; w0 <= maxw; ++w0)
	    for (int w1=0; w1 <= maxw; ++w1) {
		int pos=w0*(maxw+1)+w1;
		int w2 = totwidth-w0-w1;      
		if (tab[N&1][pos]>0 && w0>0 && w1>0 && w2>0) {	
		    int wd1 = Math.max(w0, Math.max(w1,w2));
		    if (bound > wd1*height)
			bound= Math.min(bound,wd1*height);
		}
      
	    }
	return bound;  
    }
    
    
    void solve() throws Exception
    {
	
	int N=in.nextInt();
	
	Book[] b = new Book[N];
	int totwidth=0;
	for (int i=0; i<N; ++i) {
	    b[i] = new Book();
	    b[i].h = in.nextInt();
	    b[i].t = in.nextInt();
	    totwidth += b[i].t;
	}
  
	Arrays.sort(b);
	
	int[] v = new int[N];  
	for (int i=0;i<N;++i) v[i]=b[N-i-1].h; 
	int nv = 1;
	int nnv=1;
	while(nnv<N) {
	    if (v[nv-1]!=v[nnv]) v[nv++]=v[nnv];
	    ++nnv;
	}
  
	
	// Iterate over all possible heights of the shelf (one has height v[nv-1])
	
	int[] sh = new int[3]; // shelf heights
	sh[2]= v[nv-1];
	int best,greedybest;
	
	// Get good greedy first approx (for pruning)
	int T,i1;  
	for (T=0, i1=0; 3*(T+b[i1].t)<=totwidth; ++i1)
	    T+=b[i1].t;
	sh[1] = b[i1].h;
	for (T=0; 3*(T+b[i1].t)<=totwidth; ++i1)
	    T+=b[i1].t;
	sh[0] = b[i1].h;
	for (T=0; i1<N; ++i1)
	    T+=b[i1].t;
	best=greedybest= T*(sh[0]+sh[1]+sh[2]);  
	
	// try all shelf heights
	Arrays.sort(b);
	for (int i=0; i<nv; ++i)
	    for (int j=i; j<nv; ++j) {      
		sh[0]= v[i];
		sh[1]= v[j];
		best = smallest(b,sh,totwidth,best);
	    }
	
	System.out.println(best);
	
    }
    
    public static void main(String[] a) throws Exception
    {
	int T = in.nextInt(); 
	
	while (T-->0) new bookcase_mg().solve();    
    }
}
