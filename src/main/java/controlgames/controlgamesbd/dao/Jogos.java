package controlgames.controlgamesbd.dao;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jogos")
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private String categoria;

    @Column
    private String status;

    @Column(name = "faixa_etaria")
    private int faixaEtaria;

    @Column
    private double valor;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    // Correção: associação ManyToOne com Desenvolvedores
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desenvolvedora_id", nullable = false)
    private Desenvolvedores desenvolvedora;

    @Column(name = "quantidade_vendida")
    private int qntdeVendida;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getFaixaEtaria() { return faixaEtaria; }
    public void setFaixaEtaria(int faixaEtaria) { this.faixaEtaria = faixaEtaria; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public Desenvolvedores getDesenvolvedora() { return desenvolvedora; }
    public void setDesenvolvedora(Desenvolvedores desenvolvedora) { this.desenvolvedora = desenvolvedora; }

    public int getQntdeVendida() { return qntdeVendida; }
    public void setQntdeVendida(int qntdeVendida) { this.qntdeVendida = qntdeVendida; }
}