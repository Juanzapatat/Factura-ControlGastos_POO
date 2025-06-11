//REALIZAMOS FACTURA CON DESCRIPCION,VALOR,OPCION IVA,CONSUMIDOR FINAL, FECHA 

package com.example;

public class Factura extends Registro {

    //ATRIBUTOS PRIVADOR DE LA CLASE
    private boolean conIVA;
    private String fecha;
    private String consumidorFinal;
    private Integer ID;

    // CONSTRUCTOR
    public Factura(String descripcion, double valor, boolean conIVA, String fecha, String consumidorFinal,Integer ID) {

        //EN EL SUPER USAMOS UN OPERADOR TERM¿NARIO PARA DARLE EL VALOR AGREGADO DEL IVA AL VALOR "INICIAL" DE LA FACTURA SIEMPRE ICUANDO SE INDIQUE 

        super(descripcion, conIVA?valor*1.19:valor); //LLAMAMOS AL CONSTRUCTOR  DE LA CLASE PADRE REGISTRO PARA IMPLEMENTAR DICHOS ATRTIBUTOS
        this.conIVA = conIVA;
        this.fecha = fecha;
        this.consumidorFinal = consumidorFinal;
        this.ID=ID;
    }
    //GETTER Y SETTER PARA ID
    public Integer getID(){
        return ID;
    }

    public void setID(Integer ID){
        this.ID=ID;
    }

    // Getter y Setter para conIVA
    public boolean getConIVA() {
        return conIVA;
    }

    public void setConIVA(boolean conIVA) {
        this.conIVA = conIVA;
    }

    // Getter y Setter para fecha
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para consumidorFinal
    public String getConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(String consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

//SOBRE ESCRIBIMOS EL METODO MOSTRAR DE LA CLASE PADRE REGISTRO PARA SER IMPLEMENTADA Y SER VISTA EN LA FACTURA.
@Override
public void mostrar(){
System.out.println("-----FACTURA------");
System.out.println("ID:" +  getID());
System.out.println("Descripcion" + getDescripcion());
System.out.println("Fecha : " + fecha);
System.out.println("Valor Con IVA:" + getValor());
System.out.println("Consumidor Final:" + consumidorFinal);

//  USO DE GETTTER EN ESTA PARTE PARA RESPETAR ENCASPSULAMIENTO DE LA CLASE FACTURA, ADEMAS PARA MOSTRAR LOS RESULTADOS DE DICHOS ATRIBUTOS SE NECESITA LOS GETTER YA QUE SON ATRIBUTOS PRIVADOS DE LA CLASE PADRE REGISTRO

}





}
