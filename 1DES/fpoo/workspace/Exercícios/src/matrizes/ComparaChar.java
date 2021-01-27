package matrizes;

public class ComparaChar {

	public static void main(String[] args) {
		char ch1 = 'a';
		char ch2 = 'b';
		System.out.printf("O ASCCI de ch1 é %d e o CHAR é %c\n",(int)ch1, ch1);
		System.out.printf("O ASCCI de ch2 é %d e o CHAR é %c\n",(int)ch2, ch2);	
		if(ch1 > ch2){
			System.out.println("a maior que b");
		}else{
			System.out.println("b maior que a");
		}
	}
}
