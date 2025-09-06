package com.luiz.CadastroDeTarefas.tarefa;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date prazo;

    @Enumerated(EnumType.STRING)
    private Priodidade priodidade;

    private enum Priodidade{
        BAIXA("Baixa"),
        MEDIA("Media"),
        URGENTE("Urgente");

        private String descricao;

        Priodidade(String descricao){
            this.descricao = descricao;
        }
    }
}
