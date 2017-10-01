/**
 * 
 */
package com.ik.homework.sort;

import java.util.ArrayList;

/**
 * @author Arif
 *
 */
public class MergeKSortedArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr= {{-1,-3,-5,-7},{-2,-6,-8,-10}};
        //System.out.println(findMissingNumber(arr));
		int[] res=mergearrays1(arr);
		for(int i:res) {
			System.out.println(i);
		}

	}
	
	static int[] mergearrays1(int[][] iarray) {
        ArrayList<Integer> heap=new ArrayList<Integer>();
        for(int i=0; i<iarray.length; i++){
            for(int j=0; j<iarray[i].length; j++){
                insert(heap,iarray[i][j]);
            }
        }
        
        int[] res=new int[heap.size()];
        for(int k=0; k<res.length; k++){
            res[k]=getMin(heap);
        }
        return res;
    }

    private static void insert(ArrayList<Integer> list,int val){
        list.add(val);
        heapifyUp(list,list.size()-1);
    }

    private static void heapifyUp(ArrayList<Integer> list,int pos){
        if(list.size()==1 || pos<0 || pos>=list.size())
            return;
        int parent=pos%2==0?(pos-2)/2:(pos-1)/2;
        if(parent>=0 && list.get(parent)>list.get(pos)){
            int temp=list.get(parent);
            list.set(parent,list.get(pos));
            list.set(pos,temp);
            heapifyUp(list,parent);
        }
    }

    private static int getMin(ArrayList<Integer> list){
        int res=list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        heapifyDown(list,0);
        return res;
    }

    private static void heapifyDown(ArrayList<Integer> list, int pos){
        if(pos==list.size()-1 ){
            return;
        }
        if(2*pos+1<=list.size()-1 && list.get(pos)>list.get(2*pos+1)){
            swap(list,pos,2*pos+1);
            heapifyDown(list,2*pos+1);
            //return;
        }
        
        if(2*pos+2<=list.size()-1 && list.get(pos)>list.get(2*pos+2)){
            swap(list,pos,2*pos+2);
            heapifyDown(list,2*pos+2);
            //return;
        }
    }

    private static void swap(ArrayList<Integer> list, int i, int j){
        int temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
	


}
