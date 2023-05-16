package com.portfolio.mr54289.Repository;

import com.portfolio.mr54289.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



 @Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
   public Optional<Persona> findByNombreAC(String nombreAC);
   public boolean existsByNombreAC(String nombreAC);
}
