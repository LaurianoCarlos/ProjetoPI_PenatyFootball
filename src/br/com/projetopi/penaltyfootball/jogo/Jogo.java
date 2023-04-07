package br.com.projetopi.penaltyfootball.jogo;

import java.util.Scanner;

import br.com.projetopi.penaltyfootball.BancoDeDados.DbMetodos;
import br.com.projetopi.penaltyfootball.animacao.Animacao;
import br.com.projetopi.penaltyfootball.mododejogo.ModoHistoria;
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
		ModoHistoria modoHistoria = new ModoHistoria();
		
		do {

			Animacao.exibirMenuInicial();
			System.out.print("Opcao: ");

			//tratamento de excecao
			if (input.hasNextInt()) { // verifica se há um valor inteiro disponível no fluxo de entrada
			    opcao = input.nextInt(); // se houver, lê o valor inteiro e atribui à variável "opcao"
			} else {
			    System.out.println("Entrada inválida. Por favor, tente novamente."); // se não houver, exibe uma mensagem de erro
			}

			do {
				
				if (opcao < 1 || opcao > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
					System.out.println();
					System.out.print("Opcao: ");
					 opcao = input.nextInt();
					
				}
			} while (opcao < 1 || opcao > 5);


			switch (opcao) {
			case 1:
				modoSolo.modoSolo();
		break;
			case 2:
				multiJogador.multiJogador();
		break;
			case 3:
				modoHistoria.iniciarModoHistoria();
		break;
			case 4:
				modoRankeada.Rankedada();
				break;
			case 5:
				DbMetodos.exibirRanking();
				break;
				default:
					System.out.println("Opcao Inválida");
			}
			
				

		} while (opcao != 0);
		
		input.close();
	}
}
