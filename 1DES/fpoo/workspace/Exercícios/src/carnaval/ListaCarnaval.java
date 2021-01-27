package carnaval;
/*snag.gy/bxwZju*/
import java.util.Scanner;

public class ListaCarnaval {
	
	public static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		int menu = 0;
		while (menu != 5) {
			System.out.println("1.Exercício1\n2.Exercício2");
			System.out.println("3.Exercício3\n4.Exercício4\n5.Fim");
			menu = read.nextInt();
			if(menu == 1){
				float salHora = (float)5.625;
				float totalHoras, totalExtras;
				System.out.println("Digite o total de horas mensais:");
				totalHoras = read.nextFloat();
				System.out.println("Digite o total de horas extras:");
				totalExtras = read.nextFloat();
				float salMes = salHora * totalHoras;
				float salExtra = salHora * totalExtras + salHora * totalExtras * 75 / 100;
				float salReajustado = salMes + salExtra;
				System.out.printf("O salario líquido é R$%.2f\n",salMes);
				System.out.printf("O valor horas extras é R$%.2f\n",salExtra);
				System.out.printf("O salario reajustado é R$%.2f\n",salReajustado);
				System.out.println("\n\n\n");
			}else if(menu == 2){
				String[] nome = new String[5];
				int[] bateria = new int[5];
				int[] sambaEnredo = new int[5];
				int[] fantasias = new int[5];
				float[] media = new float[5];
				System.out.println("Digite a tabela das escolas com os dados abaixo:");
				System.out.println("Nome, bateria, samba e fantasias:");
				for(int i = 0; i < 5; i++){
					nome[i] = read.next();
					bateria[i] = read.nextInt();
					sambaEnredo[i] = read.nextInt();
					fantasias[i] = read.nextInt();
				}
				float maiorMedia = 0;
				int campea = 0;
				System.out.println("Nome, Média:");
				for(int i = 0; i < 5; i++){
					media[i] = (float)(bateria[i]+sambaEnredo[i]+fantasias[i])/3;
					System.out.printf("%s,\t%.1f\n",nome[i],media[i]);
					if(media[i] > maiorMedia){
						maiorMedia = media[i];
						campea = i;
					}
				}
				System.out.printf("A campeã é %s com média %.1f\n",nome[campea],maiorMedia);
				System.out.println("\n\n\n");
			}else if(menu == 3){
				String[] materiaPrima = new String[3];
				float[] quantidadekilo = new float[3];
				float[] valorKilo = new float[3];
				float[] totalEstimado = new float[3];
				System.out.println("Digite os dados da tabela abaixo:");
				System.out.println("MateriaPrima, Quilo, Preço, Estimado");
				for(int i = 0; i < 3; i++){
					materiaPrima[i] = read.next();
					quantidadekilo[i] = read.nextFloat();
					valorKilo[i] = read.nextFloat();
					totalEstimado[i] = read.nextFloat();
				}
				float totalMaterial = 0;
				for(int i = 0; i < 3; i++){
					totalMaterial = quantidadekilo[i] * valorKilo[i];
					System.out.println(materiaPrima[i]+" total: "+totalMaterial);
					if(totalMaterial > totalEstimado[i]){
						System.out.println(" Excedido.");
					}
				}
				System.out.println("\n\n\n");
			}else if(menu == 4){
				int comissaoDeFrente = 15;
				int abreAlas = 5;
				int alaDasBaianas = 15;
				int carroAlegórico = 20;
				int mestreSalaEPortaBandeira = 3;
				int bateria	= 20;
				int madrinhaDaBateria = 2;
				int recuoDaBateria = 20;
				System.out.println("Digite o total de pessoas que irão desfilar na Imperatriz HTML");
				int totalPessoas = read.nextInt();
				System.out.println("Então a distribuição das pessoas será a seguinte:");
				System.out.println((totalPessoas * comissaoDeFrente / 100)+" na Comissão de Frente");
				System.out.println((totalPessoas * abreAlas / 100)+" no carro Abre Alas");
				System.out.println((totalPessoas * alaDasBaianas / 100)+" na Ala das Baianas");
				System.out.println((totalPessoas * carroAlegórico / 100)+" nos Carros Alegóricos");
				System.out.println((totalPessoas * mestreSalaEPortaBandeira / 100)+" como Mestre Sala e Porta Bandeira");
				System.out.println((totalPessoas * bateria / 100)+" na Bateria");
				System.out.println((totalPessoas * madrinhaDaBateria / 100)+" como Madrinhas de Bateria");
				System.out.println((totalPessoas * recuoDaBateria / 100)+" no Recuo da Bateria\n\n\n");
			}else if(menu == 5){
				System.out.println("Valeus, Falows!!");
			}else{
				System.out.println("Opção inválida.");
			}
		}
	}
}
