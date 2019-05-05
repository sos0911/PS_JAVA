/*package alg_10;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

class points{
    private int x;
    private int y;
    
    public points(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    
    @Override
    public int compareTo(points p){ // Linkedlist형 3차원 배열 내 정렬을 위한 오버라이딩
        if(x > p.getX())
            return 1;
        if(x < p.getX())
            return -1;
        
        if(y > p.getY()) // x는 같다. y 비교 구문 시작
            return 1;
        if(y < p.getY())
            return -1;
        
        return 0; // x,y 전부 동일
    }
    
}

class Meats{
    private Stirng[] grid;
    private LinkedList<LinkedList<LinkedList<points>>> ts = new LinkedList<LinkedList<LinkedList<points>>>();
    private boolean[] WastherethisC;
    private LinkedList<Character> IstherethisC;
    private boolean[][] visited; // 방문했는지를 각 지접마다 저장하는 행렬
    
    public Meats(String[] grid, boolean[] WastherethisC, LinkedList<Character> IstherethisC){
        this.grid = grid;
        this.WastherethisC = WastherethisC;
        this.IstherethisC = IstherethisC;
        visited = new boolean[grid.length][grid[0].length];
    }
    
    void findmeat(int y, int x, char alphabet, int initialY, int initialX, int iterator){
        if(y < 0 || y > grid.length-1 || x < 0 || x > grid[0].length()-1) // base case 1 : 범위 벗어남
            return;
        if(visited[y][x]) // base case 2 : 이미 방문
            return;
        if(alphabet != grid[y].charAt(x)) // base case 3 : 문자가 원하는 문자가 아니다
            return;
        // 이 세 기저 사례가 아니라면 목록에 지점을 추가한다.
        ts.get(iterator).get(0).add(new points(initialY - y, initialX - x));
        visited[y][x] = true;
        findmeat(y+1, x, alphabet, initialY, initialX, iterator);
        findmeat(y, x+1, alphabet, initialY, initialX, iterator);
        findmeat(y, x-1, alphabet, initialY, initialX, iterator);
    }
    
    void MainstreamofFM(){ // 각 고깃덩이를 구해내는 메인 스트림
        int i = 0; // iterator
        for(int y = 0; y < grid.length; y++)
            for(int x = 0; x < grid[0].length(); x++)
                if(grid[y].charAt(x) != '.' && WastherethisC[grid[y].charAt(x) - 'a'] == false){
                    findmeat(y, x, grid[y].charAt(x), y, x, i);
                    WastherethisC[grid[y].charAt(x) - 'a'] = true;
                    i++;
                }
    }
    
    void rotatingmeat(){ // 고기를 90도 회전시키는 메소드
        
    }
    
}

public class Alg2_2ndweek {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int NofTC = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < NofTC; i++){
            int heightofG = sc.nextInt();
            int widthofG = sc.nextInt();
            String[] grid = new String[heightofG]; // 각 iterator마다 가로 한 줄씩 저장
            
            for(int j = 0; j < heightofG; j++)
               grid[j] = sc.nextLine();
            
         LinkedList<Character> IstherethisC = new LinkedList<character>();
            boolean[] WastherethisC = new boolean[26];
            Arrays.fill(WastherethisC, false);
            
           for(int y = 0; y < grid.length; y++)
            for(int x = 0; x < grid[0].length(); x++)
                if(WastherethisC[grid[y].charAt(x) - 'a'] == false){
                   WastherethisC[grid[y].charAt(x) - 'a'] = true;
                    IstherethisC.add(grid[y].charAt(x));
                }
            
            Meats mt = new Meats(grid, WastherethisC, IstherethisC);
            mt.MainstreamofFM();
    }
}
}
/*
상대 좌표에서 바로 90도 돌리기나 뒤집기 가능?
:: 정방좌표의 max 길이만 알면 가능
만약 3이라면

x += (max-1)-x
y는 그대로

90도 오른쪽으로 돌리는 건

temp = y;
y = x;
x = max-temp-1

y x
(0,0) > (0,2)
(1,0) >(0,1)
(1,1) > (1,1)
(2,0) > (0,0)
(0,1) > (1, 2)
===================
points[][][] 가능?

points[i]에는 고깃덩이 type i의 돌린 상대 좌표들을 저장
points[i][j]에는 고깃덩이 type i의 뒤집은 형태를 돌린 형태 중 j번의
상대 좌표들을 저장한다.

*/
