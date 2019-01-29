package App;

import java.util.Scanner;

import Model.BigInt;
import Model.Operation;
import View.Input;
import View.Output;

public class Controller {
	Scanner sc = new Scanner(System.in);
	Operation operation = new Operation();
	private static Controller controller = null;

	private Controller() {
	}

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	public void execute() {
		String cmd = new String(); // Command�� �Է¹��� ����
		String variable_1 = new String(); // Multiply and Division��
		String variable_2 = new String();
		Input input_Variables = new Input();
		Output output_Result = new Output();
		
		System.out.println("===== BIGINT ���⸦ �����մϴ�. =====");
		
		while (true) {
			
			System.out.println("> ������ ������ �����ϼ��� : [1] : ���� , [2] : ������  , [-1] : ����");
			cmd = sc.next();
			sc.nextLine();
			switch (cmd) {
			case "1" :
				String recieve_Input_Multiplicand = input_Variables.get_Multiply_Multiplicand();
				String recieve_Input_Multiplier = input_Variables.get_Multiply_Multiplier();
				String result_Of_multiply_One = operation.multiply(recieve_Input_Multiplicand, recieve_Input_Multiplier);

				if (result_Of_multiply_One == null) {
					System.out.println("[Error] ���� �߻����� ���Ͽ� ���α׷��� ����˴ϴ�.");
					break; // ����(����ó��)�� �ش� �������
				}

				output_Result.multiply_Result(result_Of_multiply_One); // ��� ����Լ�

				break;
			case "2" :
				break;
			case "-1" :
				System.out.println("===== BigInt ���⸦ �����մϴ�. =====");
				return ;
			default:
				System.out.println("[Error] �߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public void setup() {

	}
}
