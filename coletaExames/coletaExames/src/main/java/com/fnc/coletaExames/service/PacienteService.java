package com.fnc.coletaExames.service;

import com.fnc.coletaExames.database.MockDatabase;
import com.fnc.coletaExames.model.PacienteModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {


    public PacienteModel addPaciente(PacienteModel paciente){

        MockDatabase.getPacientes().add(paciente);

        return paciente;
    }
    public List<PacienteModel>getAll(){
        return MockDatabase.getPacientes();
    }

    public PacienteModel getPacienteById(String id){
        return MockDatabase.getPacientes().stream()
                .filter(p -> p.getCpf().equals(id)) //pegando paciente "p", comparando(equals) com o cpf(id)
                .findFirst()//dps de filtrado, pegou o primeiro
                .get();
    }

    public PacienteModel update(String id, PacienteModel paciente){
        delete(id);

        return addPaciente(paciente);

    }
    public boolean delete(String id){
        var paciente =getPacienteById(id);

        MockDatabase.getPacientes().remove(paciente);
        return true;
    }
}
