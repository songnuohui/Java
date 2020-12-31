package test2;
import java.util.Arrays;
public class HeapSort {
    public static void main(String[] args) {
        int []arr = {7,6,11,5,12,3,0,1};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void BigHeap(int[]arr){
        for(int i=arr.length/2-1;i>=0;i--){
            AdjustHeap(arr,i,arr.length);
        }
    }
    private static void AdjustHeap(int[]arr,int k,int len){
        int temp=arr[k];
        for(int i=2*k+1;i<len;i=i*2+1){
            if(i+1<len&&arr[i]<arr[i+1]){
                i++;
            }
            if(arr[i]>temp){
                arr[k]=arr[i];
                k=i;
            }
            else  break;
        }
        arr[k]=temp;
    }
    private static void Swap(int[]arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    private static void Sort(int[] arr){
        BigHeap(arr);
        for (int i=arr.length-1;i>0;i-- ){
            Swap(arr,0,i);
            AdjustHeap(arr,0,i);
        }
    }
}
