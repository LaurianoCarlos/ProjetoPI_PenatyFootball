
/*
 * Nome do arquivo: PenaltyFootball.java
 * Autor: lauriano
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que manipula os comando do usuario para executar metodos de jogo
 * Colaboradores: Ana Lucia,Bruno de Oliveira, Giovanna Moreira, Melissa Gonçalve, Lauriano Carlos
 * Última modificação: 13/04/2023 (Lauriano)
 */
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

			// tratamento de excecao
			if (input.hasNextInt()) { // verifica se há um valor inteiro disponível no fluxo de entrada
				opcao = input.nextInt(); // se houver, lê o valor inteiro e atribui à variável "opcao"
			} else {
				System.out.println("Entrada inválida. Por favor, tente novamente."); // se não houver, exibe uma
																						// mensagem de erro
			}

			do {
				// Entra em um loop até que o usuário escolha uma opcção válida (entre 0 e 5)
				if (opcao < 0 || opcao > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
					System.out.println();
					System.out.print("Opcao: ");
					opcao = input.nextInt();

				}
				// Entra em um loop até que o usuário escolha uma opcção válida (entre 0 e 5)
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
				break;
			}

		} while (opcao != 0);

		input.close();
	}
}
