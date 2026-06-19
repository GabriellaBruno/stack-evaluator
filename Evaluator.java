/* 
 * Gabriella Bruno
 * Lab 7
 * Title: Evaluator.java
 * Description:checks for balanced parentheses, brackets, and curly braces
 * Date: 11/12/25
 */
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class Evaluator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter an expression:");
				
		Scanner keyboard = new Scanner(System.in);
		String expression = keyboard.nextLine();
				
		if (balance(expression) == true) {		
			System.out.println("Result: no error has been found");
		} else {
			System.out.println("Result: an error has been found");

		}
		
	}//end main
	
	public static boolean balance(String e) {
		StringBuilder input = new StringBuilder(e);
		Stack<Character> stack= new Stack<Character>();

		boolean check = false;
		
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) == '(') {
				stack.push(input.charAt(i));
			} else if (input.charAt(i) == ')') {
				if (stack.isEmpty()) {
					check = false;
				} else if (stack.peek().equals('(')){
					stack.pop();
					check = true;
				}
				
			} else if (input.charAt(i) == '[') {
				stack.push(input.charAt(i));
			} else if (input.charAt(i) == ']') {
				if (stack.isEmpty()) {
					check = false;
				} else if (stack.peek().equals('[')) {
					stack.pop();
					check = true;
				}
				
			} else if (input.charAt(i) == '{') {
				stack.push(input.charAt(i));
			} else if (input.charAt(i) == '}') {
				if (stack.isEmpty()) {
					check = false;
				} else if (stack.peek().equals('{')){
					stack.pop();
					check = true;
				}
			}
		}//end for loop
		
		if(!stack.isEmpty()) {
			check = false;
		}
		
		if(check == false) {
			return false;
		} else {
			return true;
		}
	}//end method

}//end class

/*
 * console output:
 * 
Enter an expression:
(3+5)(6/4)
Result: no error has been found
 * 
Enter an expression:
{(1+2)*-8/3}
Result: no error has been found
 * 
Enter an expression:
[{9}{0+1]}
Result: an error has been found
 * 
Enter an expression:
{3*4})^[3^4)
Result: an error has been found
 * 
 */