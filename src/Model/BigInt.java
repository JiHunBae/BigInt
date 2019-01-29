package Model;

import java.util.Stack;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public class BigInt {
	protected Entry entry = new Entry();
	private static boolean check_Init = false; 
	// BigInt(String string)�� string���ڿ��� ����� �������θ� �̷���� ��� true�� ��ȯ, �׷��������� false����

	protected BigInt() {
	}

/*	protected BigInt(String string_Number) {
		String[] line_Split = string_Number.split(""); // Parameter string_Number�� split�� �̿��� �迭�� ����
		int length_Of_String = line_Split.length; // line_Split �迭�� ���� == string_Number ���ڿ��� ����
		Stack<String> stack = new Stack(); // String��ü�� ���� Stack

		try {
			// stack�� String��ü push
			for (int index = 0; index < length_Of_String; ++index) {
				stack.push(line_Split[index]);
				int check_Integer = Integer.parseInt(line_Split[index]);
				// string�� �������� �ƴ��� üũ�ϱ� ���� ��ȯ ����, ������ �ƴҽ� ����
			}
			this.entry.setNumber(stack.pop());

			while (!stack.isEmpty()) {
				Entry number_Input_Temp = this.entry; // String Input�� ���� temp ����

				for (; number_Input_Temp.getNext() != null; number_Input_Temp = number_Input_Temp.getNext());
				
				number_Input_Temp.setNext(new Entry());
				number_Input_Temp.getNext().setNumber(stack.pop());
			}
			
			check_Init = true;
			
		} catch (IllegalArgumentException e) {
			// ���ڰ� �ƴ� ���� ���ڿ��� �Էµ� ��� ����ȯ���� Error�� �߻��ϴµ� �̷��� ��� ����ó�� �� ��¹�
			System.out.println("[Error] ����ó�� �߻� - �Էµ� ���� ������ �ƴ� ���ڰ� �����մϴ�.");
		}
	}
*/
	protected BigInt(String string_Number) {
		String[] line_Split = string_Number.split(""); // Parameter string_Number�� split�� �̿��� �迭�� ����
		int length_Of_String = line_Split.length; // line_Split �迭�� ���� == string_Number ���ڿ��� ����
		//Stack<String> stack = new Stack(); // String��ü�� ���� Stack
		Entry init_Temp = this.entry;
		try {
			for(int index = length_Of_String - 1; 0 <= index ; --index) {
				int check_Integer = Integer.parseInt(line_Split[index]); // �Էµ� ���ڿ� �� ������ �ƴ� ���ڰ� �ִ��� ���� ������ ���� ����ȯ
				
				// ����(���) �ϳ��� ���Ḯ��Ʈ�� ���� ��, �Է� ���Ḯ��Ʈ ����
				init_Temp.setNumber(line_Split[index]);
				init_Temp.setNext(new Entry());
				init_Temp = init_Temp.getNext();
			}			
			check_Init = true;
		}
		catch (IllegalArgumentException e) {
			// ���ڰ� �ƴ� ���� ���ڿ��� �Էµ� ��� ����ȯ���� Error�� �߻��ϴµ� �̷��� ��� ����ó�� �� ��¹�
			System.out.println("[Error] ����ó�� �߻� - �Էµ� ���� ������ �ƴ� ���ڰ� �����մϴ�.");
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
