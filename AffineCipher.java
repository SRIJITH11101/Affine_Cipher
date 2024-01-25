package AC;
import java.util.*;
public class AffineCipher {


    static int inverse(int a,int b,int t1,int t2){
        if(a%b==0){
            if(t2<0)
                return 26+t2;
            else
                return t2;
        }
        //t1=t2;
        //t2=t1-((a/b)*t2);
        return inverse(b,a%b,t2,(t1-((a/b)*t2)));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int j=0,in=0,oi=0;
        int newidx=0;
        int orgidx=0;
        int t1=0,t2=1; 
        String es="";
        char ar[]=new char[26];
        for (char i = 'A'; i <= 'Z'; i++,j++) {
            ar[j]=i; 
        }
        System.out.println("Enter the sentence to be enrypted");
        String ps=sc.nextLine();
        ps=ps.toUpperCase();
        System.out.println("Enter the a and b constant value");
        int a=sc.nextInt();
        int b=sc.nextInt();
        for(int i=0;i<ps.length();i++){
            char x=ps.charAt(i);
            for(int z=0;z<ar.length;z++){
                if(x==ar[z]) {
                    newidx=((a*z)+b)%26;
                    es=es+ar[newidx];
                }
            }
        }
        System.out.println("Encrypted Text : "+es);
        in=(inverse(26,a,0,1));
        String os="";
        for(int i=0;i<es.length();i++){
            char x=es.charAt(i);
            for(int z=0;z<ar.length;z++){
                if(x==ar[z]) {
                    //System.err.println(in);
                    oi=(in*(z-b));
                    if(oi<0)
                        orgidx=26-(-oi)%26;
                    else
                        orgidx=oi%26;
                    os=os+ar[orgidx];
                }
            }
        }
        System.out.println("Decrypted Text : "+os);
        sc.close();
    }
}