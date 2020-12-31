package test3;
import java.util.*;
/**
 * 题目描述
 * 设某汉字由N × N的0和1的点阵图案组成。
 *
 * 我们依照以下规则生成压缩码。连续一组数值：从汉字点阵图案的第一行第一个符号开始计算，
 * 按书写顺序从左到右，由上至下。第一个数表示连续有几个0，第二个数表示接下来连续有几个1，
 * 第三个数再接下来连续有几个0，第四个数接着连续几个1，以此类推……
 *
 * 例如: 以下汉字点阵图案：
 *
 * 0001000
 * 0001000
 * 0001111
 * 0001000
 * 0001000
 * 0001000
 * 1111111
 * 对应的压缩码是： 7 3 1 6 1 6 4 3 1 6 1 6 1 3 7
 * （第一个数是N ,其余各位表示交替表示0和1 的个数，压缩码保证 N×N = 交替的各位数之和）
 *
 * 输入格式
 * 汉字点阵图（点阵符号之间不留空格）。（3<=N<=200）
 *
 * 输出格式
 * 一行，压缩码。
 *
 * 输入输出样例
 * 输入 #1 复制
 * 0001000
 * 0001000
 * 0001111
 * 0001000
 * 0001000
 * 0001000
 * 1111111
 * 输出 #1 复制
 * 7 3 1 6 1 6 4 3 1 6 1 6 1 3 7
 * **/
public class P1320 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        int n=s.length();int ans=1;
        for (int i=0;i<n-1;i++){
            String s1=scanner.next();
            s=s+s1;
        }
        System.out.println(s);
        System.out.print(n);
        char [] chars=new char[(n*n)+1];
        int j=0;
        for (char ch:s.toCharArray()
             ) {
            chars[j]=ch;
            j++;
        }
        chars[j]='a';
        if (chars[0]=='1'){
            return;
        }
        for(int i=0;i<n*n;i++){
            if (chars[i]==chars[i+1]){
                ans++;
            }
            else{
                System.out.print(" "+ans);
                ans=1;
            }
        }
    }
}
