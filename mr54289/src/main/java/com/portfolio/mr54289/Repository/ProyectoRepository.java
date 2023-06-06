
package com.portfolio.mr54289.Repository;

import com.portfolio.mr54289.Entity.Proyecto;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Integer>{
    public Optional<Proyecto> findByProyecto(String proyecto);
   public boolean existsByProyecto(String proyecto);
    
}
