package sorting;

public class Recursion {
	
	
	
	
	
	    static int factorial(int n){      
	          if (n == 1)      
	            return 1;      
	          else      
	            return(n * factorial(n-1)); 
	          
	          //2! = 2 * 1!
	          //3! = 3 * 2!
	          //4! = 4 * 3!
	    }      
	  
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Factorial of 5 is: "+factorial(5));  
		
		

	}

}
