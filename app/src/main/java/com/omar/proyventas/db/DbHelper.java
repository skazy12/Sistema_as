package com.omar.proyventas.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DbHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE ="sistemita.db";
    public static final String TABLE_CLIENTE ="cliente";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_CLIENTE+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "ci TEXT NOT NULL,"+
                "nombre TEXT NOT NULL,"+
                "telefono TEXT NOT NULL,"+
                "correo TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CLIENTE);
        onCreate(db);
    }
}
