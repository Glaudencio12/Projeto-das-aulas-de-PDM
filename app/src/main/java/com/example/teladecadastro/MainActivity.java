package com.example.teladecadastro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import persistencia.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nomeUsuario;
    private TextInputEditText senhaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.nomeUsuario = findViewById(R.id.UserLogin);
        this.senhaUsuario = findViewById(R.id.senhaLogin);
    }

   public void AbrirCadastro(View v){
       Intent tela_cadastro = new Intent(this, CadastroUsuarioActivity.class);
       startActivity(tela_cadastro);
   }

    public void principal(View v){
        Intent principal = new Intent(this, PrincipalActivity.class);
        startActivity(principal);
    }

   public void entrar(View v){
       Usuario usuario = new Usuario(this);
       String nome_user = this.nomeUsuario.getText().toString();
       String senha_user = this.senhaUsuario.getText().toString();

       if (nome_user.equals(usuario.getLogin()) && senha_user.equals(usuario.getSenha())) {
           AlertDialog.Builder msg = new AlertDialog.Builder(this);
           msg.setMessage("Login efetuado com sucesso!");
           msg.setTitle("Login");
           msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   Intent tela_pricipal = new Intent(MainActivity.this, PrincipalActivity.class);
                   startActivity(tela_pricipal);
               }
           });
           msg.create();
           msg.show();
       }
   }
}