package com.example.Sesiones456.controllers;

import com.example.Sesiones456.entities.LapTop;
import com.example.Sesiones456.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LapTopController {

    // atributo
    LaptopRepository laptopRepository;

    // constructor
    public LapTopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // metodos CRUD
    /**
     * findAll
     * @return
     */
    @GetMapping("/api/laptops")
    public List<LapTop>findAll() {
       return laptopRepository.findAll();
    }

    /**
     * findOneById
     */
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity findOneById(@PathVariable Long id){

      Optional<LapTop> lapTopOpt = laptopRepository.findById(id);

      if(lapTopOpt.isPresent())
          return ResponseEntity.ok(lapTopOpt.get());
      else
          return ResponseEntity.notFound().build();
    }

    /**
     * create
     * @param lapTop
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<LapTop> create(@RequestBody LapTop lapTop) {
        if (lapTop.getId() != null)  return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(laptopRepository.save(lapTop));
    }

    /**
     * actualizar
     * @param lapTop
     * @return
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<LapTop> update(@RequestBody LapTop lapTop){
        if(lapTop.getId()==null) return ResponseEntity.badRequest().build();
        if(laptopRepository.existsById(lapTop.getId())) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(laptopRepository.save(lapTop));
    }

    /**
     * Borrar todos
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<LapTop> delete(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Borrar por id
     * @param id
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<LapTop> deletebyId(@PathVariable Long id){
        if(!laptopRepository.existsById(id)) return ResponseEntity.badRequest().build();
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
