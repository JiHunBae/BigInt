package View;
import java.util.Scanner;

public class Input {
	Scanner input_sc = new Scanner(System.in);

	public String get_Multiply_Multiplicand() {
		// 피승수를 입력받아 문자열로 반환하는 메소드
		// TODO Auto-generated method stub
		String multiplicand_Of_Multiply = new String(); // 피승수(multiplicand)
		System.out.println("> 첫 번째 수(피승수)를 입력하세요");
		multiplicand_Of_Multiply = input_sc.next();
		input_sc.nextLine(); // buffer비우기

		return multiplicand_Of_Multiply; // multiplicand
	}

	public String get_Multiply_Multiplier() {
		// 승수를 입력받아 문자열로 반환하는 메소드
		String multiplier_Of_Multiply = new String(); // 승수(multiplier)
		System.out.println("> 두 번째 수(승수)를 입력하세요");
		multiplier_Of_Multiply = input_sc.next();
		input_sc.nextLine(); // buffer 비우기

		return multiplier_Of_Multiply; // multiplier
	}

}
