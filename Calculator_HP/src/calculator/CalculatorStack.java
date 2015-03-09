package calculator;

public class CalculatorStack {
	private int arr[];
	
	/* public static void main(String[] args) {
		CalculatorStack cs = new CalculatorStack(4);
		
		cs.push(23);
		cs.push(45);
		cs.push(224);
		cs.push(312);
		cs.push(53);
		System.out.println(cs.toString());
		
		System.out.println("pop: " + cs.pop());
		System.out.println("pop: " + cs.pop());
		
		System.out.println(cs.toString());
	} */
	
	public CalculatorStack(int size) {
		arr = new int[size];
	}
	
	public int[] getStack() {
		return arr;
	}
	
	public void modifyTop(int addition) {
		arr[0] = addition;
	}

	/**
	 * We can push an unlimited number of elements, the tail will simply fall off the stack.
	 * @param num is the element being placed on the top of the stack pushing the tail off.
	 */
	public int push(int num) {
		int temp1 = arr[1];
		int temp2 = arr[2];
		
		arr[1] = arr[0];
		arr[0] = num;
		arr[2] = temp1;
		arr[3] = temp2;
		
		return num;
	}
	
	/**
	 * We pop the top element out of the stack and push the others towards the top while duplicating the bottom element.
	 * @return top element
	 */
	public int pop() {
		int temp0 = arr[0];
		
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		
		return temp0;
	}
	
	/**
	 * We peek the top element.
	 * @return top element.
	 */
	public int peek() {
		return arr[0];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int n : arr)
			sb.append(n + " ");
		
		return sb.toString();
	}
}
