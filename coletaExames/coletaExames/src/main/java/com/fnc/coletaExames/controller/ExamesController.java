package com.fnc.coletaExames.controller;

import com.fnc.coletaExames.model.ExameModel;
import com.fnc.coletaExames.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/exames")
public class ExamesController {
    @Autowired
    ExameService service;
    @PostMapping
    public ResponseEntity<ExameModel> create(@RequestBody ExameModel exame) throws Exception {

        service.add(exame);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(exame.getPaciente().getCpf())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(exame);

    }
    @GetMapping
    public ResponseEntity<List<ExameModel>> getAll(){
        var exames = service.getAll();

        return ResponseEntity.ok(exames);
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<ExameModel> getByid(@PathVariable String cpf){
        var exame = service.getById(cpf);

        return ResponseEntity.ok(exame);
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity<ExameModel> delete(@PathVariable String cpf){
        service.delete(cpf);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<ExameModel> update(@PathVariable String cpf, @RequestBody ExameModel exame) throws Exception {
        exame = service.update(cpf, exame);

        return ResponseEntity.ok(exame);
    }
}
