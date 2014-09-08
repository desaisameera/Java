/*
 *
 Quad.java
 * 
 */

import java.util.Scanner;
/*
 * This program prints out the Power set for n number of elements
 * 
 * @author Sameera S. Desai
 */


public class Quad {
	
	public static void main(String args[]) {
		//main program
		int number;                  //Number of Actors
		int i;     
		int j;
		int n;                      //length of the Binary numbers
		double number_actors;       //Total number of elements in power set
		
		Scanner in = new Scanner(System.in);
		
		//Ask the user to input the number of Actors
		System.out.println("Enter the number of actors");
		number = in.nextInt();
		
		//Prints out the number of actors
		System.out.println("The number of actors are:"+number);
		
		int actors[] = new int[100];   //Array containing the name of actors 
		
		//Takes the actors from the user and stores in the array
		for(i = 0; i < number; i++) {
			System.out.println("Enter Actor");
			actors[i] = in.nextInt();
		}
		
		//Print the actors
		System.out.println("The actors are:");
		
		for(i = 0; i < number; i++) {
			
			System.out.print(actors[i]+"\t");
		}
		
		//Calculate the number of possible combinations in the power set
		number_actors = Math.pow(2, number);
		
		//Print the possible number of combinations
		System.out.println("\n The number of possible combinations are:"+number_actors);
		
		String binary_num;        //String containing the binary form of the number
		
		
		//Convert the decimal numbers from 0 to n into binary numbers
		
		for(i = 0; i < number_actors; i++) {
			binary_num = Integer.toBinaryString(i);
			n = binary_num.length();
			
			
			//Append zeros to make the binary strings of length equal to n
			
			for(int k = n; k < number; k++) {
				binary_num = new String("0"+ binary_num);
			}
			
			//Print the opening braces for the subsets
			
			System.out.print("{");
			
			//Print only those numbers that correspond to one in the binary string
			
			for(j = 0; j < number; j++) {
				
				if(binary_num.charAt(j) == '1') {
					System.out.print(actors[j]);
				}				
			}
			
			//Print the closing braces for the subsets
			System.out.print("}");
		}
	}
}

