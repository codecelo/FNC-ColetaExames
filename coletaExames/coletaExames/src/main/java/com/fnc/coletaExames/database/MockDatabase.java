package com.fnc.coletaExames.database;

import com.fnc.coletaExames.model.ExameModel;
import com.fnc.coletaExames.model.PacienteModel;
import com.fnc.coletaExames.model.ProcedimentoModel;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase {
    public static List<PacienteModel> pacientes = new ArrayList<>();

    private static List<ExameModel> exames = new ArrayList<>();

    private static List<ProcedimentoModel> procedimentos = new ArrayList<>();

    public static List<ExameModel> getExames() {
        return exames;
    }

    public static List<PacienteModel> getPacientes() {
        return pacientes;

    }

    public static List<ProcedimentoModel> getProcedimentos() {
        return procedimentos;
    }


}
