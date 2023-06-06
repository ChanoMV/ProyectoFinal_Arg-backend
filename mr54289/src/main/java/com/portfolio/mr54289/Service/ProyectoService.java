package com.portfolio.mr54289.Service;

import com.portfolio.mr54289.Entity.Proyecto;

import com.portfolio.mr54289.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class ProyectoService {

    @Autowired
    ProyectoRepository rProyecto;
    
    public List<Proyecto> List(){
        return rProyecto.findAll();
    }
    
    public Optional <Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }      
    
    public void save(Proyecto proye){
        rProyecto.save(proye);
    }
    
     public void delete(int id){
        rProyecto.deleteById(id);
    }
      public boolean existsByProyecto( String proyecto){
        return rProyecto.existsByProyecto(proyecto);
    }

           
   public Optional<Proyecto> getByProyecto(String proyecto){
        return rProyecto.findByProyecto(proyecto);
    }     
     
       public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
}
