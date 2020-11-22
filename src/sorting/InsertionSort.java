package sorting;

public class InsertionSort {




/*Function to sort array using insertion sort*/
void sort() 
{ 
	
	
	/*// Insertion sort in Java

	int array[] = { 2, 9, 11, 5, 6 }; 
	    int size = array.length;

	    for (int step = 1; step < size; step++) {
	      int key = array[step];
	      int j = step - 1;

	      // Compare key with each element on the left of it until an element smaller than
	      // it is found.
	      // For descending order, change key<array[j] to key>array[j].
	      while (j >= 0 && key < array[j]) {
	        array[j + 1] = array[j];
	        --j;
	      }

	      // Place key at after the element just smaller than it.
	      array[j + 1] = key;
	    }
	  */
	
	
	
	
	
	
	 int arr[] = { 2, 9, 11, 5, 6 }; 
	 
	for(int i =1; i<arr.length; i++) {
		int key = arr[i];
		int j = i-1;
		
		while(arr[j]>key && j>=0) {
			
			arr[j+1]= arr[j];
			j= j-1;
			
		}
		arr[j+1] = key;
		
	}
	
} 

/* A utility function to print array of size n*/
static void printArray(int arr[]) 
{ 
    int n = arr.length; 
    for (int i = 0; i < n; ++i) 
        System.out.print(arr[i] + " "); 

    System.out.println(); 
} 

// Driver method 
public static void main(String args[]) 
{ 
    int arr[] = { 2, 9, 11, 5, 6 }; 
    //arr[1]= arr[0];

    InsertionSort ob = new InsertionSort(); 
    ob.sort(); 

    printArray(arr); 
} 
} 


