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
 * @author PC
 */
public class Pessoa {

    private int id;
    private String nome;
    private int cpf;
    private int rg;
    private Date dataNasc;
    private String email;
    private String telefone;
    private String logradouro;
    private int numero;
    private int cep;
    private String bairro;
    private String cidade;
    private String estado;
    private Usuario usuario;
    private List<Pessoa> pessoas;// tem muitos
    
    public void addPessoa (Pessoa pessoa){
        if(pessoa == null){
            this.pessoas = new ArrayList<>();
        }
    }

    public Pessoa (List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoa> getPessoa() {
        return pessoas;
    }

    public void setPessoa(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    //construtor vazio
    
    public Pessoa() {
    }
    
    //construtor
    
     public Pessoa(int id, String nome, int cpf, int rg, Date dataNasc, String email, String telefone, String logradouro, int numero, int cep, String bairro, String cidade, String estado, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.usuario = usuario;
    }
    
    // getter e setter
    
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
