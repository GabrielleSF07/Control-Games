package controlgames.controlgamesbd.dao;


import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabrielle
 */
public class Jogos {
    
    private String nome, descricao, categoria, dataLancamento, desenvolvedora, status;
    private int faixaEtaria, qntdeVendas, id;
    private double valor, lucro;

    public Jogos(String nome, String descricao, String categoria, String dataLancamento, String desenvolvedora, int faixaEtaria, double valor, String status, int qntdeVendas, double lucro, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
        this.desenvolvedora = desenvolvedora;
        this.faixaEtaria = faixaEtaria;
        this.valor = valor;
        this.status = status;
        this.qntdeVendas = qntdeVendas;
        this.lucro = lucro;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

     public int registrarVenda() {
        qntdeVendas++;
        lucro += valor;
        return qntdeVendas;
    }

    public int getVendas() {
        return qntdeVendas;
    }

    public double getLucro() {
        return lucro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTotalVendas() {
    return this.qntdeVendas; 
}

    public void setQntdeVendas(int qntdeVendas) {
        this.qntdeVendas = qntdeVendas;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    
    public int getTotalVendas(List<Usuarios> listaUsuarios) {
    int total = 0;
    for (Usuarios u : listaUsuarios) {
        for (Jogos j : u.getJogosComprados()) {
            if (j.equals(this)) {
                total++;
            }
        }
    }
    return total;
    }
    
}
