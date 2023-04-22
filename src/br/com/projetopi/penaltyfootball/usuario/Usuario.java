/*
 * Nome do arquivo: Usuario.java
 * Autor: Ana Lucia,Bruno de Oliveira, Giovanna Moreira, Lauriano Carlos, Melissa Gonçalves
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que contém dados do usuario/jogador
 * Última modificação: 13/04/2023 (Lauriano)
 */
package br.com.projetopi.penaltyfootball.usuario;

import java.util.Random;

public class Usuario {

	private String nome;
    private int nivelDeJogo;
    private int cantoSelecionado;
    private int pontuacao;
    private int id_usuario;
    
Random rdn = new Random();

    public Usuario() {
     this.nome = "Rony";
     this.nivelDeJogo = 1;
     this.cantoSelecionado = 1;
     this.pontuacao = 0;
     this.setId_usuario(rdn.nextInt(10000,99999));
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
        this.pontuacao += pontuacao;
    }

    public int getCantoSelecionado() {
        return cantoSelecionado;
    }

    public void setCantoSelecionado(int cantoSelecionado) {
        this.cantoSelecionado = cantoSelecionado;
    }

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}
