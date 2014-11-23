package com.example.findag.pantalla3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity1 extends Activity
{

    EditText edtNombre;
    EditText edtTelefono;

    // Definimos las variables que nos serviran para el control de nuestra Toast.
    final int noNomTelf = 1;
    final int noMatch = 2;

    // Definimos el ArrayList en el que guardaremos nuestros contactos.
    ArrayList<Contactos> insertContac = new ArrayList<Contactos>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        // Definimos los botones Guardar y Listar.
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        Button btnListar = (Button) findViewById(R.id.btnListar);

        // Definimos el OnClick del boton Guardar.
        btnGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                edtNombre = (EditText) findViewById(R.id.edtNombre);
                edtTelefono = (EditText) findViewById(R.id.edtTelefono);
                //Comprobamos que tanto el campo nombre y telefono estan cubiertos, si n lo estan salta la Toast.
                if (edtNombre.getText().toString().equals("") || edtTelefono.getText().toString().equals(""))
                {
                    showToast(noNomTelf);
                    return;
                }
                else
                {
                    insertContac.add(new Contactos(edtNombre.getText().toString(), edtTelefono.getText().toString()));

                    //Dejamos los campos del nombre y el telefono en blanco
                    edtNombre.setText("");
                    edtTelefono.setText("");
                }

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Este metodo recibira un entero que dependiendo del valor que lleve conseguiremos que se nos muestre una Toast con uno u otro mensaje.
    public void showToast(int comprueba)
    {
        Context context = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        CharSequence texto;

        Toast toast=null;

        if(comprueba == noNomTelf)
        {
            texto = getResources().getString(R.string.noNomTelf);
            toast = Toast.makeText(context, texto, duracion);
        }

        else if(comprueba == noMatch)
        {
            texto = getResources().getString(R.string.noMatch);
            toast = Toast.makeText(context, texto, duracion);
        }
        toast.show();
    }
}
