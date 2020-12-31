package test2;
import java.util.Stack;
/**组合**/
public class test {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        Stack stack=new Stack();
        ZuHe(stack,arr,3,0,0);
    }

    private static void ZuHe(Stack stack, int[] arr, int n, int cur, int m){
        /**
         * n:选取元素个数
         * cur：当前含有的元素个数
         * m:数组下标
         * **/
        if(cur==n){
            System.out.println(stack);
            return ;
        }
        for(int i=m;i<arr.length;i++) {

            if (!stack.contains(arr[i])) {        //重复的不进栈
                stack.push(arr[i]);
                ZuHe(stack, arr, n, cur + 1, i);
                stack.pop();
            }
        }
    }
}
