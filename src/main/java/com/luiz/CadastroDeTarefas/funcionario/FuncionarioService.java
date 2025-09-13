package com.luiz.CadastroDeTarefas.funcionario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel listarFuncionarioPorId(Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElse(null);
    }
}
