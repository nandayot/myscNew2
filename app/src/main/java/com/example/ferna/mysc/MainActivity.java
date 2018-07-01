package com.example.ferna.mysc;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonRegister = (Button) findViewById(R.id.btCadastrar);
        buttonRegister.setOnClickListener(onClickCadastroActivity());
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(onClickLogin());
        Button btSair = (Button) findViewById(R.id.btSair);
        btSair.setOnClickListener(onClickSair());
        //Título
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_refresh);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_refresh){
            TextView tLogin = (TextView) findViewById(R.id.tLogin);
            TextView tSenha = (TextView) findViewById(R.id.tSenha);

            tLogin.setText("");
            tSenha.setText("");

            alert("Clicou em atualizar.");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickSair(){
        return new Button.OnClickListener(){

            public void onClick(View v){
                finish();
            }
        };
    }

    private View.OnClickListener onClickLogin() {
        return new Button.OnClickListener() {

            public void onClick(View v) {

                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                ConteudoBD udb = new ConteudoBD(getContext());
                Usuario usuario = null;

                usuario = udb.buscarUsuario(login);

                if(usuario != null) {
                    if (login.equals(usuario.login) && senha.equals(usuario.senha)) {
                        alert("Bem-vindo " + login + " login feito com sucesso.");

                        // Navega para a próxima tela
                        Intent intent = new Intent(getContext(), HomeActivity.class);
                        Bundle params = new Bundle();
                        params.putString("nome", login);
                        params.putString("anterior", "Home");
                        intent.putExtras(params);
                        startActivity(intent);
                    }
                    else {
                        alert("Login ou senha incorretos");
                    }
                }
                else {
                    alert("Login ou senha incorretos");
                }
            }
        };
    }

    public View.OnClickListener onClickCadastroActivity(){
        return new Button.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent( getContext(), CadastroActivity.class);
                startActivity(intent);
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
