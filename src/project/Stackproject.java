package project;
import java.util.Scanner;
class NodeofS{
    int item;
    NodeofS link;
}
class LinkedStack{
    NodeofS top;
    
    public LinkedStack(){
        top = null;
    }
    
    void push(int item){
    NodeofS newnode = new NodeofS();
        newnode.item = item;
        newnode.link = top;
        top = newnode;
    }
    
    int pop(){
        if(empty() == 1)
            return -1;
        int item = top.item;
        top = top.link;
        return item;
    }
    
    int size(){
        if(empty() == 1)
            return 0;
        int sizeofS = 0;
        NodeofS temp = top;
        while(temp != null){
            temp = temp.link;
            sizeofS++;
        }
        return sizeofS;
    }
    
    int empty(){
        if(top == null)
            return 1;
        else
            return 0;
    }
    
    int top(){
        if(empty() == 1)
            return -1;
        else
            return top.item;
    }
}

public class Stackproject {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         int Nofinst = Integer.parseInt(sc.nextLine());
       LinkedStack s = new LinkedStack();
        String[] menus = {"push", "pop", "size", "empty", "top"};
        String[] inputs = new String[Nofinst];
        for(int i = 0; i < Nofinst; i++)
            inputs[i] = sc.nextLine();
            
        for(int i = 0; i < Nofinst; i++){
             if(inputs[i].length() > 4)
                if(inputs[i].substring(0, 4).equals(menus[0]))
                   s.push(Integer.parseInt(inputs[i].substring(5, inputs[i].length())));
                   
            if(inputs[i].equals(menus[1]))
              System.out.println(s.pop());
            
             if(inputs[i].equals(menus[2]))
                 System.out.println(s.size());
            
             if(inputs[i].equals(menus[3]))
                System.out.println(s.empty());
            
                if(inputs[i].equals(menus[4]))
                   System.out.println(s.top());
        }
    }
}
