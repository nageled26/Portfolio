
/**
 * @author Dillon Nagele
 */
import java.util.Stack;
import java.util.Scanner;

public class BalanceExpression {
	public static boolean isBalanced(String expression){
		//Characters for each type of grouping
		   final char LEFT_NORMAL = '(';
		   final char RIGHT_NORMAL = ')';
		   final char LEFT_CURLY = '{';
		   final char RIGHT_CURLY = '}';
		   final char LEFT_SQUARE = '[';
		   final char RIGHT_SQUARE = ']';
		  
		//stores every bracket found
		Stack<Character> store = new Stack<Character>();
		//goes through expression to see if balanced
		for (int i = 0; (i < expression.length()); i++){
			   switch (expression.charAt(i)){
			   //when left parenthesis, stores it in stack
				   case LEFT_NORMAL:
				   case LEFT_CURLY:
				   case LEFT_SQUARE:
					   store.push(expression.charAt(i));
					   break;
				//when right parenthesis, checks to see if there is corresponding left parenthesis most recently. If not, returns false
				   case  RIGHT_NORMAL:
					   if (store.isEmpty()||(store.pop() !=LEFT_NORMAL))
						   return false;
						break;
				   case  RIGHT_CURLY:
					   if (store.isEmpty()||(store.pop( ) != LEFT_CURLY))
						   return false;
						break;
				   case  RIGHT_SQUARE:
					   if (store.isEmpty()||(store.pop( ) != LEFT_SQUARE))
						   return false;
					   	break;
				//if not parenthesis, does nothing
			      default:
			    	  break;
			       }
			}
		//returns true or false depending on if there are any left over parenthesis
			return store.isEmpty();
			
	}
	public static void main(String[] args){
		//user input
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a mathmatical expression (no spaces between characters):");
		String expression=input.nextLine();
		//determines if input is balanced
		if(isBalanced(expression))
		{
			System.out.println("Expression is balanced");
		}
		else{
			System.out.println("Expression is not balanced");
		}
		input.close();
	}
}
