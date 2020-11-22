package sorting;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int[] arr = {4, 6,  8, 10, 5, 9, 3, 7};
	
	heapSort(arr);
	System.out.println("Sorted array is"); 
    
	printArray(arr);
	
	
	
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	
	
	
	private static void heapSort(int[] arr) {
		
		 int n = arr.length;
		
		//build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(arr, n, i);
	      }
		
		//sort
		for (int i = n - 1; i >= 0; i--) {
	        int temp = arr[0];
	        arr[0] = arr[i];
	        arr[i] = temp;
	  
	        // Heapify root element
	        heapify(arr, i, 0);
	      }
	}
	
	
	
	private static void heapify(int[] arr, int n, int i) {
		
		 // Find largest among root, left child and right child
	      int largest = i;
	      int l = 2 * i + 1;
	      int r = l + 1;
	  
	      if (l < n && arr[l] > arr[largest])
	        largest = l;
	  
	      if (r < n && arr[r] > arr[largest])
	        largest = r;
	  
	      // Swap and continue heapifying if root is not largest
	      if (largest != i) {
	        int swap = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = swap;
	  
	        heapify(arr, n, largest);
	      }
			
			
		}
		
		
		
	}
	
	
	

