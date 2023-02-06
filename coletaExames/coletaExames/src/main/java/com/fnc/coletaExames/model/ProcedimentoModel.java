package com.fnc.coletaExames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProcedimentoModel {
    private Integer codigo;
    private String nome;
    private Integer prazoMaximo;
}
