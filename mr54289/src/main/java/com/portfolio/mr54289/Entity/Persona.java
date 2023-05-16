
package com.portfolio.mr54289.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



 
@Entity
public class Persona {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size( min= 1, max= 50, message= "No cumple con la longitud")
    private String nombreAC;
    
    @NotNull
    @Size( min= 1, max= 50, message= "No cumple con la longitud")
    private String apellidoAC;
    
    @NotNull
    private String descripcionAC;
    
   
    private String img;   

    public Persona() {
    }

    public Persona(String nombreAC, String apellidoAC, String descripcionAC, String img) {
        this.nombreAC = nombreAC;
        this.apellidoAC = apellidoAC;
        this.descripcionAC = descripcionAC;
        this.img = img;
    }

    public String getDescripcionAC() {
        return descripcionAC;
    }

    public void setDescripcionAC(String descripcionAC) {
        this.descripcionAC = descripcionAC;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAC() {
        return nombreAC;
    }

    public void setNombreAC(String nombreAC) {
        this.nombreAC = nombreAC;
    }

    public String getApellidoAC() {
        return apellidoAC;
    }

    public void setApellidoAC(String apellidoAC) {
        this.apellidoAC = apellidoAC;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    
    
    
    
    
    
    
 }
