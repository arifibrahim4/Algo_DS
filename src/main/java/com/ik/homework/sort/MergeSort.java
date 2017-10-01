/**
 * 
 */
package com.ik.homework.sort;

/**
 * @author Arif
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,6,1,5,8,2};
		int[] res=MergeSort(arr);
		for(int i:res)
			System.out.println(i);
	}
	
	static int[] MergeSort(int[] intArr) {
        mergSort(intArr,0,intArr.length-1);
        return intArr;
    }

    private static void mergSort(int[] arr, int s, int l){
        if(s>=l)
            return;
        int mid =s+(l-s)/2;
        mergSort(arr,s,mid);
        mergSort(arr,mid+1,l);
        merge(arr,s,mid,l);
    }

    private static void merge(int[] arr,int s, int mid, int l){
        int[] res=new int[arr.length];
        int i=s;
        int j=mid+1;
        int count=s;
        while(s<=mid && j<=l){
            if(arr[s]<arr[j]){
                res[count]=arr[s];
                s++;
            }else{
                res[count]=arr[j];
                j++;
            }
            count++;
        }
        while(s<=mid){
            res[count++]=arr[s++];
        }
        while(j<=l){
            res[count++]=arr[j++];
        }
        arrCopy(arr,res,i,l);
    }

    private static void arrCopy(int[] arr, int[] res,int s,int l){
        for(int count=s; count<=l; count++){
            arr[count]=res[count];
        }
    }



}
