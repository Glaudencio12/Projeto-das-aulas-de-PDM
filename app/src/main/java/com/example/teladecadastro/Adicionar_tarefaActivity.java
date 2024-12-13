package com.example.teladecadastro;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import persistencia.Tarefa;

public class Adicionar_tarefaActivity extends AppCompatActivity {

    private EditText descricao;
    private EditText data;
    private EditText status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.adicionar_tarefa);

        this.descricao = findViewById(R.id.descricao);
        this.data = findViewById(R.id.data);
        this.status = findViewById(R.id.status);
    }

    public void salvar(View v){
        Tarefa tarefa = new Tarefa(this);
        tarefa.setDescricao(this.descricao.getText().toString());
        tarefa.setData(this.data.getText().toString());
        tarefa.setStatus(Integer.parseInt(this.status.getText().toString()));

       tarefa.Cadastrar();

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setMessage("Tarefa cadastrada com Sucesso");
        msg.setTitle("Cadastro de tarefa");
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        msg.create();
        msg.show();
    }

}