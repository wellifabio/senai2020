/*A partir das entradas do arquivo "entrada1.txt" anexo a esta atividade,
 * faça um programa que calcule as médias dos alunos e gere um arquivo
 * de saía "saida.txt" no modelo abaixo:
 * Ana media 5
 * Bruna media 9
 * Marcos media 5
 * Juliano media 4*/

package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio1 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static String entrada = "entrada1.txt", saida = "saida.txt";
	private static String linha;
	private static String colunas[] = new String[4];
	private static int[] notas = new int[3];
	private static float media;

	public static void main(String[] args) {

		try {
			br = new BufferedReader(new FileReader(entrada));
			bw = new BufferedWriter(new FileWriter(saida));
			linha = br.readLine();
			while(linha != null) {
				colunas = linha.split(",");
				notas[0] = Integer.parseInt(colunas[1]);
				notas[1] = Integer.parseInt(colunas[2]);
				notas[2] = Integer.parseInt(colunas[3]);
				media = (float)(notas[0]+notas[1]+notas[2])/3;
				bw.write(colunas[0]+" media "+media+"\r\n");
				linha = br.readLine();
			}
			br.close();
			bw.close();
			
		} catch (IOException e) {
			System.out.println("Erro " + e);
			// Tipos de erro ao trabalharmos com arquivos
			// O nome do arquivo pode estar errado
			// Arquivo não encontrado
			// Arquivo muito grande
		}

	}

}
