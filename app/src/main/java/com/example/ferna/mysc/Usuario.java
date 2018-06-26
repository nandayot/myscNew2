package com.example.ferna.mysc;

/**
 * Created by ferna on 25/06/2018.
 */


public class Usuario {
    long id = 0;
    String login;
    String senha;
    String email;
    String nascimento;

    public Usuario(long id, String login, String senha, String email, String nascimento)
    {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Usuario(String login, String senha, String email, String nascimento)
    {
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nascimento = nascimento;
    }

    public String toString()
    {
        return "\n"+this.login;
    }

}
