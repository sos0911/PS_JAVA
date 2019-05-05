package alg_10;
import java.util.Arrays;
import java.util.Scanner;

class Startend implements Comparable<Startend>{
    private int start;
    private int end;
    
    public Startend(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public int getstart(){
         return start;
    }
    public int getend(){
        return end;
    }
    
    @Override
    public int compareTo(Startend se){ // end 값으로 객체를 오름차순 정렬
        if(end > se.getend())
            return 1;
        if(end < se.getend())
            return -1;
        
        if(start > se.getstart()) // end가 동일할 때 비교 구문
            return 1;
        if(start < se.getstart())
            return -1;
        else
            return 0;
    }
    
}

public class Alg1_2ndweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Nofinputset = Integer.parseInt(sc.nextLine());
        Startend[] inputsetA = new Startend[Nofinputset];
        for(int i = 0; i < Nofinputset; i++){
            inputsetA[i] = new Startend(sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }
        Arrays.sort(inputsetA);
        int meetingendT = -1;
        int answer = 0;
        for(int i = 0; i < inputsetA.length; i++){
            if(meetingendT <= inputsetA[i].getstart()){
                meetingendT = inputsetA[i].getend();
                answer++;
            }
        } 
        System.out.println(answer);        
    }
}
