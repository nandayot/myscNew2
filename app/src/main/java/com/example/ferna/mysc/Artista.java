package com.example.ferna.mysc;

/**
 * Created by ferna on 26/06/2018.
 */

public class Artista {
    long id = 0;
    String nome, data, nacionalidade;

    public Artista(long id, String nome, String data, String nacionalidade){
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.nacionalidade = nacionalidade;
    }

    public Artista(String nome, String data, String nacionalidade){
        this.nome = nome;
        this.data = data;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Id:"+ id +"\nNome: "+ nome;
    }
}
