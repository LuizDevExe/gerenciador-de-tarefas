package com.luiz.CadastroDeTarefas.funcionario;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    // Lista Todos os funcionários
    public List<FuncionarioDTO> listarFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(funcionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Lista  funcionário por ID
    public FuncionarioDTO listarFuncionarioPorId(Long id) {
        // Cria um optional salvando o valor do funcionário localizado por id
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);

        // Retorna um map do funcionário por id mapeado em dto ou um nulo
        return funcionarioPorId.map(funcionarioMapper::toDTO).orElse(null);
    }

    // Cria um novo funcionário
    public FuncionarioDTO salvarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.toEntity(funcionarioDTO);
        FuncionarioModel salvo = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(salvo);
    }

    // Deleta funcionario - Deletar é um metodo void
    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }


    // Atualiza Funcionario
    public FuncionarioDTO atualizarFuncionarioPorId(long id,  FuncionarioDTO funcicionarioDTO) {
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);

        if (funcionarioPorId.isPresent()) {
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.toEntity(funcicionarioDTO);
            funcionarioAtualizado.setId(id);

            FuncionarioModel funcionarioSalvo = funcionarioRepository.save(funcionarioAtualizado);
            return funcionarioMapper.toDTO(funcionarioSalvo);
        }

        return null;
    }
}
