package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static java.security.AccessController.getContext;

public class HomeActivity extends AppCompatActivity {
    protected static final String TAG = "BANCO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Definindo os botões
        Button cdArtista = (Button) findViewById(R.id.cdArtista);
        Button cdMusica = (Button) findViewById(R.id.cdMusica);
        Button ltArtista= (Button) findViewById(R.id.ltArtista);
        Button ltMusica = (Button) findViewById(R.id.ltMusica);
        Button btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(onClickSair());
        cdArtista.setOnClickListener(onClickArtista());
        cdMusica.setOnClickListener(onClickMusica());
        ltArtista.setOnClickListener(onClickListarArtista());
        ltMusica.setOnClickListener(onClickListarMusica());
        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        //Botão de voltar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private View.OnClickListener onClickSair(){
        return new Button.OnClickListener(){

            public void onClick(View v){
                finish();
            }
        };
    }

    private View.OnClickListener onClickArtista() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getContext(), cdArtistaActivity.class);
                //PARA PASSAR DE TELA EM TELA
                //Bundle params = new Bundle();
                //params.putString("nome", "usuario");
                //params.putString("anterior", "Home");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickMusica() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getContext(), cdMusicaActivity.class);
                //Bundle params = new Bundle();
                //params.putString("nome", "usuario");
                //params.putString("anterior", "Home");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickListarArtista() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "Entrou onClicklistarArtista()");
                Intent intent = new Intent(getContext(), ListarArtistaActivity.class);
                //Bundle params = new Bundle();
                //params.putString("nome", "usuario");
                //params.putString("anterior", "Home");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickListarMusica() {
        return new Button.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "Entrou onClicklistarMusica()");
                Intent intent = new Intent(getContext(), ListarMusicaActivity.class);
                //Bundle params = new Bundle();
                //params.putString("nome", "usuario");
                //params.putString("anterior", "Home");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private Context getContext(){
        return this;
    }
}
