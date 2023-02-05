package com.fnc.coletaExames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteModel {
    private String nome;
    private String email;
    private String cpf;

}
