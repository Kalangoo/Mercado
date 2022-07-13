package br.senai.controller;

import br.senai.model.Supermercado;
import br.senai.service.SupermercadoServiceImpl;
import br.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupermercadoController {

    @Autowired
    SupermercadoServiceImpl supermercadoService;

    @GetMapping("/supermercadolist")
    public List<Supermercado> findAll(){return supermercadoService.findAll();}

    @GetMapping("/supermercado/{id}")
    public Optional<Supermercado> findById(@PathVariable long id){
        return supermercadoService.findById(id);
    }

    @PostMapping("/criarsupermercado")
    public Supermercado create(@RequestBody Supermercado supermercado){
        return supermercadoService.create(supermercado);
    }

    @PutMapping("/editarsupermercado/{id}")
    public Supermercado update(@RequestBody Supermercado usuario, @PathVariable long id){
        return supermercadoService.update(usuario, id);
    }

    @DeleteMapping("/deletesupermercado/{id}")
    public void delete(@PathVariable long id){
        supermercadoService.delete(id);
    }
}
