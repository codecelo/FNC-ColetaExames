package com.fnc.coletaExames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ExameModel {
    private PacienteModel paciente;
    private List<ProcedimentoModel> procedimentos;

    }

