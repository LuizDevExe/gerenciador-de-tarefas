package com.luiz.CadastroDeTarefas.funcionario;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel toEntity(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setCpf(funcionarioDTO.getCpf());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());
        funcionarioModel.setTarefa(funcionarioDTO.getTarefa());

        return funcionarioModel;
    }

    public FuncionarioDTO toDTO(FuncionarioModel funcionarioModel){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setCpf(funcionarioModel.getCpf());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());
        funcionarioDTO.setTarefa(funcionarioModel.getTarefa());

        return funcionarioDTO;
    }
}
