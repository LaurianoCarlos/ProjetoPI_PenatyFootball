package br.com.projetopi.penaltyfootball.animacao;

public  class Animacao {

	public static void exibirMenuInicial() {
		System.out.println("--[1] INICIAR JOGO\n--[2] MULTIPLAYER\n--[3] MODO HISTORIA\n--[4] RANKEADA\n--[0] SAIR \n");
	}

	public static void inicializacaoModoSolo() {
		System.out.println("PENALTY FOOTBALL");
		System.out.println();
		System.out.println("BEM VINDO A EMOÇÃO, É HORA DE TESTAR O CORAÇÃO!");
		System.out.println();
		System.out.println("QUALIDADE OU SORTE?");
		System.out.println();
		System.out.println("VAMOS DESCOBRIR...");
		System.out.println();

	}
	public static void inicializacaoMultiJogador() {
		System.out.println("PENALTY FOOTBALL MULTIJOGADOR");
		System.out.println();
		System.out.println("QUE VENÇA O MELHOR! ");
		System.out.println();
	}
	
	public static void inicializacaoModoRankeada() {
		System.out.println("PENALTY FOOTBALL RANKEADA");
		System.out.println();
		System.out.println("PROIBIDO ERRAR! VAI TREMER?");
		System.out.println();
		System.out.println("Converta o penalti para continuar, cada gol acrescenta uma pontuacao! boa sorte.");
		System.out.println();

	}

	public static void gol(boolean gol) {

		if (gol) {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("GOOOOOOOOOOOOOOOOOOOOOL");

		} else {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("DEEEFENDEEEEEUUUUUUUUUU OOH GOLEIRO");

		}

	}

	public static void escolherCanto() {

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
	}

	public static void exibirGanhador(boolean vdd) {

		if (vdd) {
			System.out.println("      PARABÉNS VOCÊ GANHOU         ");
			System.out.println("            ____                 ");
			System.out.println("           (    )            ");
			System.out.println("            \\  /             ");
			System.out.println("             ||              ");
			System.out.println("             ||              ");
			System.out.println("            [__]             ");
			System.out.println("           /)  (\\            ");
			System.out.println("          (( () ))           ");
			System.out.println("           \\__            ");
			System.out.println("            `..'             ");
			System.out.println("             ||              ");
			System.out.println("             ||              ");
			System.out.println("            //\\__           ");
			System.out.println("          ((  `--'          ");
			System.out.println("           \\)               ");
			System.out.println("        '''''''''''''''      ");

		} else {

			System.out.println("      VOCÊ PERDEU  ");
			System.out.println("         _       ");
			System.out.println("        |.|      ");
			System.out.println("        ]^[      ");
			System.out.println("      ,-|||~\\   ");
			System.out.println("     {<|||||>}   ");
			System.out.println("      \\|||||/    ");
			System.out.println("      {/   \\}    ");
			System.out.println("      /__9__\\    ");
			System.out.println("      | / \\ |    ");
			System.out.println("      (<   >)     ");
			System.out.println("     _|)   (|_    ");
			System.out.println(" ,.,.(  |.,.|  ).,.,. ");
		}
	}
}
