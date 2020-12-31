package test3;

import java.util.Arrays;

public class 线性探测法 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] len2arr=new int[7];
        int[] mid= {28,14,20,45,12,6};
        int success=0;
        int fail=0;
        for(int i=0;i<mid.length;i++) {
            if(len2arr[(mid[i]*2)%7]==0) {
                len2arr[(mid[i]*2)%7]=mid[i];
                success++;
            }
            else {
                int j=(mid[i]*2)%7;
                while(true) {
                    if(j<len2arr.length) {
                        if(len2arr[j]!=0) {
                            success++;
                        }
                        else {
                            len2arr[j]=mid[i];
                            success++;
                            break;
                        }
                    }
                    else if(j>=len2arr.length){
                        j-=len2arr.length;
                        j--;
                    }
                    j++;
                }

            }
        }
        System.out.println(success+"/"+mid.length);
        System.out.println(Arrays.toString(len2arr));
		/*int index=0;
		for(int i=0;i<len2arr.length;i++) {
			if(len2arr[i]==0) {
				index=i;
			}
		}
		for(int i=0;i<len2arr.length;i++) {
			if(i<=index) {
				fail+=(index-i)+1;
			}
			else {
				fail+=(len2arr.length-i)+index+1;
			}

		}*/
        int touindex=0;
        for(int i=0;i<len2arr.length;i++) {
            if(len2arr[i]==0) {
                touindex=i;
                break;
            }
        }
        int index=-1;
        for(int i=0;i<len2arr.length;i++) {
            if(len2arr[i]==0) {
                for(int j=index+1;j<=i;j++) {
                    fail+=(i-j)+1;
                }
                index=i;
            }
        }
        for(int i=index+1;i<len2arr.length;i++) {
            fail+=(len2arr.length-i)+touindex+1;
        }
        System.out.println(fail+"/"+len2arr.length);

    }

}

