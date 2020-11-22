package sorting;

public class SelectionSort {
	
	//https://www.programiz.com/dsa/selection-sort
	//Unstable
	//Does not require much swapping as bubble
	
	    void sort(int arr[]) 
	    { 
	        /*int n = arr.length; //{6,2,1,5,7};
	  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) //will run 5 times
	        { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) {
	                if (arr[j] < arr[min_idx]) //arr[1] < arr[0]; 
	                    min_idx = j; 
	            }
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	         */
	    	
	    	for(int i =0; i<arr.length-1; i++) {
	    			    		
	    		int minIndex= i; 
	    		
	    		for(int j =i+1; j<arr.length; j++) {
	    			
	    			if(arr[j]<arr[minIndex]) {
	    				minIndex = j;
	    			}
	    		}
	    		
	    		//swap min with first index
	    		int tmp = arr[i];
	    		arr[i]= arr[minIndex];
	    		arr[minIndex] = tmp;
	    	}
	    	
	    	
	    	for(int i =0; i<arr.length-i-1; i++) {
	    		
	    		int maxIndex= i; 
	    		
	    		for(int j =i+1; j<arr.length-i; j++) {
	    			
	    			if(arr[j]>arr[maxIndex]) {
	    				maxIndex = j;
	    			}
	    		}
	    		
	    		//swap min with first index
	    		int tmp = arr[arr.length-1];
	    		arr[arr.length-1]= arr[maxIndex];
	    		arr[maxIndex] = tmp;
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
	  
	    // Prints the array 
	    void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	  
	    // Driver code to test above 
	    public static void main(String args[]) 
	    { 
	        SelectionSort ob = new SelectionSort(); 
	        int arr[] = {6,2,1,5,7}; 
	        ob.sort(arr); 
	        System.out.println("Sorted array"); 
	        ob.printArray(arr); 
	    }

}
