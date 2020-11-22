package bitManipulation;

public class BitManipulation {

	
	
	public static void main(String[] args) {
	
		
	/*
	 * Binary representation of negative numbers. 
	 * Negative number always starts with 1 and positive numbers starts with 0
	 */
	
	int an = -5;// 11111111111111111111111111111011
	int bn = -7;// 11111111111111111111111111111001
	
	System.out.println("-a in binary format: "+ Integer.toBinaryString(an));
	System.out.println("-b in binary format: "+ Integer.toBinaryString(bn));
		
	/*
	 * Binary representation of positive numbers. 
	 * Negative number always starts with 1 and positive numbers starts with 0
	 */	
	int a = 5;// 101 
	int b = 7;// 111
	
	System.out.println("a in binary format: "+ Integer.toBinaryString(a));
	System.out.println("b in binary format: "+ Integer.toBinaryString(b));
	
	/*
	 * Addition of bits
	 * In Binary:
	 * 
	 * 0 + 0 = 0
       0 + 1 = 1
       1 + 0 = 1
       1 + 1 = 10 (1 will be carry over
       10101 +  11011 = 1 1 0 0 0 0
       
       Subtraction of bits
       0 - 0 = 0
       1 - 0 = 1
       1 - 1 = 0
       0 - 1 = 1 with a borrow of 1
     
       1000 - 111 -  = 
       
       1 0 0 0 
       - 1 1 1
      =      
	 */
	
	
	String bBinary = Integer.toBinaryString(b);
	
	/*
	 * Get negative Bit, complement (~) of input and then add by 1
	 *  7 = 0111
	 * -7 = 1001
	 */
	String aBinary = Integer.toBinaryString(a);
	
	/*
	 * Subtraction of Bits
	 */
	
	/*
	 * Multiplication of bits
	 */
	
	
	
	/*
	 * Binary Operators
	 */
	//if one is 1 --> 1 else 0
	System.out.println("--OR--> "+ (a | b) + " "+Integer.toBinaryString((a | b)) ); // 7  111
	//Both must be 1 to be one else 0
	System.out.println("--AND--> "+(a & b) + " "+Integer.toBinaryString((a & b)) ); // 5  101
	//If bits are diff then only 1 else 0
	System.out.println("--XOR--> "+(a ^ b) + " "+Integer.toBinaryString((a ^ b)) ); // 2  010
	//just reverse the bits
	System.out.println("--complement ~ --> "+ ~a + " "+Integer.toBinaryString(~a) ); // -6  -110
	System.out.println(Integer.toString(-6, 2));
	
	/*
	 * Signed Left Shift operator (<<) -- multiply by 2 to the power of n (here n = 3, x = 5)
	   Shift bits to left by n places
	   SIgn is preserved
	*/
	
	System.out.println("Signed LEFT Shift Operator (<<)---->");
	System.out.println(5 << 3);//40
	System.out.println(-5 << 3);// -40
	
	
	/*
	 * Signed RIGHT Shift Operator (>>) -- divide by 2 to the power of n (here n = 3, x = 12)
	It Preserves the sign
	Shift bits to right by n places
	SInce it is division -- if not fully divided, gives %n. 12 >> 3 = 12 % 8 = 1.
	If n > x then x >> n = 0 means 12 >> 4 = 0
	*/
	
	System.out.println("Signed RIGHT Shift Operator (>>)---->");
	System.out.println(12 >> 2);//3
	System.out.println(12 >> 3);//1
	System.out.println(12 >> 4);//0
	System.out.println(-12 >> 2);//-3 sign is preserved
	
	/*
	 * Unsigned Right Shift [>>>]
	 * Unsigned Right Shift [>>>] and Signed RIGHT Shift Operator (>>) have same results for positive numbers. 
	 * Result of negative numbers is always positive.
	 */
	System.out.println("Unsigned RIGHT Shift Operator (>>>)  Positive Numbers---->");
	//Positive numbers -- same result as >>
	System.out.println( 12 >>> 2); //3 -- result is same as >>
	System.out.println( 12 >>> 3); //1 -- result is same as >>
	System.out.println( 12 >>> 4); //0 -- result is same as >>
	
	System.out.println("Unsigned RIGHT Shift Operator (>>>)  Negative Numbers---->");
	//Negative numbers -- result is always positive
	System.out.println( -12 >>> 2); 
	System.out.println( -12 >>> 3); 
	System.out.println( -12 >>> 4); 
	
	
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
