package View;

public class Output {
	public void multiply_Result(String result) {
		System.out.println("> ������ ������� ������ �����ϴ�. ");
		System.out.println(result);
		return ;
	}
	
	public void division_Result(String result_Round , String result_Remainder) {
		System.out.println("> �������� ������� ������ �����ϴ�.");
		System.out.println("> �������� �� : " + result_Round);
		System.out.println("> �������� ������ : " + result_Remainder);
		return ;
	}
}
