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
		String cmd = new String(); // Command를 입력받을 변수
		String variable_1 = new String(); // Multiply and Division시
		String variable_2 = new String();
		Input input_Variables = new Input();
		Output output_Result = new Output();

		System.out.println("===== BIGINT 계산기를 실행합니다. =====");

		while (true) {

			System.out.println("> 실행할 연산을 선택하세요 : [1] : 곱셈 , [2] : 나눗셈  , [-1] : 종료");
			cmd = sc.next();
			sc.nextLine();
			switch (cmd) {
			case "1" :
				String recieve_Input_Multiplicand = input_Variables.get_Multiply_Multiplicand();
				String recieve_Input_Multiplier = input_Variables.get_Multiply_Multiplier();
				String result_Of_multiply_One = operation.multiply(recieve_Input_Multiplicand, recieve_Input_Multiplier);

				if (result_Of_multiply_One == null) {
					System.out.println("[Error] 오류 발생으로 인하여 프로그램이 종료됩니다.");
					break; // 오류(예외처리)시 해당 명령종료
				}

				output_Result.multiply_Result(result_Of_multiply_One); // 결과 출력함수

				break;
			case "2" :
				break;
			case "-1" :
				System.out.println("===== BigInt 계산기를 종료합니다. =====");
				return ;
			default:
				System.out.println("[Error] 잘못된 입력입니다.");
				break;
			}
		}
	}

	public void setup() {

	}
}
