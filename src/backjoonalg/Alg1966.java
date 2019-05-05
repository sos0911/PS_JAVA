/*package backjoonalg;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class PlusOrder{
    private int orderN;
    private boolean IsitTarget;
    
    public PlusOrder(int orderN, boolean IsitTarget){
        this.orderN = orderN;
        this.IsitTarget = IsitTarget;
    }
    
    int getorderN(){
        return orderN;
    }
    boolean getIsitTarget(){
        return IsitTarget;
    }
}

public class Alg1966 { // 미완..
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int NofTC = Integer.parseInt(br.readLine());
        for(int i = 0; i < NofTC; i++){
            Queue<PlusOrder> q = new LinkedList<PlusOrder>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Iterator it = q.iterator(); // queue의 iterator 사용
            int answer = 0; // 각 tc마다 쓰일 최종 답을 저장
            int Nofdocx = Integer.parseInt(st.nextToken());
            int indexoftarget = Integer.parseInt(st.nextToken());
            int TargetValue; // target의 value를 저장
            for(int j = 0; j < Nofdocx; j++)
                if(j == indexoftarget){
                     TargetValue = Integer.parseInt(br.readLine());
                q.add(new PlusOrder(TargetValue, true));
                }
                      else
                      q.add(new PlusOrder(Integer.parseInt(br.readLine()), false)); 
            while(it.hasNext){
                if(e.getorderN > TargetValue){
                    q.poll(e);
                    answer++;
                }
            }
            // 이 시점에서는 target과 똑같은 값을 가진 애들만 남게 됨
            it = q.iterator(); // iterator 초기화
             while(it.hasNext()){
                if(e.getIsitTarget){
                    q.poll(e);
                    answer++;
                }
            }
    }
}
}*/
