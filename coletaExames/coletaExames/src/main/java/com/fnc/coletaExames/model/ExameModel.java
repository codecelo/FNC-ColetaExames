package com.fnc.coletaExames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ExameModel {
    private Date dataColeta;

    private PacienteModel paciente;
    private List<ProcedimentoModel> procedimentos;

    public Date getDataEntrega() {
        var prazoMaximo = Collections.max(procedimentos.stream()
                .map(ProcedimentoModel::getPrazoMaximo)
                .toList());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataColeta);

        calendar.add(Calendar.DATE, prazoMaximo);

        if(calendar.get(Calendar.DAY_OF_WEEK) == 7)
            calendar.add(Calendar.DATE, 1);
        else if(calendar.get(Calendar.DAY_OF_WEEK) == 6)
            calendar.add(Calendar.DATE, 2);
        return calendar.getTime();

    }
}