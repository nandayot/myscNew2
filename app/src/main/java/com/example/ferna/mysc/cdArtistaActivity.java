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

public class cdArtistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd_artista);

        //Definindo o botão
        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(onClickCadastrar());

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastrar artista");

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
            TextView tNome = (TextView) findViewById(R.id.tNome);
            TextView tData = (TextView) findViewById(R.id.tData);
            TextView tNacionalidade = (TextView) findViewById(R.id.tNacionalidade);

            tNome.setText("");
            tData.setText("");
            tNacionalidade.setText("");

            alert("Clicou em atualizar.");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private View.OnClickListener onClickCadastrar() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                TextView tNome = (TextView) findViewById(R.id.tNome);
                TextView tData = (TextView) findViewById(R.id.tData);
                TextView tNacionalidade = (TextView) findViewById(R.id.tNacionalidade);

                String nome = tNome.getText().toString();
                String data = tData.getText().toString();
                String nacionalidade = tNacionalidade.getText().toString();

                Artista a = new Artista(nome, data, nacionalidade);
                ConteudoBD bd = new ConteudoBD(getContext());
                bd.cdArtista(a);

                alert("Artista cadastrado com sucesso!");

                Intent intent = new Intent(getContext(),
                        HomeActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }

    private Context getContext(){
        return this;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}

