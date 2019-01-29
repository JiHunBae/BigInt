package Model;
import java.util.Scanner;
import java.util.Stack;

import View.Input;

public class Operation extends BigInt {
	Scanner sc = new Scanner(System.in);
	BigInt bigint_First; // Multiplicand
	BigInt bigint_Second; // Mutliplier
	Input input_parameter = new Input(); // Object for getting Parameter (Input)
	
	public Operation() {}
		
	/*public String multiply_One(BigInt bigint_multiplicand, String multiplier_One_Digit_Value) {
		BigInt multiplicand = bigint_multiplicand;	
		
		Stack<String> multiply_One_Stack = new Stack(); // Stack
		String multiply_One_Result = new String(); // multiply_One 반환 값
		Entry multiplicand_Entry = multiplicand.entry; // multiplicand의 Entry
		
		int multiplicand_One_Digit = 0; // multiplicand에서 한 자리에 해당하는 수
		int multiplier_One_Digit = Integer.parseInt(multiplier_One_Digit_Value); // multiplier 한 자리에 해당하는 수
		int multiply_One_Digit_Result = 0; // multiplicand_One_Digit * multiplier_One_Digit
		int multiply_One_Carry = 0; // multiply carry
		int multiply_One_Value = 0; // multiply_One_Digit_Result - carry
		
		while(multiplicand_Entry != null) {
			multiplicand_One_Digit = Integer.parseInt(multiplicand_Entry.getNumber()); // 한 자리 받음
			multiplicand_Entry = multiplicand_Entry.getNext(); // multiplicand_Entry 한 칸 전진
			multiply_One_Digit_Result = multiplicand_One_Digit * multiplier_One_Digit; // 두 수의 곱
			multiply_One_Value = multiply_One_Carry; // 이전 carry를 value로 옮김
			multiply_One_Value += multiply_One_Digit_Result % 10; // 곱셈의 결과값에서 1의 자리수를 더해줌
			multiply_One_Carry = multiply_One_Digit_Result / 10 + (multiply_One_Value / 10);
			// value가 carry와의 덧셈을 통해 10을 넘어간 경우를 고려하여 두 수의 곱에서 10을 나눈 값과 value를 10으로 나눈 값을 더해줌
			multiply_One_Value %= 10; // value가 10을 넘어간 경우 1의자리만 남게 해줌
			
			multiply_One_Stack.push(Integer.toString(multiply_One_Value));
		}
		
		if(multiply_One_Carry != 0) multiply_One_Stack.push(Integer.toString(multiply_One_Carry));
		
		while(!multiply_One_Stack.isEmpty()) {
			multiply_One_Result += multiply_One_Stack.pop();
		}
		return multiply_One_Result;
	}*/
	
	private Entry multiply_One(Entry multiplicand_Entry, String multiplier_One_Digit) {
		Entry multiply_One_Return = new Entry();
		
		int multiplier_One_Digit_Integer = Integer.parseInt(multiplier_One_Digit);
		int multiply_One_Carry = 0; // 곱셈시 carry값을 나타냄
		int multiply_One_Value = 0; // 곱셈시 1의자리 값을 나타냄
		Entry multiply_One_Temp = multiply_One_Return;
		while (multiplicand_Entry != null && multiplicand_Entry.getNumber() != null) {
			int multiplicand_One_Digit_Integer = Integer.parseInt(multiplicand_Entry.getNumber()); // 피승수 한 자리 받음
			multiplicand_Entry = multiplicand_Entry.getNext(); // 피승수 연결리스트 한 칸 전진
			int result_Of_Multiply_One_Digit = multiplicand_One_Digit_Integer * multiplier_One_Digit_Integer;
			// 피승수, 승수 각 한 자리에 대한 곱셈
			multiply_One_Value = multiply_One_Carry; // 이전 캐리값 받아오기
			multiply_One_Carry = result_Of_Multiply_One_Digit / 10; // 한 자리에 대한 곱셈결과에 대해 carry값 저장
			multiply_One_Value += result_Of_Multiply_One_Digit % 10; // 한 자리에 대한 곱셈결과에 대해 value값 저장(1의 자리수)
			
			if (multiply_One_Value > 9) { 
				// 이전 캐리값과 이번 곱셈 결과의 1의자리 값을 더한 값이 10을 넘어가는 경우 carry값과 value값 재조정
				multiply_One_Carry += multiply_One_Value / 10;
				multiply_One_Value %= 10;
			}
			
			
		//	for(;multiply_One_Temp.getNext() != null; multiply_One_Temp = multiply_One_Temp.getNext());
			
			multiply_One_Temp.setNumber(Integer.toString(multiply_One_Value)); // 1의 자리값을 저장
			multiply_One_Temp.setNext(new Entry());
			multiply_One_Temp = multiply_One_Temp.getNext();
		}
		
		if(multiply_One_Carry != 0)
			multiply_One_Temp.setNumber(Integer.toString(multiply_One_Carry));
		
		return multiply_One_Return;
	}
	
	public String multiply(String multiplicand, String multiplier) {
		BigInt bigint_Multiplicand = new BigInt(multiplicand);
		if(!bigint_Multiplicand.isCheck_Init()) return null;
		BigInt bigint_Multiplier = new BigInt(multiplier);
		if(!bigint_Multiplier.isCheck_Init()) return null;
		Entry multiply_One_Result = new Entry();
		String string_For_Return = new String();
		//while (bigint_Multiplier.entry != null) {
			multiply_One_Result = multiply_One(bigint_Multiplicand.entry, bigint_Multiplier.entry.getNumber());
	//	}
		while(multiply_One_Result != null && multiply_One_Result.getNumber() != null) {
			String temp_multiply_One_Result = multiply_One_Result.getNumber();
			multiply_One_Result = multiply_One_Result.getNext();
			string_For_Return = temp_multiply_One_Result + string_For_Return;
		}
		
		return string_For_Return;
	}
}
