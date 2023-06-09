/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.portfolio.mr54289.Repository;

import com.portfolio.mr54289.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rskill extends JpaRepository<Skill, Integer> {
    
     public Optional<Skill>findByNombreSK(String nombreSK);
    public boolean existsByNombreSK(String nombreSK);
}

