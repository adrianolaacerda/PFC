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
    private int id;
    private String nome;
    private Date dataValidade;
    private int quantidade;
    private double preco;
    private TipoProduto tipoPreco;
    private Categoria categoria;
    private String imagem;

    //construtor vazio
    public Produto() {
    }
    
    //construtor 

    public Produto(int id, String nome, Date dataValidade, int quantidade, double preco, TipoProduto tipoPreco, Categoria categoria, String imagem) {
        this.id = id;
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tipoPreco = tipoPreco;
        this.categoria = categoria;
        this.imagem = imagem;
    }
    

    //getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoProduto getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoProduto tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
   


    
}
