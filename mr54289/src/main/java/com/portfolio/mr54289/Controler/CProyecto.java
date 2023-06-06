package com.portfolio.mr54289.Controler;

import com.portfolio.mr54289.Dto.DtoProyecto;
import com.portfolio.mr54289.Entity.Proyecto;
import com.portfolio.mr54289.Security.Controller.Mensaje;
import com.portfolio.mr54289.Service.ProyectoService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins={"https://proyectoargprogr.web.app/","http://localhost:4200/"})//direccion del front de angular
public class CProyecto {
    
    @Autowired
    ProyectoService sProyecto;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
        return new ResponseEntity(new Mensaje ("El id no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    
    }
    
    @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproye){
    if(StringUtils.isBlank(dtoproye.getProyecto()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    if(sProyecto.existsByProyecto(dtoproye.getProyecto()))
        return new ResponseEntity(new Mensaje("Esa proyecto yaexiste"), HttpStatus.BAD_REQUEST);
    
    Proyecto proyecto = new Proyecto(dtoproye.getProyecto(), dtoproye.getDescripcion(), dtoproye.getUrl(), dtoproye.getImagen());
    sProyecto.save(proyecto);
    return new ResponseEntity(new Mensaje("Proyecto agregado"),HttpStatus.OK);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        
      if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sProyecto.delete(id);  
               return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproye){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sProyecto.existsByProyecto(dtoproye.getProyecto()) && sProyecto
                .getByProyecto(dtoproye.getProyecto()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoproye.getProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setProyecto(dtoproye.getProyecto());
        proyecto.setDescripcion(dtoproye.getDescripcion());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
}