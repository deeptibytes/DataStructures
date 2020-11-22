package sorting;

public class MergeSort {
	
	
	 public static void main(String args[]) 
	    { 
	        MergeSort ob = new MergeSort(); 
	        int arr[] = {6, 3, 5, 2, 9}; 
	        ob.mergeSort(arr, 0, arr.length-1); 
	        System.out.println("Sorted array"); 
	       // ob.printArray(arr); 
	    } 
	 
	 
	/*  Prints the array 
	    void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	 
	
	void merge(int Arr[], int start, int mid, int end) {

		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start, j = mid+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		while(i <= mid) {
			temp[k] = Arr[i];
			k += 1; i += 1;
		}

		// add elements left in the second interval 
		while(j <= end) {
			temp[k] = Arr[j];
			k += 1; j += 1;
		}

		// copy temp to original interval
		for(i = start; i <= end; i += 1) {
			Arr[i] = temp[i - start];
		}
	}

	// Arr is an array of integer type
	// start and end are the starting and ending index of current interval of Arr

	 // int arr[] = {6, 3, 5, 2, 9}; 
	void mergeSort(int Arr[], int start, int end) {

		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(Arr, start, mid);
			mergeSort(Arr, mid+1, end);
			merge(Arr, start, mid, end);
		}
	}*/
	 

	 public static void mergeSort(int[] arr, int start, int end) {
		 
		 if(start<end) {
			 
			int mid = (start + end) /2;		 
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);			 
		 } 
	 }
	 
	 public static void merge(int[] arr, int start, int mid, int end) {
		 
		 //merge the two lists
		 
		 int i = start;
		 int j = mid+1;
		 
		 int[] tmpAr = new int[(end-start)+1];
		 int k =0;
		 
		 while(i<=mid && j<=end) {
			 
			 if(arr[i]<=arr[j]) {
				 tmpAr[k] = arr[i];	
				 i++;
			 }else {
				 tmpAr[k] = arr[j];	
				 j++;
			 }
			 k++;
			 
		 }
		if(i<mid) {
			while(i<=mid) {
				 tmpAr[k] = arr[i];	
				 i++;
				 k++;
				 
			 }
		}else if(j<end) {
			 while(j<=end) {
				 tmpAr[k] = arr[j];	
				 j++;
				 k++;
				 
			 }
			
		}
		
		
		 
		
		 

			// copy temp to original interval
		 
		 //First Way
			for(i = start; i <= end; i += 1) {
				//Arr[i] = temp[i - start];
			}
			//Second Way
		 k=0;
		 for( k=0; k<tmpAr.length; k++) {
			 
			 arr[start+k]=tmpAr[k];
		 }
	 }
	
	

}
