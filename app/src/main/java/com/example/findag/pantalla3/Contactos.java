package com.example.findag.pantalla3;

/**
 * Created by findag on 23/11/14.
 */
public class Contactos
{
    // Definimos las variables que tendremos.
    private String nombre;
    private String telefono;

    // Creamos un constructor vacio.
    public Contactos()
    {

    }

    // Creamos un constructor con parametros.
    public Contactos(String nombre, String telefono)
    {
        this.nombre = nombre;
        this.telefono = telefono;

    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
