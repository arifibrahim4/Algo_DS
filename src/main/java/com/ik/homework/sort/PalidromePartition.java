package com.ik.homework.sort;

import java.util.ArrayList;

public class PalidromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr=palindromicDecomposition("aab");
		for(String s:arr) {
			System.out.println(s);
		}
		
	}
	
	static String[] palindromicDecomposition(String s) {
        if(s==null || s.isEmpty())
            return null;
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        ArrayList<String> curr=new ArrayList<String>();
        palindromicDecomposition(s,res,curr,0);
        int c=0;
        String[] arr=new String[res.size()];
        for(ArrayList<String> strList:res){
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<strList.size(); i++){
                sb.append(strList.get(i));
                if(i<strList.size()-1)
                    sb.append("|");
            }
            arr[c]=sb.toString();
            c++;
        }
        return arr;
    }

    static void palindromicDecomposition(String s,ArrayList<ArrayList<String>> res, ArrayList<String> curr,int pos){
        if(pos==s.length()){
            ArrayList<String> temp=(ArrayList<String>)curr.clone();
            res.add(temp);
            return;
        }
        
        for(int i=pos; i<s.length(); i++){
        		String subStr=s.substring(pos,i+1);
        		if(isPalidrome(subStr)) {
        			 curr.add(subStr);
                 palindromicDecomposition(s,res,curr,i+1);
                 curr.remove(curr.size()-1);
        		}
        }
        
    }
    
    static boolean isPalidrome(String s) {
    		int i=0;
    		int j=s.length()-1;
    		while(i<=j) {
    			if(s.charAt(i)!=s.charAt(j)) {
    				return false;
    			}
    			i++;
    			j--;
    		}
    		return true;
    }
    

}
