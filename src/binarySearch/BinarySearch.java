package binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
	
		int[] arr = {4, 11, 2, 7, 12, 5, 9}; //sorted 2 4 5 7 9 11 12 
		bubbleSort(arr);
		System.out.println(binarySearchIteration(arr, 12));
	   // search(arr, 12);
		printArray(arr);

	}
	
	 /* Prints the array */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	
	static void bubbleSort(int arr[]) 
    { 
        int n = arr.length; //if length(n)= 5  {6, 3, 5, 2, 9}
        for (int i = 0; i < n-1; i++) //will run 5 times. Outer loop must run n times
            for (int j = 0; j < n-i-1; j++) //
                if (arr[j] > arr[j+1]) //this is for sorting descending order. User > if want ascending order
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
	
	static void search(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		System.out.println(binarySearch(arr, key, low, high));
		
	}
	
	//Iterative
	
	static int binarySearchIteration(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		int mid ; 
		
		while (low <= high  ) {
		     mid = (low + high)/2;
			
			if(key == arr[mid]) return key;
			else if(key  < arr[mid]) high = mid-1;
			else  low = mid+1;
			
			
		}
		
		return -1;
		
		
	}
	
	//recursion
	static int binarySearch(int[] arr, int key, int low, int high) {
		
		//int[] arr = {4, 11, 2, 7, 12, 5, 9}; 2 4 5 7 9 11 12 
		
		if(high < low  )  return -1;
		
		int mid = (low + high)/2;
		
		if(key == arr[mid]) return key;
		else if(key  < arr[mid]) return binarySearch(arr, key, low, mid - 1);
		else return binarySearch(arr, key, mid+1, high);
		
	}
 

}
