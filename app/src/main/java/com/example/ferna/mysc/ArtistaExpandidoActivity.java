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
import android.widget.Toast;


public class ArtistaExpandidoActivity extends AppCompatActivity {
    protected static final String TAG = "BANCO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista_expandido);

        TextView id = findViewById(R.id.idArtista);
        TextView nome = findViewById(R.id.nomeArtista);
        TextView data = findViewById(R.id.dataArtista);
        TextView nacionalidade = findViewById(R.id.nacionalidadeArtista);
        Bundle args = getIntent().getExtras();


        long idArtista = args.getLong("id");
        Log.d(TAG, "id   "+idArtista);
        String nomeArtista = args.getString("nome");
        Log.d(TAG, "nome   "+nomeArtista);
        String dataArtista = args.getString("data");
        Log.d(TAG, "data   "+dataArtista);
        String nacionalidadeArtista = args.getString("nacionalidade");
        Log.d(TAG, "compositor   "+nacionalidadeArtista);

        id.setText("ID:  "+idArtista);
        nome.setText("NOME:  "+nomeArtista);
        data.setText("DATA:  "+dataArtista);
        nacionalidade.setText("NACIONALIDADE: "+nacionalidadeArtista);

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detalhes do artista");

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
            Intent intent = new Intent(getContext(), ListarArtistaActivity.class);
            startActivity(intent);
            finish();
        }
        if(id == R.id.action_edit){
            Intent intent = new Intent( getContext(), EditarArtistaActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Context getContext(){
        return this;
    }
}
