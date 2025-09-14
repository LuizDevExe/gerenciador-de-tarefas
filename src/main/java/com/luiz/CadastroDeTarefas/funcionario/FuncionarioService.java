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


    // Lista Todos os funcionários
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }


    // Lista  funcionário por ID
    public FuncionarioModel listarFuncionarioPorId(Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElse(null);
    }

    // Cria um novo funcionário
    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    // Deleta funcionario - Deletar é um metodo void
    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }


    // Atualiza Funcionario
    public FuncionarioModel atualizarFuncionarioPorId(long id,  FuncionarioModel funcionarioModel) {
        if (funcionarioRepository.existsById(id)){
            funcionarioModel.setId(id);
            return funcionarioRepository.save(funcionarioModel);
        }
        return null;
    }
}
