/*CREAMOS USUARIO-CONTRASEÑA CON LOGICA DE AUTENTICAR */

package com.example;

public class Usuario implements Autenticable{

    // ATRIBUTOS PRIVADOS DE LA CLASE
private String nombre;
private String contraseña;

//CONSTRUCTOR
public Usuario(String nombre,String contraseña){
this.nombre=nombre;
this.contraseña=contraseña;

}
  // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para contraseña
    public String getContraseña() {
        return contraseña;
    }

    // Setter para contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //SOBRE ESCRIBIMOS EL METODO DE AUTENTICAR DONDE COMAPRA LOS PARAMETROS (RETORNA TRUE SI LAS CREDENCIALES SON IGUALES,SI NO LO SON RETORNA FALSE) 
    @Override
    public boolean autenticar(String usuario,String contraseña){

return this.nombre.equals(usuario) && this.contraseña.equals(contraseña);

    }




}






