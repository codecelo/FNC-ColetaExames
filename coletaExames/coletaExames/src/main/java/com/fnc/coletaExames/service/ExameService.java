package com.fnc.coletaExames.service;

import com.fnc.coletaExames.database.MockDatabase;
import com.fnc.coletaExames.model.ExameModel;
import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.model.ProcedimentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    ProcedimentoService procedimentoService;

    @Autowired
    PacienteService pacienteService;

    public ExameModel add(ExameModel exame) throws Exception {
        if(!MockDatabase.getExames().isEmpty()) {
            if (MockDatabase.getExames().stream().anyMatch(e -> e.getPaciente().getCpf().equals(exame.getPaciente().getCpf())))
                throw new Exception("Exame já cadastrado para o paciente");
        }

        MockDatabase.getExames().add(exame);

        return exame;
    }
    public ExameModel getById(String id){
       var exame = MockDatabase.getExames()
               .stream()
               .filter(e -> e.getPaciente().getCpf().equals(id))
                .findFirst()
                .get();
        return exame;
    }
    public List<ExameModel> getAll(){
        return MockDatabase.getExames();
    }
    public boolean delete(String id){
        var exame =getById(id);
        MockDatabase.getExames().remove(exame);
        return true;
    }
    public ExameModel update(String id, ExameModel exameModel) throws Exception {
        if(exameModel.getPaciente().getCpf().equals(id))
            throw new Exception("Id informado invalido");
        delete(id);

        add(exameModel);
        return exameModel;

    }
}

