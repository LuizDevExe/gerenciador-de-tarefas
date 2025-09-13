package com.luiz.CadastroDeTarefas.tarefa;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;


    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
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
