package alg_10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

class orderString implements Comparable<orderString>{
  private int order;
    private String word;
    
    public orderString(int order, String word){
        this.order = order;
        this.word = word;
    }
    @Override
    public int compareTo(orderString o){
        int i = 1;
        while(i <= word.length() && i <= o.word.length()){
            if(word.charAt(word.length() - i) > o.word.charAt(o.word.length() - i))
                return 1;
            else{
            if(word.charAt(word.length() - i) < o.word.charAt(o.word.length() - i))
                return -1;
                else{
                    i++;
                    continue;
                }
            }
        }
        if(i == word.length() + 1)
            return -1;
        else
            return 1;
    }
    public int getOrder(){
        return order;
    }
    public void setOrder(int order){
        this.order = order;
    }
     public String getWord(){
        return word;
    }
    public void setOrder(String word){
        this.word = word;
    }
}
class SegmentTree{
    private long[] segment;
    
    public long[] getSegment(){
        return segment;
    }
    public void setSegment(long[] segment){
        this.segment = segment;
    }
    public SegmentTree(int Nofinput){
        int temp = Nofinput;
        int temp2 = 1;
        while(temp > 1){
            temp = temp >> 1;
            temp2 = temp2 << 1;
        }
        segment = new long[temp2 << 2];
        Arrays.fill(segment, 0);
    }
    
    long query(int node, int start, int end, int left, int right){
        if(left > end || right < start)
            return 0;
        if(left <= start && end <= right)
            return segment[node];
        return query(node*2, start, (start + end)/2, left, right) + query(node*2 + 1, (start + end)/2 + 1, end, left, right);
    }
    void update(int node, int start, int end, int index, int val){
        if(index < start || index > end)
            return;
        segment[node] += val;
        if(start != end){
            update(node*2, start, (start+end)/2, index, val);
            update(node*2 + 1, (start+end)/2 + 1, end, index, val);
        }
    }
}
public class Alg2_1stweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofinput = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[Nofinput];
        for(int i = 0; i < Nofinput; i++)
            inputs[i] = sc.nextLine();
        Arrays.sort(inputs);
        orderString[] rsinputs = new orderString[Nofinput];
        for(int i = 0; i < Nofinput; i++)
            rsinputs[i] = new orderString(i, inputs[i]);
        Arrays.sort(rsinputs);
        long answer = 0;
        SegmentTree st = new SegmentTree(Nofinput);
        for(int i = 0; i < Nofinput; i++){
            answer += st.query(1, 0, Nofinput - 1, rsinputs[i].getOrder(), Nofinput - 1);
            st.update(1, 0, Nofinput - 1, rsinputs[i].getOrder(), 1);
        }
        System.out.println(answer);
    }
}
