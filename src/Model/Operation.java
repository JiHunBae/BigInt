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
		Entry multiply_One_Result = new Entry(); // 출력때 사용할 Entry
		Entry store_Temp = multiply_One_Result; // multiply_One을 한 칸씩 이동하면서 저장하기 위한 Entry
		 // 이어서 숫자를 더해가기 위한 temp변수
		String string_For_Return = new String();

		while (bigint_Multiplier.entry != null && bigint_Multiplier.entry.getNumber() != null) {
			Entry temp_Multiply_First = store_Temp;
			Entry temp_Multiply_Second = multiply_One(bigint_Multiplicand.entry, bigint_Multiplier.entry.getNumber());
			Entry changer_Location = temp_Multiply_First;
			// multiply_One 결과를 받아온 temp변수
			String previous_Number = new String();

			int combination_Carry = 0; //
			int combination_Value = 0;
			int combination_Plus = 0;



			while(temp_Multiply_Second != null && temp_Multiply_Second.getNumber() != null) {
		/*		if(temp_Multiply_First != null && temp_Multiply_First.getNumber() != null)
					combination_Plus = Integer.parseInt(temp_Multiply_Second.getNumber()) + Integer.parseInt(temp_Multiply_First.getNumber());
				else
					*/
				int temp_Current_Number = 0;
				if(temp_Multiply_First != null && temp_Multiply_First.getNumber() != null)
					temp_Current_Number = Integer.parseInt(temp_Multiply_First.getNumber());
				/*if(changer_Location != null && changer_Location.getNumber() != null)
					temp_Current_Number = Integer.parseInt(changer_Location.getNumber());*/

				combination_Plus = Integer.parseInt(temp_Multiply_Second.getNumber()) + temp_Current_Number;
				combination_Value = combination_Carry; // 이전 carry값
				combination_Value += combination_Plus % 10; // 이번 덧셈 연산 값을 더함
				combination_Carry = combination_Plus / 10; // 덧셈에서 발생한 carry저장

				if(combination_Value > 9) { // value가 10이상인 경우 carry및 value값 재조정
					combination_Carry += combination_Value / 10;
					combination_Value %= 10;
				}
				// 값을 설정하고 다음칸으로 전진
				temp_Multiply_First.setNumber(Integer.toString(combination_Value));
				if(temp_Multiply_First.getNext() == null)
						temp_Multiply_First.setNext(new Entry());

				temp_Multiply_First = temp_Multiply_First.getNext();
				temp_Multiply_Second = temp_Multiply_Second.getNext();
			}

			if(combination_Carry != 0) // 캐리값 있는 경우 저장
				temp_Multiply_First.setNumber(Integer.toString(combination_Carry));

			// multiplier 다음 자리수로 이동
			store_Temp = store_Temp.getNext();
			bigint_Multiplier.entry = bigint_Multiplier.entry.getNext();
		}

		while(multiply_One_Result != null && multiply_One_Result.getNumber() != null) {
			String temp_multiply_One_Result = multiply_One_Result.getNumber();
			multiply_One_Result = multiply_One_Result.getNext();
			string_For_Return = temp_multiply_One_Result + string_For_Return;
		}

		return string_For_Return;
	}
}
