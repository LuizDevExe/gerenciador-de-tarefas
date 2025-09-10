package com.luiz.CadastroDeTarefas.tarefa;


import com.luiz.CadastroDeTarefas.funcionario.FuncionarioModel;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date prazo;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;


    @OneToMany(mappedBy = "tarefa")
    private List<FuncionarioModel> funcionarios;

    private enum Prioridade{
        BAIXA("Baixa"),
        MEDIA("Media"),
        URGENTE("Urgente");

        private String descricao;

        Prioridade(String descricao){
            this.descricao = descricao;
        }
    }
}
