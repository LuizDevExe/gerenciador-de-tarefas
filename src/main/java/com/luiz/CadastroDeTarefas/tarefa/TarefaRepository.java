package com.luiz.CadastroDeTarefas.tarefa;

import org.hibernate.query.criteria.JpaCollectionJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
