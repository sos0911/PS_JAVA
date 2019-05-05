package alg_02_2019;
import java.util.*;
import java.io.*;
class Node{ // private 옵션 주지 않음.
    char data;
    Node left, right;
    public Node(char data){
        this.data = data;
        left = null;
        right = null;
    }
}
class BST{ // 순회 방법들 모아 놓음.
    Node root = null;
    public BST(Node root){
        this.root = root; // root는 A로 정해짐
    }
    void preorder(Node node){
        if(node != null){
         System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
        }
    }
    void inorder(Node node){
         if(node != null){
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
        }
    }
    void postorder(Node node){
         if(node != null){
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
        }
    }
}
public class Alg1991{
    static Node[] inputs; // input node들의 집합. 초기화는 null. index 0-
    public static void main(String[] args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NofN = Integer.parseInt(br.readLine());
        inputs = new Node[NofN]; 
        String temp;
        for(int i = 0; i < NofN; i++){
            temp = br.readLine();
            if(inputs[temp.charAt(0) - 'A'] == null) // 처음 선언
                inputs[temp.charAt(0) - 'A'] = new Node(temp.charAt(0));
            for(int j = 2; j <= 4; j += 2){
                if(temp.charAt(j) == '.')
                    continue;
            if(inputs[temp.charAt(j) - 'A'] == null) // 자식 처음 선언
                inputs[temp.charAt(j) - 'A'] = new Node(temp.charAt(j)); // 노드 생성
                if(j == 2) // 왼쪽 or 오른쪽 자식 이어주기
                    inputs[temp.charAt(0) - 'A'].left = inputs[temp.charAt(j) - 'A'];
                else
                    inputs[temp.charAt(0) - 'A'].right = inputs[temp.charAt(j) - 'A'];
            }
        }
        BST binary = new BST(inputs[0]);
         binary.preorder(binary.root);
        System.out.println("");
         binary.inorder(binary.root);
        System.out.println("");
        binary.postorder(binary.root);
        System.out.println("");
    }
}
