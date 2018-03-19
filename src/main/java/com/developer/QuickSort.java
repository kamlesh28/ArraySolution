package com.developer;


//Java program for implementation of QuickSort
public class QuickSort {

	
	private static void quickSortRecursive(int data[],int left,int right)
    // pre: left <= right
    // post: data[left..right] in ascending order
    {
        int pivot;   // the final location of the leftmost value
        if (left >= right) return;
        pivot = partition(data,left,right);    /* 1 - place pivot */
        quickSortRecursive(data,left,pivot-1); /* 2 - sort small */
        quickSortRecursive(data,pivot+1,right);/* 3 - sort large */
        /* done! */
    }
	
	 private static int partition(int data[], int left, int right)
	    // pre: left <= right
	    // post: data[left] placed in the correct (returned) location
	    {
	        while (true)
	        {
	            // move right "pointer" toward left
	            while (left < right && data[left] < data[right]) right--;
	            if (left < right) swap(data,left++,right);
	            else return left;
	            // move left pointer toward right
	            while (left < right && data[left] < data[right]) left++;
	            if (left < right) swap(data,left,right--);
	            else return right;
	        }
	    }
	 
	 public static void swap(int data[], int i, int j)
	    // pre: 0 <= i,j < data.length
	    // post: data[i] and data[j] are exchanged
	    {
	        int temp;
	        temp = data[i];
	        data[i] = data[j];
	        data[j] = temp;
	    }
	 /* The main function that implements quickSort()
     arr[] --> Array to be sorted,
     n  --> length of the array 
     post: the values in data[0..n-1] are in ascending order
	  
     */
	 public static void quickSort(int data[], int n)
	    {
		  // base case, arrays with 0 or 1 element are already "sorted"
		     if (n < 2){
			    return;
		     }
		    
			 quickSortRecursive(data,0,n-1);
	    }
	 
	 public static void main(String args[])
	    {
	        int data[] = {11,24,0,5,4};
	        int i;

	         quickSort(data,data.length);
	        for (i = 0; i < data.length; i++)
	        {
	            System.out.print(data[i]+" ");
	            if (((i+1) % 15) == 0) System.out.println();
	        }
	        System.out.println();
	        //System.out.println("swaps="+swaps+" compares="+compares);
	    }
  
}
