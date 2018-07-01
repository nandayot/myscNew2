package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class cdMusicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd_musica);

        //Definindo o botão
        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(onClickCadastrar());

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastrar música");

        //Botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_refresh);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
        if(id == R.id.action_refresh){
            TextView tNomeMusica = (TextView) findViewById(R.id.tNomeMusica);
            TextView tLetra = (TextView) findViewById(R.id.tLetra);
            TextView tCompositor = (TextView) findViewById(R.id.tCompositor);
            TextView tArtista = (TextView) findViewById(R.id.tArtista);

            tNomeMusica.setText("");
            tLetra.setText("");
            tCompositor.setText("");
            tArtista.setText("");

            alert("Clicou em atualizar.");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickCadastrar() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                TextView tNomeMusica = (TextView) findViewById(R.id.tNomeMusica);
                TextView tLetra = (TextView) findViewById(R.id.tLetra);
                TextView tCompositor = (TextView) findViewById(R.id.tCompositor);
                TextView tArtista = (TextView) findViewById(R.id.tArtista);

                String nome = tNomeMusica.getText().toString();
                String letra = tLetra.getText().toString();
                String compositor = tCompositor.getText().toString();
                String artista = tArtista.getText().toString();

                Musica m = new Musica(nome, letra, compositor, artista);
                ConteudoBD bd = new ConteudoBD(getContext());
                bd.cdMusica(m);

                alert("Música cadastrada com sucesso!");

                Intent intent = new Intent(getContext(),
                        HomeActivity.class);
                startActivity(intent);
                finish();

            }
        };
    }
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Context getContext(){
        return this;
    }
}

