package sorting;

public class BubbleSort {

	//requires swapping in each step so perfomr less efficiently  than selection sort
	//STable
	
	/*First Pass:
		( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
		( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
		( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
		( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

		Second Pass:
		( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
		( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
		( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
		( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
		Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

		Third Pass:
		( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
		( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
		( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
		( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )*/
	
	  void bubbleSort(int arr[]) 
	    /*{ 
	        int n = arr.length; //if length(n)= 5  {6, 3, 5, 2, 9}
	        for (int i = 0; i < n-1; i++) //will run 5 times. Outer loop must run n - 1 times
	            for (int j = 0; j < n-i-1; j++) //
	                if (arr[j] < arr[j+1]) //this is for sorting descending order. User > if want ascending order
	                { 
	                    // swap arr[j+1] and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j+1]; 
	                    arr[j+1] = temp; 
	                } 
	    } */
	  
	  
	  
	  {
		  
		
		  
		  
		  
		  
		  
		  
		  
		  
	  }
	  
	    /* Prints the array */
	    void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	        BubbleSort ob = new BubbleSort(); 
	        int arr[] = {6, 3, 5, 2, 9}; 
	        ob.bubbleSort(arr); 
	        System.out.println("Sorted array"); 
	        ob.printArray(arr); 
	    } 

}
