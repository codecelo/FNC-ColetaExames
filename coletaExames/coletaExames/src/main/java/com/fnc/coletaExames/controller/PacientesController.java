package com.fnc.coletaExames.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacientesController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<PacienteModel>>find(){
        List<PacienteModel> pacientes = service.getAll();


        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PacienteModel>GetById(@PathVariable String cpf){
        var paciente= service.getPacienteById(cpf);

        return ResponseEntity.ok(paciente);
    }


    @PostMapping
    public ResponseEntity<PacienteModel>creat(@RequestBody PacienteModel paciente){
        service.addPaciente(paciente);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(paciente.getCpf()).build().toUri();

        return ResponseEntity.created(uri).body(paciente);
    }

    @PutMapping(path = "/{cpf}")
    public ResponseEntity<PacienteModel>update(@PathVariable String cpf, @RequestBody PacienteModel paciente){
        paciente=service.update(cpf, paciente);

        return ResponseEntity.ok(paciente);
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity<PacienteModel>deleteById(@PathVariable String cpf){
        service.delete(cpf);

        return ResponseEntity.ok().build();
    }
}