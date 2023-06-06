
package com.portfolio.mr54289.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    
    @NotBlank
    private String proyecto;
    @NotBlank
    private String descripcion;
     @NotBlank
    private String imagen;
       @NotBlank
    private String url;

    public DtoProyecto() {
    }
    
    
    
    
    public DtoProyecto(String proyecto, String descripcion, String imagen, String url) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.imagen= imagen;
        this.url= url;
        
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
       public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
       public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}

