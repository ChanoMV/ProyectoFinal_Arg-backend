
package com.portfolio.mr54289.Controler;

import com.portfolio.mr54289.Dto.DtoPersona;
import com.portfolio.mr54289.Entity.Persona;
import com.portfolio.mr54289.Security.Controller.Mensaje;
import com.portfolio.mr54289.Service.ImpPersonaService;
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
@RequestMapping("personas")
@CrossOrigin (origins = {"https://proyectoargprogr.web.app/", "http://localhost:4200/"})

public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.List();
        return new ResponseEntity(list, HttpStatus.OK);
    } 
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopers){
    if(StringUtils.isBlank(dtopers.getNombreAC()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    if(personaService.existsByNombreAC(dtopers.getNombreAC()))
        return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
    
    Persona persona = new Persona(dtopers.getNombreAC(), dtopers.getDescripcionAC(), dtopers.getApellidoAC(), dtopers.getImg());
    personaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona agregada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopers){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(personaService.existsByNombreAC(dtopers.getNombreAC()) && personaService
                .getByNombreAC(dtopers.getNombreAC()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopers.getNombreAC()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombreAC(dtopers.getNombreAC());
        persona.setDescripcionAC(dtopers.getDescripcionAC());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        
      if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        personaService.delete(id);  
               return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
}
