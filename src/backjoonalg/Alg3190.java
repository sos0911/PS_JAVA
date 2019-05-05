package backjoonalg;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.LinkedList;
class chstatus{
    private int sc;
    private char dir;
    public chstatus(int sc, char dir){
        this.sc = sc;
        this.dir = dir;
    }
    int getsc(){
        return sc;
    }
    char getdir(){
        return dir;
    }
}
class point{
    private int x;
    private int y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    void chXY(int x, int y){
        this.x += x;
        this.y += y;
    }
    boolean equals(point p){
        if(x == p.x && y == p.y)
            return true;
        else
            return false;
    }
}
public class Alg3190 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeofB = Integer.parseInt(br.readLine());
        int NofA = Integer.parseInt(br.readLine());
        LinkedList<point> apples = new LinkedList<point>(); // 사과들
        StringTokenizer st;
        int tempx, tempy;
        for(int i = 0; i < NofA; i++){
            st = new StringTokenizer(br.readLine());
            tempy = Integer.parseInt(st.nextToken());
            tempx = Integer.parseInt(st.nextToken());
            apples.add(new point(tempx, tempy));
        }
        int Nofch = Integer.parseInt(br.readLine());
        chstatus[] stat = new chstatus[Nofch];
        for(int i = 0; i < Nofch; i++){
            st = new StringTokenizer(br.readLine());
            stat[i] = new chstatus(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
         point curdir = new point(1,0); // 현재 방향
        point curhead = new point(1,1); // 현재 머리 위치
        LinkedList<point> body = new LinkedList<point>(); // 머리를 포함한 몸 point들 저장
        body.addFirst(new point(curhead.getX(), curhead.getY()));
        int curT = 0; // 현재 시간
        int indofst = 0; // stat[]의 index
        boolean Isthapple = false; 
        point[][] dir = {{new point(1,0), new point(0,-1), new point(0,1)}, {new point(0,1), new point(1,0), new point(-1,0)}, {new point(0,-1), new point(-1,0), new point(1,0)}, {new point(-1,0), new point(0,1), new point(0,-1)}}; // 왼/오
        outerloop:
        while(curhead.getX() > 0 && curhead.getX() <= sizeofB && curhead.getY() > 0 && curhead.getY() <= sizeofB){
            curT++;
            curhead.chXY(curdir.getX(), curdir.getY()); // 머리 전진
             Iterator<point> it = body.iterator();
            while(it.hasNext())
                if(it.next().equals(curhead))
                    break outerloop; // 자기 몸과 닿으면 탈-출
            it = apples.iterator();
            while(it.hasNext()) // 사과 섭취
                if(it.next().equals(curhead)){
                    Isthapple = true;
                    it.remove();
                    break;
                }
            if(Isthapple == false && !body.isEmpty())
                body.removeLast(); // 꼬리 제거
            body.addFirst(new point(curhead.getX(), curhead.getY())); // 머리 추가
            Isthapple = false; // 원상복귀
            if(indofst < Nofch && curT == stat[indofst].getsc()){ // 방향 전환
                for(int i = 0; i < 4; i++){
                    if(curdir.equals(dir[i][0])){
                        if(stat[indofst].getdir() == 'L')
                            curdir = new point(dir[i][1].getX(), dir[i][1].getY());
                        else
                            curdir = new point(dir[i][2].getX(), dir[i][2].getY()); 
                        indofst++;
                        break;
                    }
                }
                }
        }
        System.out.println(curT);
    }
}
