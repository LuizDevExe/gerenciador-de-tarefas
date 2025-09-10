package com.luiz.CadastroDeTarefas.funcionario;

import com.luiz.CadastroDeTarefas.tarefa.TarefaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_funcionarios")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String cargo_funcionario    ;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private TarefaModel tarefa;
}
