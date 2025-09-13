package com.luiz.CadastroDeTarefas.funcionario;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Listar todos os funcionarios

    public List<FuncionarioModel>  listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

}
