package cl.inacap.Covit.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacienteSqlitehelper extends SQLiteOpenHelper {

    private final String sqlCreate= "CREATE TABLE " +
            "paciente (rut TEXT PRIMARY KEY " +
            ",nombre TEXT" +
            ",apellido TEXT" +
            ",fecha TEXT" +
            ",area TEXT" +
            ",covit TEXT" +
            ",temperatura DOUBLE" +
            ",tos TEXT" +
            ",presion INTEGER)";

    public PacienteSqlitehelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  paciente");
        sqLiteDatabase.execSQL(sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO  paciente (rut, nombre, apellido, fecha, area, covit, temperatura, tos, presion )" +
                "VALUES( '20360409-K'  , 'Pedro Pablo'  , 'Alfaro Maldonado', '15/11/2020' , 'Otro', 'FALSE', 32.3 , 'FALSE', 87)");
    }
}
