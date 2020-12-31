package test3;
/**
 * 【问题描述】
 *
 *     上小学的时候，小明经常自己发明新算法。一次，老师出的题目是：
 *
 *
 *
 *     1/4 乘以 8/5
 *
 *
 *
 *     小明居然把分子拼接在一起，分母拼接在一起，答案是：18/45
 * **/
public class test2 {
    public static void main(String[] args) {
        int count=0;
     for (int i=1;i<10;i++){
         for(int j=1;j<10;j++){
             if(i!=j){
                 for (int m=1;m<10;m++){
                     for(int n=1;n<10;n++){
                         if(m!=n){
                             if(i*m*Integer.parseInt(""+j+n)==j*n*Integer.parseInt(""+i+m)){
                                 count++;
                                 System.out.println(""+i+j+m+n);
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
