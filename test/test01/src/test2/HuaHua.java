package test2;

import java.util.Scanner;
/**
 * 　A同学的学习成绩十分不稳定，于是老师对他说：“只要你连续4天成绩有进步，
 * 那我就奖励给你一朵小红花。”可是这对于A同学太困难了。于是，
 * 老师对他放宽了要求：“只要你有4天成绩是递增的，我就奖励你一朵小红花。”
 * 即只要对于第i、j、k、l四天，满足i<j<k<l并且对于成绩wi<wj<wk<wl，
 * 那么就可以得到一朵小红花的奖励。现让你求出，A同学可以得到多少朵小红花。
 * **/
public class HuaHua {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int score[]=new int[n];
        for(int i=0;i<n;i++){
            score[i]=scanner.nextInt();
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(score[i]<score[j])
                {
                    for(int p=j;p<n;p++)
                    {
                        if (score[j]<score[p])
                        {
                            for (int q=p;q<n;q++)
                            {
                                if (score[p]<score[q])
                                {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
