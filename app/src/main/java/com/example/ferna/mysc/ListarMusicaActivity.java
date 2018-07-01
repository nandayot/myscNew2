package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListarMusicaActivity extends AppCompatActivity {
    protected static final String TAG = "BANCO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_musica);

        ListView listaDeMusicas = (ListView) findViewById(R.id.lista);

        ConteudoBD lm = new ConteudoBD(this);
        List<Musica> musicas = lm.listarMusicas();

        ArrayAdapter<Musica> adapter = new ArrayAdapter<Musica>(this,
                android.R.layout.simple_list_item_1, musicas);

        listaDeMusicas.setAdapter(adapter);

        listaDeMusicas.setOnItemClickListener(onClickListarMusica());

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Listagem de Músicas");

        //Botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }


    AdapterView.OnItemClickListener onClickListarMusica()
    {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Musica m = (Musica) parent.getItemAtPosition(position);

                Bundle bd = new Bundle();
                bd.putLong("id", m.id);
                bd.putString("artista", m.artista);
                bd.putString("compositor", m.compositor);
                bd.putString("letra", m.letra);
                bd.putString("nome", m.nome);

                Intent intent = new Intent(getContext(), MusicaExpandidaActivity.class);

                intent.putExtras(bd);
                Log.d(TAG, "BD   "+bd);
                startActivity(intent);
            }
        };
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Context getContext()
    {
        return this;
    }

}
