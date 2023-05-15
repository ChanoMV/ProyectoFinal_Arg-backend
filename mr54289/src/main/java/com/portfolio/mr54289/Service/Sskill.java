/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package com.portfolio.mr54289.Service;

import com.portfolio.mr54289.Entity.Skill;
import com.portfolio.mr54289.Repository.Rskill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sskill {
    @Autowired
    Rskill rskill;
    
    public List<Skill> List(){
        return rskill.findAll();
    }
    public Optional<Skill>getOne(int id){
        return rskill.findById(id);
    }   
    public Optional<Skill>getByNombreSK(String nombreSK){
        return rskill.findByNombreSK(nombreSK);
    }    
      public void save(Skill skill){
          rskill.save(skill);
      }  
    public void delete(int id){
        rskill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rskill.existsById(id);
    }
    public boolean existsByNombreSK(String nombreSK){
        return rskill.existsByNombreSK(nombreSK);
    }
} 

