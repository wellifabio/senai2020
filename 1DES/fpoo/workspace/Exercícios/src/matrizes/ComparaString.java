package matrizes;

public class ComparaString {

	public static void main(String[] args) {
		String s1 = "Ana";
		String s2 = "Maria";
		char ch1s1 = s1.charAt(0);
		char ch1s2 = s2.charAt(0);
		System.out.printf("A primeira letra de %s é %c\n",s1,ch1s1);
		System.out.printf("A primeira letra de %s é %c\n",s2,ch1s2);
		if(ch1s1 > ch1s2){
			System.out.println("Ana maior que Maria");
		}else{
			System.out.println("Maria maior que Ana");
		}
	}
}
