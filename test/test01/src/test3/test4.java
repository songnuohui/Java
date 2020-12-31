package test3;
import java.util.Scanner;
public class test4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];//n行m个整数
        int sum=0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
                sum += arr[i][j];
            }
        }
        if(sum%2==1){
            System.out.println(0);
            return;
        }
    }

}
