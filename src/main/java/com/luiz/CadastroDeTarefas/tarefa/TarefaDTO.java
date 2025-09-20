package com.luiz.CadastroDeTarefas.tarefa;

import com.luiz.CadastroDeTarefas.funcionario.FuncionarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {


    private Long id;
    private String nome;
    private Date prazo;
    private String prioridade;


}
