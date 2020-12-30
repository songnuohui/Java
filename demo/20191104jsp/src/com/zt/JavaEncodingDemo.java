package com.zt;
import java.net.URLEncoder;
import java.net.URLDecoder;
public class JavaEncodingDemo {
      public static void main(String[] args) {
		String s="½ñÍí8µã½ø¹¥";
		String s2=URLEncoder.encode(s);
		System.out.println(s2);
		String s3=URLDecoder.decode(s2);
		System.out.println(s3);
	}
}
