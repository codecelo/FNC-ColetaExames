package com.fnc.coletaExames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteModel {
    private String nome;
    private String email;
    private String cpf;
}
