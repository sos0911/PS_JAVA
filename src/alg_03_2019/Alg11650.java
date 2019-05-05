package alg_03_2019;
import java.io.*;
import java.util.*;
class point11560{
    int x, y;
    public point11560(int x, int y){
        this.y = y;
        this.x = x;
    }
}
public class Alg11650 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        point11560[] input = new point11560[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new point11560(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // (x,y)
        }
        Arrays.sort(input, (point11560 p1, point11560 p2) -> Integer.compare(p1.x, p2.x) == 0? Integer.compare(p1.y, p2.y) : Integer.compare(p1.x, p2.x));
        for(point11560 p : input)
            bw.write(p.x + " " + p.y + "\n");
        bw.close();
    }
}
