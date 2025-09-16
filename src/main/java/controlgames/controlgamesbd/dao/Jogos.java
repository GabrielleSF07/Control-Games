package controlgames.controlgamesbd.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@Entity
public class Jogos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome, descricao, categoria, desenvolvedora, status;
    private int faixaEtaria, qntdeVendas;
    private double valor, lucro;
    private LocalDate dataLancamento;

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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
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
    
   // public int getTotalVendas(List<Usuarios> listaUsuarios) {
   // int total = 0;
   // for (Usuarios u : listaUsuarios) {
   //     for (Jogos j : u.getJogosComprados()) {
   //         if (j.equals(this)) {
   //             total++;
            }
   //     }
   // }
   // return total;
   // }
    

