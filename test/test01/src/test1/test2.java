package test1;

import java.util.Scanner;

public class test2 {
    public static boolean cha(char[] chars){
        for (int i=0;i<chars.length;i++){
            if(chars[i]=='P'||chars[i]=='A'||chars[i]=='T'){
                System.out.println("yes");
                return false;
            }
            else {
                System.out.println("no");
                return true;
            }
        }
        return true;
    }
    public static boolean check(String [] strings){
        for (String s:strings) {
            char [] chars=new char[s.length()];
            for (int i=0;i<s.length();i++){
                chars[i]=s.charAt(i);
            }
            cha(chars);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        if(num>=0&&num<10){
            String[] strings=new String[num];
            for(int i=0;i<num;i++){
                String s=scanner.next();//将字符存入string数组中
                if(s.length()>100){
                    System.out.println("字符串长度超出了100");
                    return;
                }else {
                    strings[i]=s;
                }
            }
           /* for (String s:strings
            ) {
                System.out.println(s);
            }*/
           check(strings);
        }
        else{
            System.out.println("只能输入十个字符串以内！");
            return ;
        }
    }
}
