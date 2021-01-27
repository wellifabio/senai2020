package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos1 {

	public static void main(String[] args) {
		
		int contador = 0;
		int acumulador = 0;
		String [] colunas = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
			String linha = br.readLine();
			while(linha != null) {
				colunas = linha.split("\t");
				System.out.print("Nome "+colunas[0]);
				System.out.println(" Cargo "+colunas[1]);
				acumulador += Integer.parseInt(colunas[2]);
				linha = br.readLine();
				contador++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saida.txt",true));
			bw.write("O arquivo de entrada possuia "+contador+" linhas");
			bw.write(" e "+colunas.length+" colunas\r\n");
			bw.write("A soma das idades das pessoas é "+acumulador+"\r\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
