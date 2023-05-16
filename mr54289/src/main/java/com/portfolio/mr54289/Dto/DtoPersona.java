/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mr54289.Dto;


import javax.validation.constraints.NotBlank;



public class DtoPersona {
  
    
     @NotBlank
    private String nombreAC;
      @NotBlank
    private String apellidoAC;
       @NotBlank
    private String descripcionAC;
        @NotBlank
    private String img; 

    public DtoPersona() {
    }

    public DtoPersona(String nombreAC, String apellidoAC, String descripcionAC, String img) {
        this.nombreAC = nombreAC;
        this.apellidoAC = apellidoAC;
        this.descripcionAC = descripcionAC;
        this.img = img;
    }

    public String getNombreAC() {
        return nombreAC;
    }

    public void setNombreAC(String nombre) {
        this.nombreAC = nombre;
    }

    public String getApellidoAC() {
        return apellidoAC;
    }

    public void setApellidoAC(String apellido) {
        this.apellidoAC = apellido;
    }

    public String getDescripcionAC() {
        return descripcionAC;
    }

    public void setDescripcionAC(String descripcion) {
        this.descripcionAC = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
        

}
