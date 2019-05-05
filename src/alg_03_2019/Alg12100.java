package alg_03_2019;
import java.io.*;
import java.util.*;
public class Alg12100 {
	static int N;
	// static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N]; // 0 -
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = -1;
		for(int i = 0; i < 4; i++)
		ans = Math.max(ans, Findlb(0, i, map));
		System.out.println(ans);
	}
	static int Findlb(int rep, int dir, int[][] omap){ // dir : 0123(상하좌우)
		// rep : 지금까지 시행한 횟수, map : 현재 map
		if(rep == 5){
			int max = -1;
			for(int[] arr : omap)
				for(int i : arr)
					max = Math.max(max, i);
			return max;
		}
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++)
			System.arraycopy(omap[i], 0, map[i], 0, N); // 배열 복제
		int tmax = -1;
			// 각 줄에 대해 비트마스크
			if(dir == 0) // 위로 움직임
			for(int j = 0; j < N; j++){ // 각 열에 대해..
				int visited = 0; // 0이면 방문x, 1이면 방문o
				int lastI = -1, lastv = -1; // 각 줄 마지막 요소 index, val
				for(int k = 0; k < N; k++) // 한 열을 차례대로 훑는다.
					if(map[k][j] != 0){
						if(map[k][j] != lastv || (map[k][j] == lastv && (visited & (1<<lastI)) > 0)){ // 값이 다르거나 (같은데 이미 lastcell이 합쳐진 셀)임
							// 이 경우 땡기기만 하면 되는데 움직이지 않으면 skip
							lastv = map[k][j];
							map[++lastI][j] = lastv;
						if(lastI != k)
							map[k][j] = 0;
						}
						else{ // 값도 같고 처음 합쳐짐
							lastv *= 2;
							map[lastI][j] = lastv;
							map[k][j] = 0;
							visited |= (1<<lastI);// 합쳐진 셀
						}
					}
				}
			else if(dir == 1)
				for(int j = 0; j < N; j++){ // 각 열에 대해..
					int visited = 0; // 0이면 방문x, 1이면 방문o
				int lastI = N, lastv = -1; // 각 줄 마지막 요소 index, val
				for(int k = N-1; k >= 0; k--) // 한 열을 차례대로 훑는다.
					if(map[k][j] != 0){
						if(map[k][j] != lastv || (map[k][j] == lastv && (visited & (1<<lastI)) > 0)){ // 값이 다르거나 이미 lastcell이 합쳐진 셀임
							lastv = map[k][j];
							map[--lastI][j] = lastv;
							if(lastI != k)
							map[k][j] = 0;
						}
						else{ // 값도 같고 처음 합쳐짐
							lastv *= 2;
							map[lastI][j] = lastv;
							map[k][j] = 0;
							visited |= (1<<lastI);
						}
					}
				}
			else if(dir == 2) //왼쪽으로
				for(int j = 0; j < N; j++){ // 각 행에 대해..
					int visited = 0; // 0이면 방문x, 1이면 방문o
				int lastI = -1, lastv = -1; // 각 줄 마지막 요소 index, val
				for(int k = 0; k < N; k++){ // 한 행을 차례대로 훑는다.
					if(map[j][k] != 0){
						if(map[j][k] != lastv || (map[j][k] == lastv && ((visited & (1<<lastI)) > 0))){ // 값이 다르거나 이미 lastcell이 합쳐진 셀임
							lastv = map[j][k];
							map[j][++lastI] = lastv;
							if(lastI != k)
							map[j][k] = 0;
						}
						else{ // 값도 같고 처음 합쳐짐
							lastv *= 2;
							map[j][lastI] = lastv;
							map[j][k] = 0;
							visited |= (1<<lastI);
						}
					}
				}
				}
			else // 오른쪽
				for(int j = 0; j < N; j++){ // 각 행에 대해..
					int visited = 0; // 0이면 방문x, 1이면 방문o
				int lastI = N, lastv = -1; // 각 줄 마지막 요소 index, val
				for(int k = N-1; k >= 0; k--) // 한 행을 차례대로 훑는다.
					if(map[j][k] != 0){
						if(map[j][k] != lastv || (map[j][k] == lastv && (visited & (1<<lastI)) > 0)){ // 값이 다르거나 이미 lastcell이 합쳐진 셀임
							lastv = map[j][k];
							map[j][--lastI] = lastv;
							if(lastI != k)
							map[j][k] = 0;
						}
						else{ // 값도 같고 처음 합쳐짐
							lastv *= 2;
							map[j][lastI] = lastv;
							map[j][k] = 0;
							visited |= (1<<lastI);
						}
					}
				}
			for(int j = 0; j < 4; j++)
			tmax = Math.max(tmax, Findlb(rep+1, j, map));
		return tmax;
	}
}
