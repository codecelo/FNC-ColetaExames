package com.fnc.coletaExames.service;

import com.fnc.coletaExames.database.MockDatabase;
import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.model.ProcedimentoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedimentoService {


    public ProcedimentoModel addProcedimento(ProcedimentoModel procedimento){


        if (MockDatabase.getProcedimentos().isEmpty())
            procedimento.setCodigo(1);
        else{
            var ultimoCodigo = MockDatabase.getProcedimentos().stream()
                    .mapToInt(ProcedimentoModel::getCodigo)
                    .max()
                    .getAsInt();

            procedimento.setCodigo(ultimoCodigo + 1);
        }

        MockDatabase.getProcedimentos().add(procedimento);

        return procedimento;
    }
    public List<ProcedimentoModel> getAll(){
        return MockDatabase.getProcedimentos();
    }

    public ProcedimentoModel getById(Integer id){
        return MockDatabase.getProcedimentos().stream()
                .filter(p->  p.getCodigo() == id)
                .findFirst().get();
    }

    public boolean delete(Integer id){
        ProcedimentoModel procedimento = getById(id);

        MockDatabase.getProcedimentos().remove(procedimento);

        return true;
        
    }

    public ProcedimentoModel update(Integer id, ProcedimentoModel procedimento){
        ProcedimentoModel procedimentoAtual = getById(id);

        procedimentoAtual.setNome(procedimento.getNome());
        procedimentoAtual.setPrazoMaximo(procedimento.getPrazoMaximo());

        return procedimentoAtual;
    }
}
