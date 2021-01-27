/*A partir das entradas do arquivo "entrada2.txt", faça um programa que calcule
 * o tempo de viagem entre as cidades de origem e destino e salve os resultados
 *  em um aquivo chamado "saida.txt"*/

package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exercicio2 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static String entrada = "entrada2.txt";
	private static String saida = "saida.txt";
	private static String linha, origem, destino;
	private static String[] campos;
	private static ArrayList<String> resultados = new ArrayList<>();
	private static int distancia, velocidade;
	private static float tempo;

	public static void main(String[] args) {

		try {
			br = new BufferedReader(new FileReader(entrada));
			linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");

				origem = campos[0];
				distancia = Integer.parseInt(campos[1]);
				destino = campos[2];
				velocidade = Integer.parseInt(campos[3]);
				tempo = (float) distancia / (float) velocidade;
				resultados.add("Origem: " + origem + " Destino: " + destino + ", Tempo: " + tempo + "\r\n");

				linha = br.readLine();
			}
			br.close();

			bw = new BufferedWriter(new FileWriter(saida, false));
			for (String r : resultados) {
				bw.write(r);
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
