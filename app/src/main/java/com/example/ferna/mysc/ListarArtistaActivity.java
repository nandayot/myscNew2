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

import java.util.List;

public class ListarArtistaActivity extends AppCompatActivity {
    protected static final String TAG = "BANCO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_artista);

        ListView listaDeArtistas = (ListView) findViewById(R.id.listaArtista);

        ConteudoBD lm = new ConteudoBD(this);
        List<Artista> artistas = lm.listarArtista();

        ArrayAdapter<Artista> adapter = new ArrayAdapter<Artista>(this,
                android.R.layout.simple_list_item_1, artistas);

        listaDeArtistas.setAdapter(adapter);

        listaDeArtistas.setOnItemClickListener(onClickListarArtista());

        //Título
        ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Listagem de Artistas");

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


    AdapterView.OnItemClickListener onClickListarArtista()
    {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Artista a = (Artista) parent.getItemAtPosition(position);

                Bundle bd = new Bundle();
                bd.putLong("id", a.id);
                bd.putString("nome", a.nome);
                bd.putString("data", a.data);
                bd.putString("nacionalidade", a.nacionalidade);

                Intent intent = new Intent(getContext(), ArtistaExpandidoActivity.class);

                intent.putExtras(bd);
                Log.d(TAG, "BD   "+bd);
                startActivity(intent);
            }
        };
    }


    private Context getContext()
    {
        return this;
    }

}



