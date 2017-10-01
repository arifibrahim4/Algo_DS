/**
 * 
 */
package com.ik.homework.sort;

import java.util.Scanner;

/**
 * @author Arif
 * Arrange Nuts & Bolts
 * Nuts can't be compared with Nuts
 * Bolts can't be compared with Bolts
 * Input:
 * 		N2,N1,N3,N5
 * 		B5,B3,B1,B2
 * Output: 
 * 		  N1 B1
 * 		  N2 B2
 *  		  N3 B3
 *  		  N4 B4
 */
/*
N2,N1,N3,N5
B5,B3,B1,B2

*/
public class ArrangeNutsNBolts {
	
	public static void main(String args[] ) throws Exception {
        Scanner scan=new Scanner(System.in);
        String[] nuts=scan.next().split(",");
        String[] bolts=scan.next().split(",");
        arrange(nuts,bolts,0,nuts.length-1);
        for(int i=0; i<nuts.length; i++){
            System.out.println(nuts[i]+" "+bolts[i]);
        }
    }
    
    private static void arrange(String[] nuts, String[] bolts, int s, int l){
        if(s<l){
            int p=partition(nuts,bolts,s,l);
            arrange(nuts,bolts,s,p-1);
            arrange(nuts,bolts,p+1,l);
        }
    }
    
    private static int partition(String[] nuts, String[] bolts, int s, int l){
        int p=s;
        int i=s;
        int j=l;
        p=subPartition(nuts,i,j,bolts[p]);
        return subPartition(bolts,i,j,nuts[p]); 
    }
    
    private static int subPartition(String[] arr,int i, int j, String val){
        int index=i;
        int p=i;
        while(i<=j){
            if(compare(arr[i],val)>0){
                swap(arr,i,j);
                j--;
            }else if(compare(arr[i],val)<0){
                i++;
            }else{
                index=i;
                i++;
            }
        }
        swap(arr,j,index);
        return j;
    }
    
    private static void swap(String[] arr,int i,int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    private static int compare(String s1, String s2){
        return s1.substring(1).compareTo(s2.substring(1));
    }
    


}
