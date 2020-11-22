package stack;

public class StackApp {

	public static void main(String[] args) {
		
		//add elements
		Stack varStack = new Stack(5);
		varStack.push('6');//
		varStack.push('4');
		varStack.push('5');
		varStack.push('1');
		varStack.push('0');//last in first out
		
		//System.out.println(varStack.peak());
		//print all
		while(!varStack.isEmpty()) {
			
			System.out.println(varStack.pop());
		}
		
		//System.out.println(reverseString("Deepti"));
		
		

	}
	
	
	//Define new Stack class that has underlying array of char type
	public static String reverseString(String input) {
		
		java.util.Stack<Character> strStack = new java.util.Stack<Character>();
		
		for(int i =0; i<input.length(); i++) {
			strStack.push(input.charAt(i));
			
		}
		
	
		String output = "";
		while(!strStack.isEmpty()) {
			output = output+strStack.pop();
			
		}
		return output;
		
		
		
	}
	
public static void reverseList(String input) {
		
	
		
	}


public static void isPlindrome(String input) {
	
	//get reversed String and compare with input
	//if same == it is palindrome
}

}
