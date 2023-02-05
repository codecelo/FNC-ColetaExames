package com.fnc.coletaExames.service;

import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.model.ProcedimentoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedimentoService {

    List<ProcedimentoModel> procedimentos;
    public ProcedimentoModel addProcedimento(PacienteModel paciente, ProcedimentoModel procedimento){
        if(procedimentos == null)
            procedimentos = new ArrayList<>();

        if (procedimentos.isEmpty())
            procedimento.setCodigo(1);
        else{
            var ultimoCodigo = procedimentos.stream()
                    .mapToInt(ProcedimentoModel::getCodigo)
                    .max()
                    .getAsInt();

            procedimento.setCodigo(ultimoCodigo + 1);
        }

        procedimento.setPaciente(paciente);

        procedimentos.add(procedimento);

        return procedimento;
    }
    public List<ProcedimentoModel> getAll(PacienteModel paciente){
        return procedimentos.stream()
                .filter(p-> p.getPaciente().getCpf().equals(paciente.getCpf()))
                .toList();
    }

    public ProcedimentoModel getById(PacienteModel paciente, Integer id){
        return procedimentos.stream()
                .filter(p-> p.getPaciente().getCpf().equals(paciente.getCpf()) && p.getCodigo() == id)
                .findFirst().get();
    }

    public boolean delete(PacienteModel paciente, Integer id){
        ProcedimentoModel procedimento = getById(paciente, id);

        procedimentos.remove(procedimento);

        return true;
        
    }

    public ProcedimentoModel update(PacienteModel paciente, Integer id, ProcedimentoModel procedimento){
        ProcedimentoModel procedimentoAtual = getById(paciente, id);

        procedimentoAtual.setNome(procedimento.getNome());
        procedimentoAtual.setPrazoMaximo(procedimento.getPrazoMaximo());

        return procedimentoAtual;
    }
}
