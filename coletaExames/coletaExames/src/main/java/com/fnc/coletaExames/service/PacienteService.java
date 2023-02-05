package com.fnc.coletaExames.service;

import com.fnc.coletaExames.model.PacienteModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private List<PacienteModel> pacientes;
    public PacienteModel addPaciente(PacienteModel paciente){
        if(pacientes == null)
            pacientes =new ArrayList<>();

        pacientes.add(paciente);

        return paciente;
    }
    public List<PacienteModel>getAll(){
        return pacientes;
    }

    public PacienteModel getPacienteById(String id){
        return pacientes.stream()
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

        pacientes.remove(paciente);
        return true;
    }
}
