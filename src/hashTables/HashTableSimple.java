package hashTables;

public class HashTableSimple {
	String[] hashArray;
	int currentSize = 0;
	int maxSize;
	
	
	
	public HashTableSimple(int size) {
			
		if(isPrime(size)) {
			 maxSize =size;
			 hashArray = new String[maxSize];
		}else {
			int nextSize = findNextPrime(size);
			maxSize =nextSize;
			hashArray = new String[maxSize];
		}
		
	}
	
	public static boolean isPrime(int num) {
	
		for(int i = 2; i*i<=num; i++) {
			if(num % i == 0)return false;
					
		}		
		return true;
	}
	
	public static int findNextPrime(int num) {
		
		for(int i = num; true; i++) {
			if(isPrime(i)) return i;
					
		}		
		
	}
	
	public int hashFunc1(String value) {//get the index of key where the value should be put
		
		int keyIndex = value.hashCode();
		keyIndex = keyIndex % maxSize; //maxSize must be prime
		if(keyIndex < 0) {
			keyIndex = keyIndex + maxSize; 
		}
		return keyIndex;//This is ideal index where we want to put the value. 
		/*
		 * But what if this index is occupied??Two values can give same hashcode. In that case case go for Liner Probing/Open Addressing 
		 * to find next available empty slot by using function below.
		 * Alternate option is to go for chaining. Meaning, put the value in already occupied index in the form of linkedlist.. That way
		 * one key will have multiple values.
		 */
		
		
	}
	
	/*
	 * In case hashFunc1 gives index that is already occupied. Do liner probing/Open addressing to get next available index
	 */
	
    public int hashFunc2(String value) {//to calculate next available index/address
		
		int keyIndex = hashFunc1(value);
		int stepSize = 3 - keyIndex  % 3; //This number must be any prime number less than maxSize.If maxSize is 10, 
		//this number can be any prime number less than 10		
		return stepSize;
		
		
	}
    
    public void insert(String value) {
    	  
    	   int keyIndex = hashFunc1(value);
    	   int stepSize = hashFunc2(value);
    	   
    	   if (hashArray[keyIndex] != null) {
    		   keyIndex = keyIndex + stepSize;
    		   keyIndex = keyIndex % maxSize;  		   
    	   }
    	   
    	   hashArray[keyIndex] = value;
    	   currentSize++;
    	   
    }
    
    public String search(String value) {
  	  
 	   int keyIndex = hashFunc1(value);
 	   int stepSize = hashFunc2(value);
 	   
 	   if (hashArray[keyIndex] != null) {
 		   if(hashArray[keyIndex].equals(value)) {
 			  return hashArray[keyIndex];
 		   }
 		   keyIndex = keyIndex + stepSize;
 		   keyIndex = keyIndex % maxSize;  		   
 	   }
 	   
 	   return hashArray[keyIndex] ;
 	   
 	   
 }
	
	
	public void display() {
		for(int i =0; i< maxSize; i++) {
			
			if(hashArray[i] !=null) {
				System.out.println(hashArray[i]);
			}else {
				System.out.println("**");
				
			}
				
		}
	}
	
	
	
	
	
	
	public static void main (String[] args) {
		
		//System.out.println(isPrime(81));
		
		HashTableSimple hshTbl = new HashTableSimple(7);//good to initialize this atleast with double the number of elements
		hshTbl.insert("Hello");
		hshTbl.insert("monkey");
		hshTbl.insert("zebra");
		hshTbl.insert("berries");
		hshTbl.insert("grapes");
		hshTbl.insert("Hello");
		
		hshTbl.display();
	}
	

}
