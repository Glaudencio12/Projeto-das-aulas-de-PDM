package persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Usuario {

    private SQLiteOpenHelper bancoHelper;
    private SQLiteDatabase banco;

    private int id;
    private String nome;
    private String login;
    private String senha;
    private int categoria;

    public Usuario(Context context){
        bancoHelper = new Banco(context);
    }

    public void Cadastrar(){
        banco = bancoHelper.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", this.nome);
        dados.put("login", this.login);
        dados.put("senha", this.senha);
        dados.put("categoria", this.categoria);

        banco.insert("usuarios", null, dados);
        banco.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
