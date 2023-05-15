package com.portfolio.mr54289.Security.Repository;

import com.portfolio.mr54289.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{

    /**
     *
     * @param nombreUsuario
     * @return
     */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
     boolean existsByEmail(String email);
}

