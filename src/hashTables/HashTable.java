package hashTables;

public class HashTable {
	
	LinkedHashNode[] hashArray;//this is the bucket
	int curSize = 0;
	int maxSize;



public HashTable(int size) {
	
	if(HashTableSimple.isPrime(size)) {
		 maxSize =size;
		 hashArray = new LinkedHashNode[maxSize];
	}else {
		int nextSize = HashTableSimple.findNextPrime(size);
		maxSize =nextSize;
		hashArray = new LinkedHashNode[maxSize];
	}
	//Set all slots of hashTable to null??? but why
	for (int i = 0; i < maxSize; i++)
		hashArray[i] = null;
	
}

public void makeEmpty(){
	for (int i = 0; i < maxSize; i++)
		hashArray[i] = null;
	
	
}

public int getHashedKey(String key) {//get the index of key where the value should be put
	
	int keyIndex = key.hashCode();
	keyIndex = keyIndex % maxSize; 
	if(keyIndex < 0) {
		keyIndex = keyIndex + maxSize; 
	}
	return keyIndex;
}

/* Function to get value of a key */
public int get(String key) {
	int index = getHashedKey(key);
	
	if(hashArray[index] == null) 
		return -1; //key not found in HashTable
	
	//Key found in hashTable
	LinkedHashNode head = hashArray[index]; 
	
	while(head != null) {
		if(head.key.equals(key)) 
			return head.value;
		head = head.next;
	}
	
	return -1;

}

/* Function to insert a key value pair */
public void insert(String key, int value) {

	int index = getHashedKey(key);
	
	if(hashArray[index] == null) {//not occupied
		hashArray[index] = new LinkedHashNode(key, value);
		curSize++;
	}else {//index is already occupied, traverse through head
		
	
		LinkedHashNode head = hashArray[index];
		LinkedHashNode previous = null;
		
		while(head != null) {
			if(head.key.equals(key)) { //if same key already exists in that bucket, replace value with incoming value
				head.value = value;
				return;
			}
			previous = head;
			head = head.next;
		}
		
		previous.next = new LinkedHashNode(key, value);
		curSize++;
				
	}
		
	
}


public void remove(String key) {

int index = getHashedKey(key);
	
	if(hashArray[index] == null) {//key does not exist
		return;
		
		
	}else {
		LinkedHashNode head = hashArray[index];
		LinkedHashNode previous = null;
		
		
		while(head != null) {
			if(head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.next;
		}
		
		//head h2, h3, h4.
		
		
		if(head == null) {//no match found means element not found
			return;
		}
		
		if(previous !=null) {
			previous.next = head.next;
			
		}else {//if head's key is equal to key. previous will be null here
			head = head.next;//next element will be head now
		}
		
		curSize--;
	
   }
	
	
	
	
	


}




}
