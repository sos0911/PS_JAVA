package alg_03_2019;
import java.io.*;
import java.util.*;
class member{
    int age, uid;
    String name;

    public member(int uid, int age, String name){
        this.uid = uid;
        this.age = age;
        this.name = name;
    }
}
public class Alg10814 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<member> priQ = new PriorityQueue<member>(N, (member m1, member m2) -> m1.age > m2.age? 1 : m1.age < m2.age? -1 : m1.uid > m2.uid? 1 : -1); // 람다식 사용. 자료구조의 생성자 or sort() 메서드 내에서 이렇게 생성 가능
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            priQ.add(new member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        for(int i = 0; i < N; i++){
            member temp = priQ.poll();
        bw.write(temp.age + " " + temp.name + "\n");
        }
        bw.close();
    }
}
