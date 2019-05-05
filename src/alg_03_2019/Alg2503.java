package alg_03_2019;
import java.io.*;
import java.util.*;
class Info2503{
    String n;
    int s, b;
    public Info2503(String n, int s, int b){
        this.n = n;
        this.s = s;
        this.b = b;
    }
}
public class Alg2503 {
    static Info2503[] input;
    static int Nofq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofq = Integer.parseInt(br.readLine());
        input = new Info2503[Nofq];
        StringTokenizer st;
        for(int i = 0; i < Nofq; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new Info2503(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        for(int i = 1; i < 10; i++)
            for(int j = 1; j < 10; j++)
                for(int k = 1; k < 10; k++)
                    if(i != j && j != k && k != i && Issatis(String.valueOf(i*100 + j*10 + k)))
                        answer++;
        System.out.println(answer);
    }
    static boolean Issatis(String num){
        int answer = 0;
        for(int i = 0; i < Nofq; i++){
            int s = 0, b = 0;
            for(int j = 0; j < 3; j++)
                if(input[i].n.charAt(j) == num.charAt(j))
                    s++;
                else
                    for(int k = 0; k < 3; k++)
                        if(input[i].n.charAt(k) == num.charAt(j)){
                            b++;
                            break;
                        }
            if(s != input[i].s || b != input[i].b) // 하나라도 틀리면 false
                return false;
                }
     return true;
    }
}
