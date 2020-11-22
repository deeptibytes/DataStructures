package heaps;

public class MaxHeap {


int maxSize;
Node[] heapArray;
int currentSize;
//Node node;


public MaxHeap(int size) {
  this.maxSize = size;
  this.heapArray = new Node [size];
  currentSize = 0;

}


public void display(int[] arr, String action) {
	System.out.println("Before "+action);
	for(int i=0; i<arr.length; i++) {
		System.out.println(arr[0]);
		System.out.println("  ");
		
	}
	
	System.out.println("Before "+action);
	for(int i=0; i<arr.length; i++) {
		System.out.println(arr[0]);
		System.out.println("  ");
		
	}
	
}

public Node remove() {//removal done from top
	
	//removal is done at the top
	
	/*heapArray: 20 16 17  10  8 6  9  
	maxSize = 7, last index maxSize-1
	
	               20 (index 0)
	            
	        16               17
	        
	  10          8     6            9 index (maxSize=1)
	
	
	
	0. put last element of array to root position. 
	1. calculate left and right child
	2. Determine which one is larger. 
	3. Put larger child element in root position.
	4. Reassign rootElmtIdx to the index of larger child
	5. repeat steps 1 to 4 till reaches last second level of tree
	6. If none of the children are > root, exit
	*/

	
	//Step 0	
	Node rootElement = heapArray[0];
	currentSize--;//size was 5 but now it is 4
	int lastIdx = currentSize; //last index will be 4
	heapArray[0]= heapArray[lastIdx];
	
	
	//step 1 to 6
	heapifyDown();

	return rootElement;
	
}


public void heapifyDownPractice() {
	
	
	
}

public void heapifyDown() {
	
	int rootElmtIdx= 0;
	int largerChildIdx = 0;
	Node rootElement = heapArray[0];
	int lastIndex = currentSize;
	
	
	
	while (rootElmtIdx<currentSize/2)  {//it will run only till last second level of the tree. 
		//If the rootElmtIdx does not have any child, no need to proceed
	
		//Step 1. figure out left and right child
		int leftChildIdx=2*rootElmtIdx + 1;
	    int rightChildIdx = leftChildIdx+1;
	    
	    
	   
	    //Step 2:: Check which child is larger. We dont compare last index (maxSize) element because 
	    //that is the one we put on top and trickling it down. Always compare right first child has high probability of reaching last Index
	    //if right child == lastIndex, we declare left has larger child without comparing 
	    if(rightChildIdx  < lastIndex 
	    		&& heapArray[leftChildIdx].data  <  heapArray[rightChildIdx].data) {
	    largerChildIdx = rightChildIdx;
	    }else {
	    	largerChildIdx = leftChildIdx;
	    }
	    
	    if(heapArray[rootElmtIdx].data >= heapArray[largerChildIdx].data ) {	    		
	      	break;
	    }
	    
	    //Step 3:; Swapping elements
	    heapArray[rootElmtIdx] = heapArray[largerChildIdx];
	   
	    
	    //Step 4
	    rootElmtIdx = largerChildIdx;
	
    
	} 
	
	heapArray[rootElmtIdx]= rootElement;
		
}



public void  add(int key) {
	
	if(currentSize == maxSize) {
		System.out.println("Heap is full!!");
	}else {
		
		Node newNode = new Node(key);
		//add new element to available index
		heapArray[currentSize] = newNode;		
		
		heapifyUp(currentSize);
		
	
		//since element is added, increase the currentSize
		currentSize++;
		
	}
	
	
}

public void heapifyUp(int Idx) {
	
	int parentIdx = (Idx-1)/2;
	Node nodeToInsert = heapArray[Idx];
	
	while(Idx  >  0 &&  nodeToInsert.data  >  heapArray[parentIdx].data) {		
			heapArray[Idx]= heapArray[parentIdx];//move parent down
			Idx = parentIdx;
			parentIdx = (Idx-1)/2;
		}
				
	heapArray[Idx]=nodeToInsert;
	
	
	
}










}














