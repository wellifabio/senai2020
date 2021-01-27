/*De acordo com o arquivo "entrada3.txt", temos uma tabela,
 * separada por <TAB> com os dados da Pandemia
 * (País, Confirmados, Recuperados e Mortes) copiados
 * do google em 05/07/2020.
 * Crie um programa que leia estas entradas do arquivo
 * e as mostre em forma de porcentagem comparando cada país.
 * 
 * Exemplo de saída:
	Estados Unidos	72%	??%	??%
	Brasil	2%	??%	??%
	Rússia	17%	??%	??%
	Espanha	9%	??%	??%
*/

package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exercicio3 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static String[] campos;
	private static String linha;
	private static int totalConfirmados = 0;
	private static int totalRecuperados = 0;
	private static int totalMortes = 0;
	private static ArrayList<String> paises = new ArrayList<>();
	private static ArrayList<Integer> confirmados = new ArrayList<>();
	private static ArrayList<Integer> recuperados = new ArrayList<>();
	private static ArrayList<Integer> mortes = new ArrayList<>();

	public static void main(String[] args) {

		try {
			br = new BufferedReader(new FileReader("entrada3.txt"));
			linha = br.readLine();
			while (linha != null) {
				campos = linha.split("\t");

				paises.add(campos[0]);
				confirmados.add(Integer.parseInt(campos[1]));
				recuperados.add(Integer.parseInt(campos[2]));
				mortes.add(Integer.parseInt(campos[3]));

				totalConfirmados += Integer.parseInt(campos[1]);
				totalRecuperados += Integer.parseInt(campos[2]);
				totalMortes += Integer.parseInt(campos[3]);

				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro " + e);
		}
		try {
			bw = new BufferedWriter(new FileWriter("saida.txt"));
			for (int i = 0; i < paises.size(); i++) {
				bw.write(paises.get(i) + " ");
				bw.write(String.format("%.0f%% ", (float) confirmados.get(i) / totalConfirmados * 100));
				bw.write(String.format("%.0f%% ", (float) recuperados.get(i) / totalRecuperados * 100));
				bw.write(String.format("%.0f%%\r\n", (float) mortes.get(i) / totalMortes * 100));
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro " + e);
		}

	}

}
