package com.luiz.CadastroDeTarefas.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, Long> {
}
