//class evaluating the postfix to infix and evaluating the expression
class Arithmetic {
	private String expression;
	private char post_expression[ ] = new char[50];  //Array containing the postfix expression
	private double value = 0;                        //Variable containing the results
	
	/*
	 * Constructor
	 */
	public Arithmetic(String s) {
		expression = s;
	}

	//Method converting the infix expression to post fix expression
	public void post_fix_Expression() {
		int flag = -1;   //counter for pushing the elements in stack
		Stack<Character> operators = new Stack<Character>();  //stack containing the operators
		char  element;  //variable containing the elements of the string
	
		for (int i = 0; i < expression.length(); i++) {
			element = expression.charAt(i);
			
			//Check if the string contains numerical values and add it to the postfix expression array
			
			if (element >= '0' && element <= '9') {
				post_expression[++flag] = expression.charAt(i);
			}
			
			//check if the expression string contains the operators
			else if (element == '+' || element == '-' || element == '?' || element == '/' || element == ':'|| element== '^') {
				//push the elements if the operator stack is empty
				if (operators.empty()) {
					operators.push(element);
				}
				
				//Comparing the pushed operators with the elements of the operators
				else {
					if(element > operators.peek()) {
						operators.push(element);
					}
				
					else {
						if(element < operators.peek()) {
							while(!operators.empty()) {
								char out = operators.pop();
								post_expression[++flag]= out;
						}
					}
					operators.push(element);
				}					
			}
		}
	}
		
	if (!operators.empty()) {
		post_expression[++flag] = operators.pop();
	}
	post_expression[++flag] = '\0';
}

	
	//Print the postfix expression
	String get_Postfix() {
		return new String (post_expression);
	}
	
	
	//Evaluate the expression

	public void evaluate_exp() {
		Stack<Integer>operand = new Stack<Integer>();   //Stack containing the operands
		char ch;                                      //elements of the expression
		int number;                                  //numeric value of the characters
			
		//Check if the numbers contain any numerical values
		for (int i = 0; i < post_expression.length; i++) {
			ch = (post_expression[i]);
			if (ch >= '0' && ch <= '9') {
				number = Character.getNumericValue(ch);  //Converts into numerical value
				//Print the numbers
				System.out.println(number);
				//push the number in the operand stack
				operand.push(number);
			}
			//Check if there are operators and evaluate the expression using switch- case
			if (ch == '+' || ch == '-' || ch == '?' || ch == '/' || ch == ':' || ch== '^') {
				
				//pop the operands from the stack
				int t1 = operand.pop();
				int t2 = operand.pop();
				switch (ch) {
					case '+':
						value = t2 + t1;
						System.out.println("Addition" + value);
						break;
		
					case '-':
						value = t2 - t1;
						System.out.println("Subtraction" + value);
						break;
		
					case '?':
						value = t2 * t1;
						System.out.println("Multiplication" + value);
						break;
		
					case ':':
						value = t2 % t1;
						System.out.println("Modulus" + value);
						break;
		
					case '/':
						value = t2 / t1;
						System.out.println("Division" + value);
						break;
		
					case'^':
						value=Math.pow(t2,t1);
						System.out.println("Exponential" + value);
						break;
				}
				//push the value(result) into the operand stack
				operand.push((int) value);				
			}	
		}
		value = operand.pop();
	}

    //Print the result
		
	public double get_Result() {
		return value;
	}
}
