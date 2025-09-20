package com.luiz.CadastroDeTarefas.tarefa;

import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public TarefaModel toEntity(TarefaDTO tarefaDTO){
        TarefaModel tarefaModel = new TarefaModel();

        tarefaModel.setId(tarefaDTO.getId());
        tarefaModel.setNome(tarefaDTO.getNome());
        tarefaModel.setPrazo(tarefaDTO.getPrazo());
        tarefaModel.setPrioridade(TarefaModel.Prioridade.fromString(tarefaDTO.getPrioridade()));

        return tarefaModel;
    }

    public TarefaDTO toDTO(TarefaModel tarefaModel){
        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setId(tarefaModel.getId());
        tarefaDTO.setNome(tarefaModel.getNome());
        tarefaDTO.setPrazo(tarefaModel.getPrazo());
        tarefaDTO.setPrioridade(tarefaModel.getPrioridade().name());

        return tarefaDTO;
    }
}
