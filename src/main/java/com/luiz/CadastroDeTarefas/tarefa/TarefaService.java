package com.luiz.CadastroDeTarefas.tarefa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public TarefaModel listarTarefaPorId(Long id) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }
}
