package com.tools;

import java.io.UnsupportedEncodingException;

public class MyFuns {
     public static String convert2utf8(String s){
    	 if(s==null) return null;
    	 try {
			s=new String(s.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return s;
     }
     public static int string2Int(String s){
    	 if(s==null)return 0;
    	 try{
    		 return Integer.parseInt(s);
    	 }catch(Exception e){
    		// e.printStackTrace();
    	 }
    	 return 0;
     }
     public static String htmlspecialchars(String str) {
    	 if(str==null) return null;
    		str = str.replaceAll("&", "&amp;");
    		str = str.replaceAll("<", "&lt;");
    		str = str.replaceAll(">", "&gt;");
    		str = str.replaceAll("\"", "&quot;");
    		return str;
       }
   
}