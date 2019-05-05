import java.util.*;

public class bookcase_jm
{
	static Scanner in = new Scanner(System.in);
	
	static final int MAX_HEIGHT = 300;
	static final int MIN_HEIGHT = 150;
	static final int MAX_THICKNESS = 40;
	static final int MAX_BOOKS = 80;

	static final int MAX_SHELF_WIDTH = (MAX_BOOKS + 2) / 3 * (MAX_HEIGHT * 2 + MIN_HEIGHT) / (MAX_HEIGHT + MIN_HEIGHT * 2) * MAX_THICKNESS;
	static final int INF = 999999999;

	public static void main(String[] s) throws Exception
	{
		int N = in.nextInt();
		while(N-- > 0)
			new bookcase_jm();
	}
	
	class Book implements Comparable<Book>
	{
		public int height, width;
		public Book(int h, int w) { height = h; width = w;}
		public int compareTo(Book other) { return height - other.height; }
	}
	
	bookcase_jm()
	{		
		int n = in.nextInt(), h, w, best = INF;
		
		Book[] books = new Book[n];
		for(int i = 0; i < n; i++)
			books[i] = new Book(in.nextInt(), in.nextInt());
		Arrays.sort(books);
				
		int psum[] = new int[n + 1];
		psum[n]=0;
		for(int i = n - 1; i >= 0; i--)
			psum[i] = psum[i + 1] + books[i].width;
		int maxWidth = Math.min(psum[0], (n + 2) / 3 * (MAX_HEIGHT * 2 + MIN_HEIGHT) / (MAX_HEIGHT + MIN_HEIGHT * 2) * MAX_THICKNESS);
			
		int dp1[][] = new int[maxWidth + MAX_THICKNESS + 1][maxWidth + MAX_THICKNESS + 1];
		int dp2[][] = new int[n + 1][maxWidth + 1];
		
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= maxWidth; j++)
				dp2[i][j] = INF;
		dp2[n][0] = 0;	
		for(int i = n - 1; i >= 0; i--) {
			for(int j = maxWidth; j >= 0; j--) {
				if (j + books[i].width <= maxWidth)
					dp2[i][j + books[i].width] = Math.min(dp2[i][j + books[i].width], dp2[i + 1][j]);
				dp2[i][j] = Math.min(dp2[i][j], dp2[i + 1][j] != 0 ? dp2[i + 1][j] : books[i].height);
			}
		}
		
		for(int uw = 0; uw <= maxWidth + MAX_THICKNESS; uw++)
			for(int mw = 0; mw <= maxWidth + MAX_THICKNESS; mw++)
				if (uw > maxWidth || mw > maxWidth)
					dp1[uw][mw] = INF;
				else
					dp1[uw][mw] = Math.max(uw, Math.max(mw, psum[0] - uw - mw));
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= maxWidth; j++) {
				int lh = i == 0 ? books[0].height : books[i-1].height;
				int mh = dp2[i][j] != 0 ? dp2[i][j] : lh;
				if (mh != INF && psum[i] - j <= maxWidth) {
					w = dp1[j][psum[i] - j];
					h = books[n - 1].height + mh + lh;
					if (w < INF && w * h < best)
						best = w * h;
				}
			}
			
			int ct = books[i].width;
			for(int uw = 0; uw <= maxWidth; uw++)
				for(int mw = 0; mw <= maxWidth; mw++)
					dp1[uw][mw] = Math.min(dp1[uw][mw], Math.min(dp1[uw + ct][mw], dp1[uw][mw + ct]));
		}
		
		System.out.println(best);
	}
}
