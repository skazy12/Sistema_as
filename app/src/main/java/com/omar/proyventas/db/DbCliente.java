package com.omar.proyventas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCliente extends DbHelper{
    Context context;
    public DbCliente(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarCliente(String ci, String nombre, String telefono, String correo){
        long id=0;
        try {
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db=dbHelper.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put("ci", ci);
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo", correo);
            id=db.insert(TABLE_CLIENTE, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;

    }
}
