package test3;
import java.util.Scanner;
import java.util.Arrays;
public class test3 {
    public static void main(String[] args) {
        int count=0;
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int A[]=new int[N];
        int B[]=new int[N];
        int C[]=new int[N];
        for (int i=0;i<N;i++){
            A[i]=scanner.nextInt();
        }
        for (int i=0;i<N;i++){
            B[i]=scanner.nextInt();
        }
        for (int i=0;i<N;i++){
            C[i]=scanner.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        for (int a=0;a<N;a++){
            for (int b=0;b<N;b++){
                    for (int c=0;c<N;c++){
                        if (A[a]<B[b]&&B[b]<C[c]){
                            count++;
                        }
                    }
            }
        }
        System.out.println(count);
    }
}
