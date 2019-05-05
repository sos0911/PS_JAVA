package SecondTry;
import java.io.*;
import java.util.*;
class Node{
    int noden; // node number
    Node left, right;
    public Node(int noden){
        this.noden = noden;
        left = null;
        right = null;
    }
}
class Info{
    int row, node;
    public Info(int node, int row){
        this.node = node;
        this.row = row;
    }
}
public class Alg2250 {
    static int Nofn; // 노드 개수
    static Node[] tree; // 트리
    static int iterator = 1, nowlevel = 1; // col N과 현재 레벨
    static ArrayList<LinkedList<Info>> infolist; // 레벨별로 노드의 번호, 위치한 열 정보를 포함 
    public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nofn = Integer.parseInt(br.readLine());
        tree = new Node[Nofn+1]; // index 1 - Nofn
        infolist = new ArrayList<LinkedList<Info>>(Nofn);
        for(int i = 0; i <= 10001; i++)
            infolist.add(new LinkedList<Info>());
        for(int i = 1; i <= Nofn; i++)
            tree[i] = new Node(i);
        boolean[] Isnroot = new boolean[Nofn+1]; // false로 초기화
        StringTokenizer st;
        for(int i = 0; i < Nofn; i++){ // 입력 받기
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            for(int j = 0; j < 3; j++)
                input[j] = Integer.parseInt(st.nextToken());
            if(input[1] != -1){
            tree[input[0]].left = tree[input[1]];
                Isnroot[input[1]] = true;
            }
            if(input[2] != -1){
            tree[input[0]].right = tree[input[2]];
              Isnroot[input[2]] = true;   
            }
        }
        int root = -1;
            for(int i = 1; i <= Nofn; i++)
                if(!Isnroot[i]){
                    root = i;
                 break;   
                }
        inorder(tree[root]);
        int an = -1, answer = -1;
        for(int i = 1; i <= 10001; i++){
            LinkedList<Info> list = infolist.get(i);
            if(!list.isEmpty() && list.peekLast().row - list.peekFirst().row + 1 > answer){
                answer = list.peekLast().row - list.peekFirst().row + 1;
                an = i;
            }
        }
        System.out.println(an);
        System.out.println(answer);
    }
   static void inorder(Node node){
       if(node != null){
            nowlevel++;
           inorder(node.left);
           infolist.get(nowlevel++).add(new Info(node.noden, iterator++));
           inorder(node.right);
       }   
       nowlevel--;
   }
}
/*
dfs 혹은 bfs로
훑고 내려가면서 

LDR 방식 쓰면 되지않나?

각각의 노드가 어느 열에 위치하는지는
바로 알 수 있음.

ArrayList<LinkedList<>> 선언해서 
각 arraylist 구성요소마다 노드 레벨을
나타내게 해서
노드 레벨과  노드에 대한 열 위치 기록하고 
나중에 쫙 훑으면서 
각 linkedlist마다
가장 앞 것과 뒤에 것 빼서 답 출력,.
*/