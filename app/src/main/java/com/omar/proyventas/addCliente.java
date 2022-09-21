package com.omar.proyventas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omar.proyventas.db.DbCliente;

public class addCliente extends AppCompatActivity {

    EditText txtCi, txtNombre, txtTelefono, txtCorreo;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);

        txtCi=findViewById(R.id.txtCi);
        txtNombre=findViewById(R.id.txtNombre);
        txtCorreo=findViewById(R.id.txtEmail);
        txtTelefono=findViewById(R.id.txtPhone);
        btnGuardar=findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbCliente dbCliente= new DbCliente(addCliente.this);
                long id=dbCliente.insertarCliente(txtCi.getText().toString(), txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if (id>0){
                    Toast.makeText(addCliente.this, "Registro Guardado", Toast.LENGTH_LONG ).show();
                    limpiar();
                }else {
                    Toast.makeText(addCliente.this, "Error al Guardar", Toast.LENGTH_LONG ).show();

                }

            }
        });

    }
    private void limpiar(){
        txtCi.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
}