package alg_02_2019;
import java.util.*;
import java.io.*;
public class Alg6549 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String eachinput;
        int[] input = new int[100000]; // 각 TC마다 index 0 - N-1 사용
        while(!(eachinput = br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(eachinput);
            int N = Integer.parseInt(st.nextToken());
            for(int i = 0; i < N; i++)
                input[i] = Integer.parseInt(st.nextToken());
            Stack<Integer> list = new Stack<Integer>();
            long answer = 0; // 답으로 쓰일 변수 : 가장 큰 직사각형의 넓이
            for(int i = 0; i < N; i++){
                while(!list.isEmpty() && input[list.peek()] > input[i]){
                    int height = input[list.pop()];
                    int width = i; // left가 결정되지 않으므로 일단 i로..
                    if(!list.isEmpty())
                        width = i-1 -(list.peek()+1) + 1;
                    answer = Math.max(answer, (long)width*height);
                }
                list.push(i); // while문에 상관없이 모든 막대를 push
            }
            // 이제 남아 있는 막대들은 right가 N-1인 경우
            while(!list.isEmpty()){
             int height = input[list.pop()];
            int width = N; // right는 N-1이 확실하므로 일단 끝에서 끝으로 == N
                if(!list.isEmpty())
                    width = N-1 - (list.peek()+1) + 1;
                answer = Math.max(answer, (long)width*height);
            }
            bw.write(answer + "\n");
        }
        bw.close();
    }
}
