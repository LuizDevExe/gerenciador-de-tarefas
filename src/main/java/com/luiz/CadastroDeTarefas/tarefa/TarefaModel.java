package com.luiz.CadastroDeTarefas.tarefa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luiz.CadastroDeTarefas.funcionario.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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

    public enum Prioridade{
        BAIXA("Baixa"),
        MEDIA("Media"),
        URGENTE("Urgente");

        private String descricao;

        Prioridade(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }


        public static Prioridade fromString(String valor) {
            return Arrays.stream(Prioridade.values())
                    .filter(p -> p.name().equalsIgnoreCase(valor) ||
                            p.getDescricao().equalsIgnoreCase(valor))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Prioridade inválida: " + valor));
        }
    }
}
