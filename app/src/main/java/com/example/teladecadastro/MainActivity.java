package com.example.teladecadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

   public void AbrirCadastro(View v){
       Intent tela_cadastro = new Intent(this, CadastroUsuarioActivity.class);
       startActivity(tela_cadastro);
   }
}