package com.example.ferna.mysc;

/**
 * Created by ferna on 26/06/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ConteudoBD extends SQLiteOpenHelper {
    protected static final String TAG = "BANCO";
    public static final String NOME_BANCO = "bd_android.sqlite";
    private static final int VERSAO_BANCO = 1;

    public ConteudoBD(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("create table if not exists usuario(id integer primary key autoincrement," +
                "login, senha, email, nascimento);");
        Log.d(TAG, "Criando a tabela usuario...");

        //Tabela artista
        Log.d(TAG, "Criando a tabela artista...");

        db.execSQL("create table if not exists artista(id integer primary key autoincrement," +
                "nome, data, nacionalidade);");
        Log.d(TAG, "Tabela artista criada com sucesso.");

        //Tabela musica
        Log.d(TAG, "Criando a tabela musica...");

        db.execSQL("create table if not exists musica(id integer primary key autoincrement," +
                "nome, letra, compositor, artista);");
        Log.d(TAG, "Tabela musica criada com sucesso.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "DROP TABLE IF EXISTS musica";
        db.execSQL(sql);
        onCreate(db);
    }

    public long save(Usuario u)
    {
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put("login", u.login);
            values.put("senha", u.senha);
            values.put("email", u.email);
            values.put("nascimento", u.nascimento);

            id = db.insert("usuario", "", values);
            return id;
        } finally {
            db.close();
        }
    }

    public Usuario buscarUsuario(String login)
    {
        SQLiteDatabase db = getWritableDatabase();
        Usuario u = null;

        Cursor cursor = db.query("usuario", new String[]{"id", "login", "senha", "email", "nascimento"},
                "login=?", new String[]{login}, null, null, null, null);

        if(cursor.moveToNext())
        {
            u = new Usuario(cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("login")),
                    cursor.getString(cursor.getColumnIndex("senha")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("nascimento")));
        }

        return u;
    }

    //Cadastrando Artista
    public long cdArtista(Artista a){
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put("nome", a.nome);
            values.put("data", a.data);
            values.put("nacionalidade", a.nacionalidade);

            id = db.insert("artista", "", values);

            Log.d(TAG, "Artista "+a.nome+" adicionado.");
            return id;
        } finally{
            db.close();
        }
    }

    //Cadastrando Musica
    public long cdMusica(Musica m){
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put("nome", m.nome);
            values.put("letra", m.letra);
            values.put("compositor", m.compositor);
            values.put("artista", m.artista);

            id = db.insert("musica", "", values);

            Log.d(TAG, "Música "+m.nome+" adicionado.");
            return id;
        } finally{
            db.close();
        }
    }

    public List<Musica> listarMusicas()
    {
        SQLiteDatabase db = getWritableDatabase();
        List<Musica> lista2 = new ArrayList<Musica>();

        String[] campos = {"id", "nome", "letra", "compositor", "artista"};
        Cursor cursor = db.query("musica", campos,null, null, null, null, null, null);

        while(cursor.moveToNext())
        {

            Musica n1 = new Musica(cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("letra")),
                    cursor.getString(cursor.getColumnIndex("compositor")),
                    cursor.getString(cursor.getColumnIndex("artista")));
            Log.d(TAG, "ID Nome e artista..."+n1);

            lista2.add(n1);
        }

        return lista2;
    }

    public List<Artista> listarArtista()
    {
        SQLiteDatabase db = getWritableDatabase();
        List<Artista> listaArtista = new ArrayList<Artista>();

        String[] campos2 = {"id", "nome", "data", "nacionalidade"};
        Cursor cursor = db.query("artista", campos2,null, null, null, null, null, null);

        while(cursor.moveToNext())
        {
            Artista a = new Artista(cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("data")),
                    cursor.getString(cursor.getColumnIndex("nacionalidade")));
            Log.d(TAG, "ARTISTAAAAAAAAA..."+a);

            listaArtista.add(a);
        }

        return listaArtista;
    }
}
