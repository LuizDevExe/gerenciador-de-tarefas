package com.luiz.CadastroDeTarefas.tarefa;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;
    private TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    // Lista todas as tarefas
    public List<TarefaDTO> listarTarefas() {
        List<TarefaModel> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(tarefaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Lista Tarefa por id
    public TarefaDTO listarTarefaPorId(Long id) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(id);
        return tarefa.map(tarefaMapper::toDTO).orElse(null);
    }

    // Cria tarefa
    public TarefaDTO criarTarefa(TarefaDTO TarefaDTO) {
        TarefaModel tarefaModel = tarefaMapper.toEntity(TarefaDTO);
        tarefaModel = tarefaRepository.save(tarefaModel);
        return tarefaMapper.toDTO(tarefaModel);
    }

    // Deleta a tarefa
    public void  deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    // Atualiza a tarefa
    public TarefaDTO atualizarTarefaPorId(Long id , TarefaDTO tarefaDTO) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(id);

        if(tarefa.isPresent()) {
            TarefaModel tarefaAtualizada = tarefaMapper.toEntity(tarefaDTO);
            tarefaAtualizada.setId(id);

            tarefaRepository.save(tarefaAtualizada);

            return tarefaMapper.toDTO(tarefaAtualizada);
        }
        return null;
    }
}
