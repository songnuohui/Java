package com.zt.day2;

public class ArrayDemo02 {
     public static void main(String[] args) {
    	 int studentScore[][]={{1,2,3,4,5},
    	                       {79,63,86,92,58} 
    	                       };
    	 int studentScore2[][]={{1,79},{2,63},
    			                {3,86},{4,92},
    			                {5,58},
                                };
		
    	System.out.println(studentScore[0][0]);
    	System.out.println("-----------------");
    	for(int i=0;i<studentScore.length;i++){
    		for(int j=0;j<studentScore[i].length;j++){
    			System.out.println(studentScore[i][j]);
    		}
    	}
    	System.out.println("-----------------"); 
    	for(int i=0;i<studentScore[0].length;i++){
    	System.out.println(studentScore[0][i]+":"
    	                   +studentScore[1][i]);
    	}
	}
}
