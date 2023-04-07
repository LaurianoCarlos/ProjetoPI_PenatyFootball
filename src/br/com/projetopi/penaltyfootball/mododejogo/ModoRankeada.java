package br.com.projetopi.penaltyfootball.mododejogo;

import br.com.projetopi.penaltyfootball.BancoDeDados.DbMetodos;
import br.com.projetopi.penaltyfootball.animacao.Animacao;
import br.com.projetopi.penaltyfootball.usuario.Usuario;

public class ModoRankeada extends ModoSolo {

	public void Rankedada() {

		boolean gol;

		Animacao.inicializacaoModoRankeada();
		
		Usuario usuario = new Usuario(nomeJogador());
		gol = true;

	
			usuario.setNivelDeJogo(1);
			
			jogarNovamente = "S";
			// Define os pontuacao inicial do jogador
			placarJogador = 0;

			while (!(jogarNovamente == "N")) {

				do {
					
					usuario.setCantoSelecionado(escolherCanto());
					input.nextLine();

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
			      gol = verificarPenalty(usuario.getCantoSelecionado(), nivelLooping);
			      
			      Animacao.gol(gol);
			      
			      if(gol == true) {
			    	  usuario.setPontuacao(10);
			      }else {
			    	  break;
			      }
			}
			
			System.out.println();
			System.out.println("--Fim de jogo!!!--");
			System.out.println("Sua pontuacao foi: "+ usuario.getPontuacao()+ " pontos!");
			
			DbMetodos.adicionarNaTabelaRanking(usuario.getNome(), usuario.getPontuacao());
			System.out.println();

	}
}
