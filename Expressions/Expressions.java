/**
 * The program takes the expression in the form of and solves it
 * @author Shreeya Gangwal and Sameera Desai
 *
 */
import java.util.*;


/*This program evaluates a hard coded expression.
 * Two stacks operators and operands have been used to store the operands and operators 
 * and popped out.
 * The concept of infix to postfix conversion has been used to push and pop the elements 
 * from and in the stack
 * The symbol '?' denotes multiplication
 * The symbol ':' denotes modulus
 * 
 * 
 * @Shreeya Gangwal
 * 
 * @Sameera Desai
 * 
 * 
 */
//main program
public class Expressions {
	public static void main(String args[]) {
		String s[] = {"3 + 4 ? 2 - 5"}; //Hard code string
		
		//Print the expression
		
		for(int i = 0; i < s.length; i++) {
			System.out.print("The original expression is:\n" + s[i]);
		}
		
		//Print the post fixed expression
		
		System.out.print("The post fixed expression is:\n");
		for(int i = 0; i < s.length; i++) {	
			Arithmetic a = new Arithmetic(s[i]);	
			a.post_fix_Expression();
			System.out.println(a.get_Postfix());
			
			//Evaluate the expression
			a.evaluate_exp();			
			System.out.println("The Result is:" + a.get_Result());
		}
	}
}
