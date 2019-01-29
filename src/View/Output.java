package View;

public class Output {
	public void multiply_Result(String result) {
		System.out.println("> 곱셈의 결과값은 다음과 같습니다. ");
		System.out.println(result);
		return ;
	}
	
	public void division_Result(String result_Round , String result_Remainder) {
		System.out.println("> 나눗셈의 결과값은 다음과 같습니다.");
		System.out.println("> 나눗셈의 몫 : " + result_Round);
		System.out.println("> 나눗셈의 나머지 : " + result_Remainder);
		return ;
	}
}
