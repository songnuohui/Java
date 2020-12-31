package test2;

public class 振新中华DFS {
    public static void main(String[] args) {
        dfs(0,0);
        System.out.println(count);
    }
    /**
     * 4行5列，dfs
     * **/
    static int count=0;
    private static void dfs(int x,int y){
        if(x==3&&y==4){
            count++;
        }
        else {
            if(x<3&&y<=4)
                dfs(x+1,y);
            if(x<=3&&y<4)
                dfs(x,y+1);
        }
    }
}
