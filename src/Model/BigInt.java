package Model;

import java.util.Stack;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public class BigInt {
	protected Entry entry = new Entry();
	private static boolean check_Init = false; 
	// BigInt(String string)시 string문자열이 상수의 조합으로만 이루어진 경우 true로 변환, 그렇지않으면 false유지

	protected BigInt() {
	}

/*	protected BigInt(String string_Number) {
		String[] line_Split = string_Number.split(""); // Parameter string_Number를 split을 이용해 배열로 나눔
		int length_Of_String = line_Split.length; // line_Split 배열의 길이 == string_Number 문자열의 길이
		Stack<String> stack = new Stack(); // String객체를 담을 Stack

		try {
			// stack에 String객체 push
			for (int index = 0; index < length_Of_String; ++index) {
				stack.push(line_Split[index]);
				int check_Integer = Integer.parseInt(line_Split[index]);
				// string이 정수인지 아닌지 체크하기 위한 변환 과정, 정수가 아닐시 오류
			}
			this.entry.setNumber(stack.pop());

			while (!stack.isEmpty()) {
				Entry number_Input_Temp = this.entry; // String Input을 위한 temp 변수

				for (; number_Input_Temp.getNext() != null; number_Input_Temp = number_Input_Temp.getNext());
				
				number_Input_Temp.setNext(new Entry());
				number_Input_Temp.getNext().setNumber(stack.pop());
			}
			
			check_Init = true;
			
		} catch (IllegalArgumentException e) {
			// 숫자가 아닌 값이 문자열에 입력된 경우 형변환에서 Error가 발생하는데 이러한 경우 예외처리 및 출력문
			System.out.println("[Error] 예외처리 발생 - 입력된 수가 정수가 아닌 문자가 존재합니다.");
		}
	}
*/
	protected BigInt(String string_Number) {
		String[] line_Split = string_Number.split(""); // Parameter string_Number를 split을 이용해 배열로 나눔
		int length_Of_String = line_Split.length; // line_Split 배열의 길이 == string_Number 문자열의 길이
		//Stack<String> stack = new Stack(); // String객체를 담을 Stack
		Entry init_Temp = this.entry;
		try {
			for(int index = length_Of_String - 1; 0 <= index ; --index) {
				int check_Integer = Integer.parseInt(line_Split[index]); // 입력된 문자열 중 정수가 아닌 문자가 있는지 오류 검출을 위한 형변환
				
				// 문자(상수) 하나를 연결리스트에 저장 후, 입력 연결리스트 전진
				init_Temp.setNumber(line_Split[index]);
				init_Temp.setNext(new Entry());
				init_Temp = init_Temp.getNext();
			}			
			check_Init = true;
		}
		catch (IllegalArgumentException e) {
			// 숫자가 아닌 값이 문자열에 입력된 경우 형변환에서 Error가 발생하는데 이러한 경우 예외처리 및 출력문
			System.out.println("[Error] 예외처리 발생 - 입력된 수가 정수가 아닌 문자가 존재합니다.");
		}
	}
	
	public static boolean isCheck_Init() {
		return check_Init;
	}
	
	public static void setCheck_Init(boolean check_Init) {
		BigInt.check_Init = check_Init;
	}

	protected class Entry {
		private String number;
		private Entry next = null;
		private Entry prev = null;

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}

		public Entry getPrev() {
			return prev;
		}

		public void setPrev(Entry prev) {
			this.prev = prev;
		}
	}
}
