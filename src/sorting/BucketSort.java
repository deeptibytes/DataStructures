package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	/*
	 * https://www.netjstech.com/2019/01/bucket-sort-program-in-java.html
	 */
	private void bucketSort(int arr[], int len) {
		
		//array of arraylists (buckets)
		List<Integer>[] buckets = new ArrayList[len];
		
		//each element of array is initialized with empty arrayLists
		for(int i=0; i < len; i++) { 			
			buckets[i] = new ArrayList<Integer>();
		}
		
		
		//Add input array elements into the appropriate buckets(lists)
		for(int num: arr) {
			int bucketIDx = getHashValue(num);
			buckets[bucketIDx].add(num);			
		}
		
		//sort each bucket
		for(int i=0; i < len; i++) { 			
			Collections.sort(buckets[i]) ;
		}
		
		//finally take sorted bucket elements and put it in original array.
		int arrId = 0;
		for(int i=0; i < len; i++) { 			
			for(int j = 0; j < buckets[i].size(); j++) {
				arr[arrId++] = buckets[i].get(j);
				
			    
			}
		}
		
		
	}
	
	
	private int getHashValue(int value) {//if input array elements are decimals, multiply by 10
		
		return value/10;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[]{ 2, 5, 17, 1, 13, 15};
		System.out.println("Original array- " + Arrays.toString(arr));
		int len = arr.length;
		BucketSort obj = new BucketSort();
		obj.bucketSort(arr, len);
		System.out.println("After bucket Sort- " + Arrays.toString(arr));
		
		
		
	}

}
