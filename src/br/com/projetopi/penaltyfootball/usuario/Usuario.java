package br.com.projetopi.penaltyfootball.usuario;

public class Usuario {

	private String nome;
    private int nivelDeJogo;
    private int cantoSelecionado;
    private int pontuacao;
    

    public Usuario() {
     this.nome = "Rony";
     this.nivelDeJogo = 1;
     this.cantoSelecionado = 1;
     this.pontuacao = 0;
    }

    public Usuario(String nome) {
        this.nome = nome;
        this.nivelDeJogo = 1;
        this.cantoSelecionado = 1;
        this.pontuacao = 0;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelDeJogo() {
        return nivelDeJogo;
    }

    public void setNivelDeJogo(int nivelDeJogo) {
        this.nivelDeJogo = nivelDeJogo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getCantoSelecionado() {
        return cantoSelecionado;
    }

    public void setCantoSelecionado(int cantoSelecionado) {
        this.cantoSelecionado = cantoSelecionado;
    }
}
