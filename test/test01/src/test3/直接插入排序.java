package test3;
import java.util.Scanner;
import java.util.Arrays;
public class 直接插入排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /*int n=scanner.nextInt();
        int []arr=new int[n];
        for (int i=1;i<n;i++){
            arr[i]=scanner.nextInt();
        }*/
        int []arr={0,49,38,65,97,76,13,27};
        InsertSort(arr);
        for (int i=1;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        //System.out.println(Arrays.toString(arr));
    }
    private static void InsertSort(int []arr){
        int i,j;
        for( i=2;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                arr[0]=arr[i];
                for ( j=i-1;arr[0]<arr[j];--j){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=arr[0];
            }
        }
    }
}
