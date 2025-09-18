package com.luiz.CadastroDeTarefas.funcionario;

import com.luiz.CadastroDeTarefas.tarefa.TarefaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private TarefaModel tarefa;
}
