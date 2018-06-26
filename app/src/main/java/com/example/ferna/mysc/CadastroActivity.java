package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                UsuarioDB udb = new UsuarioDB(getContext());
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
