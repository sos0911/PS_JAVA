package codejam;
import java.io.*;
import java.util.*;
class Solution3{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(sc.nextLine());
        int t=Integer.parseInt(st.nextToken());
         int n=Integer.parseInt(st.nextToken());
          int m=Integer.parseInt(st.nextToken());
        long[]q={5, 7, 9, 11, 13, 16, 17};
        long sum=1;
        for(int i=0;i<7;i++)
        sum*=q[i];
        for(int i=1;i<=t;i++){ // tc
            long ans=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<18;k++)
                bw.write(q[j]+" ");
                bw.newLine();
                bw.flush();
                st=new StringTokenizer(sc.nextLine());
                long temp=0;
                for(int k=0;k<18;k++)
                temp+=Long.parseLong(st.nextToken());
                ans+=sum/q[j]*xgcd(sum/q[j],q[j])*(temp%q[j]);
            }
            if((ans%=sum) > m){
                while(ans>m)
                    ans-=sum;
                bw.write(ans+"\n");
            }
            else
                bw.write(ans+"\n");
                bw.flush();
            if(Long.parseLong(sc.nextLine())==-1)
            break;
        }
        bw.close();
    }
   static Long xgcd(long a, long b){
        // as+bt=gcd(a,b);
        ArrayList<Long>s=new ArrayList<>();
        s.add((long)1); s.add((long)0);
          ArrayList<Long>t=new ArrayList<>();
        t.add((long)0); t.add((long)1);
        ArrayList<Long>r=new ArrayList<>();
        r.add(a); r.add(b);
        ArrayList<Long>q=new ArrayList<>();
        q.add(a/b);
        while(true){
            if(r.get(r.size()-2)%r.get(r.size()-1)==0)
            break;
            r.add(r.get(r.size()-2)%r.get(r.size()-1));
            s.add(s.get(s.size()-2)-s.get(s.size()-1)*q.get(q.size()-1));
            t.add(t.get(t.size()-2)-t.get(t.size()-1)*q.get(q.size()-1));
            q.add(r.get(r.size()-2)/r.get(r.size()-1));
        }
        return s.get(s.size()-1);
    }
}