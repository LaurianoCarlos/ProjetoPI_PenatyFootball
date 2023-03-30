package br.com.projetopi.penaltyfootball.jogo;

import java.util.Scanner;

import br.com.projetopi.penaltyfootball.animacao.Animacao;
import br.com.projetopi.penaltyfootball.mododejogo.ModoRankeada;
import br.com.projetopi.penaltyfootball.mododejogo.ModoSolo;
import br.com.projetopi.penaltyfootball.mododejogo.MultiJogador;


public class Jogo {
	
	public static void iniciar() {

		int opcao = -1;
		
	   Scanner input = new Scanner(System.in);
		ModoSolo modoSolo = new ModoSolo();
		MultiJogador multiJogador = new MultiJogador();
		ModoRankeada modoRankeada = new ModoRankeada();
		
		do {

			Animacao.exibirMenuInicial();
			System.out.print("Opcao: ");

			//tratamento de excecao
			if (input.hasNextInt()) { // verifica se há um valor inteiro disponível no fluxo de entrada
			    opcao = input.nextInt(); // se houver, lê o valor inteiro e atribui à variável "opcao"
			} else {
			    System.out.println("Entrada inválida. Por favor, tente novamente."); // se não houver, exibe uma mensagem de erro
			}


			switch (opcao) {
			case 1:
				modoSolo.modoSolo();
		break;
			case 2:
				multiJogador.multiJogador();
		break;
			case 3:
		break;
			case 4:
				modoRankeada.Rankedada();
		break;
			}
			
				

		} while (opcao != 0);
		
		input.close();
	}
}
