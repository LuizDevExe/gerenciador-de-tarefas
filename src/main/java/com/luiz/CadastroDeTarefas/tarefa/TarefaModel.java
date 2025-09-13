package com.luiz.CadastroDeTarefas.tarefa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luiz.CadastroDeTarefas.funcionario.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_tarefa")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date prazo;

    private String prioridade;

    @OneToMany(mappedBy = "tarefa")
    private List<FuncionarioModel> funcionarios;

}
