programa
{
	
	funcao inicio()
	{
		real salario_bruto
		real inss
		real sal_sem_inss
		real irpf
		real salario_parcial
		inteiro n_dependentes
		escreva("Digite o valor do salário bruto:")
		leia(salario_bruto)
		escreva("Digite o total de dependentes:")
		leia(n_dependentes)
		se (salario_bruto < 1045.01){
			inss = salario_bruto * 7.5 / 100
		} senao se(salario_bruto < 2089.61){ 
			inss = salario_bruto * 9 / 100
		} senao se(salario_bruto < 3134.41){ 
			inss = salario_bruto * 12 / 100
		} senao se(salario_bruto <= 6101.06){ 
			inss = salario_bruto * 14 / 100
		} senao {
			inss = 6101.06 * 14 / 100
		}
		escreva("O valor do INSS é = "+inss)
		sal_sem_inss = salario_bruto - inss
		salario_parcial = sal_sem_inss - n_dependentes * 189.59
		se(salario_parcial < 1903.99){
			irpf = 0.0
		} senao se(salario_parcial < 2826.66){
			irpf = salario_parcial * 7.5 / 100 - 142.80
		} senao se(salario_parcial < 3751.06){
			irpf = salario_parcial * 15 / 100 - 354.80
		} senao se(salario_parcial < 4664.68){
			irpf = salario_parcial * 22.5 / 100 - 636.13
		} senao{
			irpf = salario_parcial * 27.5 / 100 - 869.36
		}
		escreva("O valor do IRPF é = "+irpf)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 33; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */