package com.example.ferna.mysc;

/**
 * Created by ferna on 26/06/2018.
 */

public class Musica {
    long id = 0;
    String nome, letra, compositor, artista;

    public Musica(long id, String nome, String letra, String compositor, String artista){
        this.id = id;
        this.nome = nome;
        this.letra = letra;
        this.compositor = compositor;
        this.artista = artista;
    }

    public Musica(long id, String nome, String artista){
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }

    public Musica(String nome, String letra, String compositor, String artista){
        this.nome = nome;
        this.letra = letra;
        this.compositor = compositor;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Id:"+ id +"\nNome: "+ nome;
    }
}
