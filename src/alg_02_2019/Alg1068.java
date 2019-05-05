package alg_02_2019;
import java.util.*;
import java.io.*;

public class Alg1068 {
    static ArrayList<ArrayList<Integer>> children; // 각 index에 대해 자식들을 저장
    static int tar, answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        children = new ArrayList<ArrayList<Integer>>(N); // 0번 노드부터 시작
        for(int i = 0; i < N; i++)
            children.add(new ArrayList<Integer>());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp, root = -1;
        for(int i = 0; i < N; i++){
            if((temp = Integer.parseInt(st.nextToken())) == -1)
                root = i;
            else
            children.get(temp).add(i);   
        }
        tar = Integer.parseInt(br.readLine());
        if(root == tar)
            System.out.println(0);
        else{
        dfs(root);
        System.out.println(answer);
        }
    }
    static void dfs(int node){ // node부터 탐색하면서 ln의 개수를 셈
        if(children.get(node).isEmpty()){ // 기저 사례
            answer++;
         return;   
        }
        for(int i : children.get(node))
            if(i == tar){
                if(children.get(node).size() == 1)
                    answer++;
            }
            else
                dfs(i);
    }
}
