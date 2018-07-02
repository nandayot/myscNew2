package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MusicaExpandidaActivity extends AppCompatActivity {
    protected static final String TAG = "BANCO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_expandida);

        TextView id = findViewById(R.id.id);
        TextView nome = findViewById(R.id.nome);
        TextView letra = findViewById(R.id.letra);
        TextView compositor = findViewById(R.id.compositor);
        TextView artista = findViewById(R.id.artista);
        Bundle args = getIntent().getExtras();


        long idMusica = args.getLong("id");
        Log.d(TAG, "id   "+idMusica);
        String nomeMusica = args.getString("nome");
        Log.d(TAG, "nome   "+nomeMusica);
        String letraMusica = args.getString("letra");
        Log.d(TAG, "letra   "+letraMusica);
        String compositorMusica = args.getString("compositor");
        Log.d(TAG, "compositor   "+compositorMusica);
        String artistaMusica = args.getString("artista");
        Log.d(TAG, "artista   "+artistaMusica);

        id.setText("ID:  "+idMusica);
        nome.setText("NOME:  "+nomeMusica);
        letra.setText(letraMusica);
        compositor.setText("COMPOSITOR: "+compositorMusica);
        artista.setText("ARTISTA:  "+artistaMusica);

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detalhes da música");

        //Botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_editar_am, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent(getContext(), ListarMusicaActivity.class);
            startActivity(intent);
            finish();
        }
        if(id == R.id.action_edit){
            Intent intent = new Intent( getContext(), EditarMusicaActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private Context getContext(){
        return this;
    }
}
