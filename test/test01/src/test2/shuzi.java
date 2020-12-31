package test2;

public class shuzi {
    public static void main(String[] args) {
        int a=1,b=1,c=1;
        for(int i=3;i<20190324;i++){
            int sum=(a+b+c)%10000;
            a=b;b=c;c=sum;
        }
        System.out.println(c);
    }
    /*private static int shu(int n){
        if(n<=3)    return 1;
        else return shu(n-1)+shu(n-2)+shu(n-3);
    }*/
}
