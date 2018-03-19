package com.developer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeDup {
	
	/**
	 * This method uses Stream api introduced in Java 8 and collect the list
	 * Then remove the element from list where it find duplicate
	 * and return the sorted array 
	 * A better solution is sort the array and then check each element to the one next to it to find duplicates. 
	 * Choose quick sort and this is O(n log n).
	 * @param input
	 * @return int[]
	 */
	public static int[] removeDuplicatesWithStream(int[] input) {
		// sort the array first with Quick sorting
		QuickSort.quickSort(input, input.length);
	    List<Integer> list=Arrays.stream(input).boxed().collect(Collectors.toList());
	    /**
	     * 
	     * the iteration over the list of size will be o(n)
	     */
	    for(int i=0;i<list.size();i++){ 
	    	 for(int j=list.size()-1;j>i;j--){
	            if(list.get(i)==list.get(j)){
	                list.remove(j); 
	          }
	         }
	    }
	    int[] array =new int[list.size()];
	    /**
	     * 
	     * the iteration over the list of size will be o(n)
	     */
	    for(int i=0;i < list.size();i++){
	        array[i]=(int)list.get(i);
	    }
	    return array;
	}
		/**  This can be done in amortized O(n) using a hashset-based set.
        * . Create a hashtable based solution with O(1) access. Traverse the original list.
        *    If it is not in the hashset already, 
        *   add it to the result array and add it to the hash table. If it is in the hash table, ignore it.
        * if we need to retain the original order
        */
	public static int[] removeDupUsingHashSet(int [] input){
			Set<Integer> hashSet = new HashSet<Integer>();
			for (Integer num : input) {
				hashSet.add(num); // this invoke H.contains(num) so it will not change the order
			}
			int result[] = new int[hashSet.size()];
			int counter = 0;
			for(Integer val : input){
				if (hashSet.contains(val)){
				    result[counter++]=val;
					hashSet.remove(val);
				}
			}
			return result;
		}
		
	/**
	 * A better solution is sort the array and then check each element to the 
	 *  one next to it to find duplicates. 
	 *  Choose an efficient sort and this is O(n log n).
        The disadvantage with the sort-based solution is order is not maintained. 
        An extra step can take care of this however.
	 * 
	 * @param input
	 * @return
	 */
		// Create an array with all unique elements
	public static int[] removeDuplicatesWithNewArr(int[] input) {
		// sort the array first with Quick sorting
		QuickSort.quickSort(input, input.length);
		if (input.length < 2)
			return input;
	 	int j = 0;
		int i = 1;
	 	while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				j++;
				input[j] = input[i];
				i++;
			}
		}
	 	int[] returnArr = Arrays.copyOf(input, j + 1);
	 	return returnArr;
	}
	
	public static void main(String args []){
		
		int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
				20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
				13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
		int[] returnArray=DeDup.removeDupUsingHashSet(randomIntegers);
		//For order ;
		 for (int num : returnArray){
			System.out.println("the value of iteration match in order with new array "+num);
		}
	}
	
}
