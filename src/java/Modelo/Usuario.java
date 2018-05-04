/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Usuario {

    private int id;
    private String login;
    private String senha;
    private PerfilDeAcesso perfil;
    private Pessoa pessoa;
    
    //construtor vazio
    public Usuario() {
    }
    
    // construtor
        public Usuario(int id, String login, String senha, PerfilDeAcesso perfil, Pessoa pessoa) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.pessoa = pessoa;
    }
    
    // getter e setter
        
public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilDeAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDeAcesso perfil) {
        this.perfil = perfil;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
   