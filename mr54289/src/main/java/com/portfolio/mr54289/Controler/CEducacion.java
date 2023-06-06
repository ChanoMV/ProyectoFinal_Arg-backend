package com.portfolio.mr54289.Controler;

import com.portfolio.mr54289.Dto.DtoEducacion;
import com.portfolio.mr54289.Entity.Educacion;

import com.portfolio.mr54289.Security.Controller.Mensaje;
import com.portfolio.mr54289.Service.SEducacion;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("edu")
@CrossOrigin (origins = {"https://proyectoargprogr.web.app/", "http://localhost:4200/"})
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.List();
        return new ResponseEntity(list, HttpStatus.OK);
    } 
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu){
    if(StringUtils.isBlank(dtoedu.getNombreEdu()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()))
        return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
    
    Educacion educacion = new Educacion(dtoedu.getNombreEdu(), dtoedu.getDescripcionEdu());
    sEducacion.save(educacion);
    return new ResponseEntity(new Mensaje("Educacion agregada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()) && sEducacion
                .getByNombreEdu(dtoedu.getNombreEdu()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoedu.getNombreEdu());
        educacion.setDescripcionEdu(dtoedu.getDescripcionEdu());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        
      if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sEducacion.delete(id);  
               return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
}
