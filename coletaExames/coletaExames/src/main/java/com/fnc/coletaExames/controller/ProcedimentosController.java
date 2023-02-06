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
@RequestMapping("api/procedimentos")
public class ProcedimentosController {

    @Autowired
    ProcedimentoService procedimentoService;

    @PostMapping
    public ResponseEntity<ProcedimentoModel> creat(@RequestBody ProcedimentoModel procedimento){

        procedimento = procedimentoService.addProcedimento(procedimento);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(uri).body(procedimento);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimentoModel>> getAll(){

       List<ProcedimentoModel> procedimentos = procedimentoService.getAll();

        return ResponseEntity.ok(procedimentos);
    }

    @GetMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>getById(@PathVariable Integer idProcedimento){

        ProcedimentoModel procedimento = procedimentoService.getById(idProcedimento);

        return ResponseEntity.ok(procedimento);
    }
    @DeleteMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>delete(@PathVariable Integer idProcedimento){

         procedimentoService.delete(idProcedimento);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{idProcedimento}")
    public ResponseEntity<ProcedimentoModel>update(@PathVariable Integer idProcedimento, @RequestBody ProcedimentoModel procedimento){

        ProcedimentoModel procedimentoAtualizado = procedimentoService.update(idProcedimento, procedimento);

        return ResponseEntity.ok(procedimentoAtualizado);
    }
}
