package alg_10;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

public class Alg1_3rdweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> link = new LinkedList<Integer>();
        int N = sc.nextInt();
        int M = sc.nextInt();
      
        for(int i = 1; i < N+1; i++)
            link.add(i);
        ListIterator<Integer> itr = link.listIterator();
        String temp;
        String answer = "<";
        while(!link.isEmpty()){
            for(int j = 0; j < M-1; j++){
                if(itr.nextIndex() == link.size()){
                    itr = link.listIterator();
                    itr.next();
                }
                else
                    itr.next();
            }
            if(link.size() == N)
                temp = String.valueOf(itr.next());
            else{
                if(itr.nextIndex() == link.size()){
                    itr = link.listIterator();
                    temp = ", " + itr.next();
                }
                else
                    temp = ", " + itr.next();
            }
            answer += temp;
            itr.previous();
            itr.remove();
        }
        answer += ">";
        System.out.println(answer);
    }
}
