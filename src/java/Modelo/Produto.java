/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11151102481
 */
public class Produto {

    //declarando atributos 
    private int codigo;
    private String nome;
    private String imagem;
    private Date dataValidade;
    private TipoProduto tipoPreco;
    private double preco;
    private int quantidade;
    private int quantidadeMinima;    
    private Categoria categoria;     
    private List<Produto> produtos;// tem muitos
    
    public void addProduto(Produto produto){
        if(produtos == null){
            this.produtos = new ArrayList<>();
        }
    }

    public Produto() {
    }

    public Produto(int codigo, String nome, String imagem, Date dataValidade, TipoProduto tipoPreco, double preco, int quantidade, int quantidadeMinima, Categoria categoria, List<Produto> produtos) {
        this.codigo = codigo;
        this.nome = nome;
        this.imagem = imagem;
        this.dataValidade = dataValidade;
        this.tipoPreco = tipoPreco;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.categoria = categoria;
        this.produtos = produtos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public TipoProduto getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoProduto tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
}
