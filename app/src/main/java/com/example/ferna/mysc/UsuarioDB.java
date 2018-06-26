package com.example.ferna.mysc;

/**
 * Created by ferna on 25/06/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UsuarioDB extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "bd_android.sqlite";
    private static final int VERSAO_BANCO = 1;

    public UsuarioDB(Context context){

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists usuario(id integer primary key autoincrement," +
                "login, senha, email, nascimento);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Caso mude a versão do banco de dados, pode-se executar um SQL aqui.
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
}


