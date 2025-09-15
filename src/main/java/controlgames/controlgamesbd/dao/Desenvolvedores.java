package controlgames.controlgamesbd.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabrielle
 */
public class Desenvolvedores {
   
    private String nome, email, senha;
    private int qntdeJogos, totalVendido, lucroTotal;

    public Desenvolvedores(String nome, String email, String senha, int qntdeJogos, int totalVendido, int lucroTotal) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.qntdeJogos = qntdeJogos;
        this.totalVendido = totalVendido;
        this.lucroTotal = lucroTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQntdeJogos() {
        return qntdeJogos;
    }

    public void setQntdeJogos(int qntdeJogos) {
        this.qntdeJogos = qntdeJogos;
    }

    public int getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(int totalVendido) {
        this.totalVendido = totalVendido;
    }

    public int getLucroTotal() {
        return lucroTotal;
    }

    public void setLucroTotal(int lucroTotal) {
        this.lucroTotal = lucroTotal;
    }
    
  
    
    
    
}
