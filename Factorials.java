import java.util.*;

public class Factorials {

	public static void main(String[] args){

		//System.out.println(factorial(4));
		//System.out.println(factorialR(4));
		System.out.println(factorialS(4));
	}

	public static int factorial(int number){
		int output = 1;
		for (int i=1; i<= number; i++){
			output *= i;
		}
		return output;
	}
	public static int factorialR(int number){
		if (number == 1) {
			return 1;
		}
		return number * factorialR(number-1);
	}
	public static int factorialS(int number){
		int[] stack = new int[20];
		stack[0]=0;
		int depth = number;
		while (depth >1) {
			push(depth,stack);
			depth--;
			//System.out.println(stack[0]);
		}
		int out = 1;
		while (stack[0]>0) {
			out = out *pop(stack);
			//System.out.println(stack[0]);
		}
		return out;
	}	
	public static void push(int data, int[] stack){
		stack[stack[0]+1]=data;
		stack[0]++;
	}
	public static int pop(int[] stack){
		int data = stack[stack[0]];
		stack[0]--;
		return data;
	}
}

