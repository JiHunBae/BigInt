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
		String multiply_One_Result = new String(); // multiply_One ��ȯ ��
		Entry multiplicand_Entry = multiplicand.entry; // multiplicand�� Entry
		
		int multiplicand_One_Digit = 0; // multiplicand���� �� �ڸ��� �ش��ϴ� ��
		int multiplier_One_Digit = Integer.parseInt(multiplier_One_Digit_Value); // multiplier �� �ڸ��� �ش��ϴ� ��
		int multiply_One_Digit_Result = 0; // multiplicand_One_Digit * multiplier_One_Digit
		int multiply_One_Carry = 0; // multiply carry
		int multiply_One_Value = 0; // multiply_One_Digit_Result - carry
		
		while(multiplicand_Entry != null) {
			multiplicand_One_Digit = Integer.parseInt(multiplicand_Entry.getNumber()); // �� �ڸ� ����
			multiplicand_Entry = multiplicand_Entry.getNext(); // multiplicand_Entry �� ĭ ����
			multiply_One_Digit_Result = multiplicand_One_Digit * multiplier_One_Digit; // �� ���� ��
			multiply_One_Value = multiply_One_Carry; // ���� carry�� value�� �ű�
			multiply_One_Value += multiply_One_Digit_Result % 10; // ������ ��������� 1�� �ڸ����� ������
			multiply_One_Carry = multiply_One_Digit_Result / 10 + (multiply_One_Value / 10);
			// value�� carry���� ������ ���� 10�� �Ѿ ��츦 ����Ͽ� �� ���� ������ 10�� ���� ���� value�� 10���� ���� ���� ������
			multiply_One_Value %= 10; // value�� 10�� �Ѿ ��� 1���ڸ��� ���� ����
			
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
		int multiply_One_Carry = 0; // ������ carry���� ��Ÿ��
		int multiply_One_Value = 0; // ������ 1���ڸ� ���� ��Ÿ��
		Entry multiply_One_Temp = multiply_One_Return;
		while (multiplicand_Entry != null && multiplicand_Entry.getNumber() != null) {
			int multiplicand_One_Digit_Integer = Integer.parseInt(multiplicand_Entry.getNumber()); // �ǽ¼� �� �ڸ� ����
			multiplicand_Entry = multiplicand_Entry.getNext(); // �ǽ¼� ���Ḯ��Ʈ �� ĭ ����
			int result_Of_Multiply_One_Digit = multiplicand_One_Digit_Integer * multiplier_One_Digit_Integer;
			// �ǽ¼�, �¼� �� �� �ڸ��� ���� ����
			multiply_One_Value = multiply_One_Carry; // ���� ĳ���� �޾ƿ���
			multiply_One_Carry = result_Of_Multiply_One_Digit / 10; // �� �ڸ��� ���� ��������� ���� carry�� ����
			multiply_One_Value += result_Of_Multiply_One_Digit % 10; // �� �ڸ��� ���� ��������� ���� value�� ����(1�� �ڸ���)
			
			if (multiply_One_Value > 9) { 
				// ���� ĳ������ �̹� ���� ����� 1���ڸ� ���� ���� ���� 10�� �Ѿ�� ��� carry���� value�� ������
				multiply_One_Carry += multiply_One_Value / 10;
				multiply_One_Value %= 10;
			}
			
			
		//	for(;multiply_One_Temp.getNext() != null; multiply_One_Temp = multiply_One_Temp.getNext());
			
			multiply_One_Temp.setNumber(Integer.toString(multiply_One_Value)); // 1�� �ڸ����� ����
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
