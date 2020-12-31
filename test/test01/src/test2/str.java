package test2;
import java.util.HashSet;
import java.util.Set;
public class str {
    public static void main(String[] args) {
        String string="0100110001010001";
        Set set = new HashSet();
        for(int i=0;i<string.length();i++){
            for(int j=i+1;j<string.length()+1;j++){
                set.add(string.substring(i,j));
            }
        }
        System.out.println(set.size());
    }
}
