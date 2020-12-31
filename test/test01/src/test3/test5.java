package test3;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
public class test5 {

    static int N=3;
    static int arr[]=new int[2*N];
    static int ants;
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];*/
        dfs(0,0);
        System.out.println(ants);
    }

    private static boolean adj(int x, int y) {
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (y - x == N || y - x == N + 1 || y - x == N - 1 || y - x == 1&&x%N!=0) {
            return true;
        }
        return false;
    }

    private static boolean check() {
        Set<Integer> set = new ConcurrentSkipListSet<Integer>();
        set.add(arr[0]);
        for (int i = 0; i < 2*N-1; i++) {
            for (int k = 1; k<2*N; k++) {
                for (int x : set) {
                    if (adj(arr[k], x)) set.add(arr[k]);
                }
            }
        }
        return set.size() ==2*N;
    }

    public static void dfs( int x, int pre) {
        if (x == arr.length) {
            if (check()) ants++;
            return;
        }
        for (int i = pre + 1; i <=2*N; i++) {
            arr[x] = i;
            dfs( x + 1, i);
        }
    }
}
