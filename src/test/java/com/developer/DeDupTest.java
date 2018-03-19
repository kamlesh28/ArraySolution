package com.developer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class DeDupTest {
	
   	@Test
	public void removeDuplicatesWithStreamTest() {
   	  int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
             20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
             13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
  int length =randomIntegers.length;
  int[] returnArray=	DeDup.removeDuplicatesWithStream(randomIntegers);
		    assertEquals(1, returnArray[0]);
	        assertEquals(2,  returnArray[1]);
	        assertEquals(3,  returnArray[2]);
		for(int i=0 ; i <returnArray.length ;i++){
			for (int j=i+1; j<returnArray.length;j++){
				  assertFalse("Remove duplicate with Stream test failed", returnArray[i]==returnArray[j]);
				}
			}
		}
	
	@Test
	public void removeDupUsingHashSetTest() {
		int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
				20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
				13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

		int[] returnArray= DeDup.removeDupUsingHashSet(randomIntegers);
		for(int i=0 ; i <returnArray.length ;i++){
			for (int j=i+1; j<returnArray.length;j++){
				assertFalse("Remove duplicate with HashSet test failed", returnArray[i]==returnArray[j]);
			}
		}

		//For order ;
		List<Integer> list=new ArrayList<Integer>();
		int counter=0;
		for(int j=0 ; j<randomIntegers.length; j++){
			if(!list.contains(randomIntegers[j])){
				list.add(counter,randomIntegers[j]);
				counter++;
			}

		}
		Iterator<Integer> iterator=list.iterator();

		int count=0;
		while(iterator.hasNext()){
			assertTrue("Test the Order of the element by restoring the original", returnArray[count]==iterator.next());
			count++;
		}
    }
	
	
	@Test
	public void removeDuplicatesWithNewArrTest() {
		int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
	            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
	            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

		int[] returnArray=DeDup.removeDuplicatesWithNewArr(randomIntegers);
		for(int i=0 ; i <returnArray.length ;i++){
			for (int j=i+1; j<returnArray.length;j++){
				  assertFalse("Remove duplicate with New Array test failed", returnArray[i]==returnArray[j]);
				}
			}
		}
	

}
