/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mr54289.Dto;



import javax.validation.constraints.NotBlank;

public class DtoSkill {
    @NotBlank
     private String nombreSK;
    @NotBlank
  private int porcentaje;

    public DtoSkill() {
    }

    public DtoSkill(String nombreSK, int porcentaje) {
        this.nombreSK = nombreSK;
        this.porcentaje = porcentaje;
    }

    public String getNombreSK() {
        return nombreSK;
    }

    public void setNombreSK(String nombre) {
        this.nombreSK = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}

 