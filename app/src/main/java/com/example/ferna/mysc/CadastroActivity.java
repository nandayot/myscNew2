package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btCadastro = (Button) findViewById(R.id.btCadastro);
        btCadastro.setOnClickListener(onClickCadastro());
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                onClickCadastro();
            }
        }, 2000);

        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastro");

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
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        if(id == R.id.action_refresh){
            TextView tLogin = (TextView) findViewById(R.id.tLogin);
            TextView tSenha = (TextView) findViewById(R.id.tSenha);
            TextView tEmail = (TextView) findViewById(R.id.tEmail);
            TextView tNascimento = (TextView) findViewById(R.id.tNascimento);

            tLogin.setText("");
            tSenha.setText("");
            tEmail.setText("");
            tNascimento.setText("");

            alert("Clicou em atualizar.");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View.OnClickListener onClickCadastro(){
        return new Button.OnClickListener(){

            public void onClick(View v){

                TextView login = (TextView) findViewById(R.id.tLogin);
                String l = login.getText().toString();

                TextView senha = (TextView) findViewById(R.id.tSenha);
                String s = senha.getText().toString();

                TextView email = (TextView) findViewById(R.id.tEmail);
                String e = email.getText().toString();

                TextView nascimento = (TextView) findViewById(R.id.tNascimento);
                String n = email.getText().toString();

                Usuario usuario = new Usuario(l, s, e, n);
                ConteudoBD udb = new ConteudoBD(getContext());
                udb.save(usuario);

                alert("Usuário cadastrado com sucesso!");

                Intent intent = new Intent(getContext(),
                        MainActivity.class);
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
