package com.luiz.CadastroDeTarefas.tarefa;

import org.hibernate.query.criteria.JpaCollectionJoin;

public interface TarefaRepository extends JpaCollectionJoin<TarefaModel, Long> {
}
