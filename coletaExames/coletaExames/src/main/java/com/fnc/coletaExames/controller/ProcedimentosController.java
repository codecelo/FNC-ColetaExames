package com.fnc.coletaExames.controller;

import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.model.ProcedimentoModel;
import com.fnc.coletaExames.service.PacienteService;
import com.fnc.coletaExames.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/pacientes/{cpf}/procedimentos")
public class ProcedimentosController {

    @Autowired
    ProcedimentoService procedimentoService;
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<ProcedimentoModel> creat(@PathVariable String cpf, @RequestBody ProcedimentoModel procedimento){
       var paciente = pacienteService.getPacienteById(cpf);
        procedimento = procedimentoService.addProcedimento(paciente, procedimento);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(paciente.getCpf()).build().toUri();

        return ResponseEntity.created(uri).body(procedimento);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimentoModel>> getAll(@PathVariable String cpf){
        PacienteModel paciente = pacienteService.getPacienteById(cpf);

       List<ProcedimentoModel> procedimentos = procedimentoService.getAll(paciente);

        return ResponseEntity.ok(procedimentos);
    }

    @GetMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>getById(@PathVariable String cpf, @PathVariable Integer idProcedimento){

        PacienteModel paciente= pacienteService.getPacienteById(cpf);

        ProcedimentoModel procedimento = procedimentoService.getById(paciente, idProcedimento);

        return ResponseEntity.ok(procedimento);
    }
    @DeleteMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>delete(@PathVariable String cpf, @PathVariable Integer idProcedimento){

        PacienteModel paciente= pacienteService.getPacienteById(cpf);

         procedimentoService.delete(paciente, idProcedimento);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>update(@PathVariable String cpf, @PathVariable Integer idProcedimento, @RequestBody ProcedimentoModel procedimento){

        PacienteModel paciente= pacienteService.getPacienteById(cpf);

        ProcedimentoModel procedimentoAtualizado = procedimentoService.update(paciente, idProcedimento, procedimento);

        return ResponseEntity.ok(procedimentoAtualizado);
    }
}
