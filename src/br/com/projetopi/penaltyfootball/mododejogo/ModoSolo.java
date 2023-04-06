package br.com.projetopi.penaltyfootball.mododejogo;



import java.util.Scanner;

import br.com.projetopi.penaltyfootball.animacao.Animacao;
import br.com.projetopi.penaltyfootball.usuario.Usuario;

public class ModoSolo {

	protected int goleiro;
	protected  int placarJogador;
	protected int placarGoleiro;
	protected String jogarNovamente;

	/*definido para pegar dados do usuario nas funcoes */
	protected Scanner input;

	public ModoSolo() {
		this.input = new Scanner(System.in);
	}

	public int getGoleiro() {
		return goleiro;
	}

	public void setGoleiro(int goleiro) {
		this.goleiro = goleiro;
	}

	public int getPlacarJogador() {
		return placarJogador;
	}

	public void setPlacarJogador(int placarJogador) {
		this.placarJogador = placarJogador;
	}

	public int getPlacarGoleiro() {
		return placarGoleiro;
	}

	public void setPlacarGoleiro(int placarGoleiro) {
		this.placarGoleiro = placarGoleiro;
	}

	protected int numeroAleatorio() {

		int cantoGoleiro = ((int) (Math.random() * 5) + 1);
		return cantoGoleiro;
	}

	protected int escolherNivel() {

		System.out.println();
		System.out.println("DIFICULDADE:");
		System.out.println();

		System.out.println("[1] FÁCIL\n[2] MÉDIO\n[3] DIFÍCIL");
		System.out.print("Escolha uma dificuldade (Insira número): ");
		int nivel = input.nextInt();

		return nivel;
	}

	protected int nivel(int nivel, int cantoSelecionado, int goleiro) {
		int numero[] = new int[4];

		switch (nivel) {
		case 1:
			for (int c = 0; c <= 0; c++) {
				numero[c] =  ((int) (Math.random() * 10) + 1);

				if (cantoSelecionado == numero[c]) {

					goleiro = numero[c];
				}
			}
			break;

		case 2:
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();

				if (cantoSelecionado == numero[c]) {

					goleiro = numero[c];
				}
			}

			break;

		case 3:
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();

				if (cantoSelecionado == numero[c]) {

					goleiro = numero[c];
				}
			}

			break;
		default:

		}
		return goleiro;
	}

	protected boolean verificarPenalty(int cantoSelecionado, int goleiro) {

		boolean gol = true;

		if (cantoSelecionado == goleiro) {
			gol = false;
		}

		return gol;
	}

	protected String nomeJogador() {

		System.out.print("Insira seu nome: ");
		String nome = input.nextLine();

		System.out.println();

		System.out.println("Seja Bem vindo, " + nome);
		System.out.println();
		System.out.println("Vamos as cobranças?!");

		System.out.println();

		return nome;
	}

	protected int escolherCanto() {

		System.out.println("\nESCOLHA UM CANTO!!!\n");

		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println("II                              II");
		System.out.println("II  1                        4  II");
		System.out.println("II                              II");
		System.out.println("II              3               II");
		System.out.println("II                              II");
		System.out.println("II  2                        5  II");
		System.out.println("II                              II \n");

		System.out.println(
				"[1] Superior esquerdo \n[2] Inferior esquerdo \n[3] Meio \n[4] Superior Direito \n[5] Inferior Direito\n");
		System.out.print("Opcao: ");
		int canto = input.nextInt();
		return canto;
	}

	public void modoSolo() {
		// Chama o método de inicialização da animação
		Animacao.inicializacaoModoSolo();

		// Cria um objeto de usuário com o nome informado pelo jogador
		Usuario usuario = new Usuario(nomeJogador());

		do {
			// Entra em um loop até que o usuário escolha um nível de jogo válido (entre 1 e
			// 3)
			usuario.setNivelDeJogo(escolherNivel());

			if (usuario.getNivelDeJogo() < 1 || usuario.getNivelDeJogo() > 3) {
				System.out.println();
				System.out.println("[Insercao invalida]");
			}

		} while (usuario.getNivelDeJogo() < 1 || usuario.getNivelDeJogo() > 3);

		jogarNovamente = "S";
		// Define os placares do jogador e do goleiro como zero
		placarJogador = 0;
		placarGoleiro = 0;

		// Entra em um loop enquanto o usuário desejar jogar novamente
		while (!(jogarNovamente == "N")) {

			// Entra em um loop até que o usuário escolha um canto válido (entre 1 e 5)
			do {
				usuario.setCantoSelecionado(escolherCanto());

				if (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
				}

			} while (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5);

			// Gera um número aleatório para representar a escolha do goleiro
			goleiro = numeroAleatorio();
			// Calcula o nível de dificuldade do goleiro com base no nível de jogo escolhido
			// pelo usuário, no canto selecionado e na escolha aleatória do goleiro
			int nivelLooping = nivel(usuario.getNivelDeJogo(), usuario.getCantoSelecionado(), goleiro);
			// Verifica se o usuário fez um gol ou não, com base no canto selecionado e no
			// nível de dificuldade do goleiro
			boolean gol = verificarPenalty(usuario.getCantoSelecionado(), nivelLooping);

			// Chama o método de animação para mostrar se o usuário fez um gol ou não
			Animacao.gol(gol);

			System.out.println();
			// Atualiza os placares de acordo com o resultado do pênalti
			if (gol) {
				placarJogador++;
			} else {
				placarGoleiro++;
			}

			// Exibe os placares atualizados e a escolha do jogador e do goleiro
			System.out.println();
			System.out.println("Batedor: " + usuario.getCantoSelecionado() + " Goleiro: " + nivelLooping);
			System.out.println("Gols[" + placarJogador + "] " + "Defesas[" + placarGoleiro + "]");

			System.out.println();

			// Verifica o ganhador da partida e encerra o loop/jogo
			if (placarJogador >= 5) {
				// exibi a mensagem do vencedor
				Animacao.exibirGanhador(true);
				System.out.println();
				break;
			}
			if (placarGoleiro >= 5) {
				// exibi a mensagem do perdedor
				Animacao.exibirGanhador(false);
				System.out.println();
				break;
			}

			// Tratamento de erro,limpeza do buffer de entrada
			input.nextLine();// Isso garante que a próxima leitura do Scanner será feita corretamente.

			String entrada = "S";

			// Entra em um loop enquanto o usuário desejar jogar novamente
			do {
				System.out.print("Deseja jogar novamente (S/N)? ");
				entrada = input.nextLine().toUpperCase();

				// tratamento de erro, verifica se a entrada tem pelo menos um caractere
				if (entrada.length() > 0) {
					jogarNovamente = entrada.charAt(0) + "";
				} else {
					jogarNovamente = "";
				}

			} while (!(jogarNovamente.equalsIgnoreCase("S") || jogarNovamente.equalsIgnoreCase("N")));

			// Encerramento do modo de jogo solo
			if (jogarNovamente.equalsIgnoreCase("N")) {

				System.out.println();
				System.out.println("--- Modo solo encerrado ---");
				System.out.println();
				break;
			}
		}
	}
}
