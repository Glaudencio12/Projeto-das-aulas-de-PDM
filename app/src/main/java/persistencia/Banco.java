package persistencia;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {

    public Banco(Context context) {
        super(context, "gerenciador", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user = "CREATE TABLE usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT,"+
                "login TEXT,"+
                "senha TEXT,"+
                "categoria INTEGER);";
        db.execSQL(user);

        String note = "CREATE TABLE tarefa(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descricao TEXT," +
                "data TEXT," +
                "status INT);";
        db.execSQL(note);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS tarefas");
        onCreate(db);
    }
}
