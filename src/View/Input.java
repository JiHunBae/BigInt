package View;
import java.util.Scanner;

public class Input {	
	Scanner input_sc = new Scanner(System.in);

	public String get_Multiply_Multiplicand() {
		// �ǽ¼��� �Է¹޾� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		// TODO Auto-generated method stub
		String multiplicand_Of_Multiply = new String(); // �ǽ¼�(multiplicand)
		System.out.println("> ù ��° ��(�ǽ¼�)�� �Է��ϼ���");
		multiplicand_Of_Multiply = input_sc.next();
		input_sc.nextLine(); // buffer����
		
		return multiplicand_Of_Multiply; // multiplicand
	}
	
	public String get_Multiply_Multiplier() {
		// �¼��� �Է¹޾� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		String multiplier_Of_Multiply = new String(); // �¼�(multiplier)
		System.out.println("> �� ��° ��(�¼�)�� �Է��ϼ���");
		multiplier_Of_Multiply = input_sc.next();
		input_sc.nextLine(); // buffer ����
		
		return multiplier_Of_Multiply; // multiplier
	}

}
